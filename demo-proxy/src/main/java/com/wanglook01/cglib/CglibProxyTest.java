package com.wanglook01.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyTest {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\tmp");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(WorkTaskService.class);
        enhancer.setCallback(new MineMethodInterceptor());
        //创建代理类
        WorkTaskService serviceProxy = (WorkTaskService) enhancer.create();
        serviceProxy.getName(12);
    }

    public static class MineMethodInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o,
                                Method method,
                                Object[] args,
                                MethodProxy methodProxy) throws Throwable {
            System.out.println("前置：" + method.getName());
            return methodProxy.invokeSuper(o, args);
        }
    }

    public static class WorkTaskService {

        public void getName(Integer id) {
            getRemark(id);
            System.out.println("getName");
        }


        public void getRemark(Integer id) {
            System.out.println("remark");
        }

    }
}
