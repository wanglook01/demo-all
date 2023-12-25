package com.wanglook01.observable;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.beans.PropertyChangeSupport;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class BeanMethodInterceptor implements MethodInterceptor {

    private PropertyChangeSupport pcs;

    private List<String> observablePropList;

    public void setTarget(PropertyChangeSupport pcs, List<String> observablePropList) {
        this.pcs = pcs;
        this.observablePropList = observablePropList == null ? new ArrayList<>() : observablePropList;
    }

    private Object tryForGetter(String setterName, Object target) {
        String getterName = "get" + setterName.substring(3);
        try {
            return target.getClass().getMethod(getterName, new Class<?>[]{}).invoke(target, (Object[]) null);
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();
        boolean isSetter = (methodName.startsWith("set") && args.length == 1 && method.getReturnType() == Void.TYPE);
        String propName = Character.toLowerCase(methodName.charAt(3)) + methodName.substring(4);
        Object oldValue = null;
        //执行之前获取旧值
        if (isSetter && observablePropList.contains(propName)) {
            oldValue = this.tryForGetter(methodName, target);
        }
        //执行
        Object targetReturn = null;
        if (!Modifier.isAbstract(method.getModifiers())) {
            targetReturn = proxy.invokeSuper(target, args);
        }
        //执行之后发送事件
        if (isSetter && observablePropList.contains(propName)) {
            this.pcs.firePropertyChange(getLocation() + "|" + propName, oldValue, args[0]);
        }
        return targetReturn;
    }

    private String getLocation() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stack : stackTrace) {
            if (stack.getClassName().startsWith("com.")) {
                if (stack.getClassName().equals(BeanMethodInterceptor.class.getName())) {
                    continue;
                }
                if (stack.getClassName().contains("CGLIB")) {
                    continue;
                }
                return stack.toString();
            }
        }
        return "";
    }

}