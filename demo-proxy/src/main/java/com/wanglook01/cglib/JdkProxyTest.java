package com.wanglook01.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {

    public static void main(String[] args) {
        WorkTaskService workTaskService = new WorkTaskService();
        Object o = Proxy.newProxyInstance(WorkTaskService.class.getClassLoader(),
                WorkTaskService.class.getInterfaces(), new MineInvocationHandler(workTaskService));
        WorkTaskServiceInterface proxy = (WorkTaskServiceInterface) o;
        proxy.getName(11);
    }

    public static class MineInvocationHandler implements InvocationHandler {

        private WorkTaskServiceInterface target;

        public MineInvocationHandler(WorkTaskServiceInterface target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("前置...:" + method.getName());
            return method.invoke(target, args);
        }
    }

    public interface WorkTaskServiceInterface {
        void getName(Integer id);

        void getRemark(Integer id);
    }

    public static class WorkTaskService implements WorkTaskServiceInterface {
        @Override
        public void getName(Integer id) {
            getRemark(id);
            System.out.println("getName");
        }

        @Override
        public void getRemark(Integer id) {
            System.out.println("remark");
        }
    }
}
