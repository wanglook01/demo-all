package org.example;

public class ThreadPrint01 {



    public static void main(String[] args) {
        JiOuObj jiOuObj = new JiOuObj();
        Thread thread0 = new Thread(() -> {
            while (true) {
                jiOuObj.print0();
            }
        });
        thread0.setName("thread0");
        Thread thread1 = new Thread(() -> {
            while (true) {
                jiOuObj.print1();
            }
        });
        thread1.setName("thread1");
        thread0.start();
        thread1.start();
        Utils.sleep(10000);
    }



    //首先应该执行什么样的代码，线程的执行体，是包含锁操作的，比如什么时刻放弃锁，什么时刻竞争锁等
    //---抢到锁了就打印
    //---抢到锁了，但是发现不应该自己打印，那么就释放锁,不应该我做的事情,流程是：告诉别人谁去抢，然后释放锁，等待
    //---没有抢到就等待
    //如果分为2个方法就会很好写，一个怎么写呢？
    //但是不要包含循环的逻辑，这个逻辑是属于thread的，而不是执行体，枪锁要在循环中抢
    //我们不区分线程到底打印1，还是0，我们只要求2个线程循环打印即可
    //写的过程中又有了一些思考：
    //首先得有2个对象，一个锁，一个是int的值，也就是共享的值(必须适用对象，因为值传递的问题)
    //这两个都可以放在线程的执行体中，执行体直接定义成一个obj容器，而不是一个方法，也就是说一共3个对象呢
    //container不要和线程的main方法所在的容器耦合了，一定要区分开来
    //我们称之为：线程安全的容器，我们的目标就是写一个线程安全的容器，在容器内实现某些功能
    /*public void print0() {
        synchronized (objLock) {
            try {
                if (value == 1) {
                    objLock.notifyAll();
                    objLock.wait();
                }
                Utils.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ":" + value++);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void print1() {
        synchronized (objLock) {
            try {
                if (value == 0) {
                    objLock.notifyAll();
                    objLock.wait();
                }
                Utils.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ":" + value--);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }*/

    public static class JiOuObj{
        public final Object objLock = new Object();

        public static Integer value = 0;

        public void print0() {
            synchronized (objLock) {
                try {
                    if (value == 1) {
                        objLock.notifyAll();
                        objLock.wait();
                    }
                    Utils.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void print1() {
            synchronized (objLock) {
                try {
                    if (value == 0) {
                        objLock.notifyAll();
                        objLock.wait();
                    }
                    Utils.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + ":" + value--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    //写在一个方法中怎么处理呢？必须加入target'值，并且要处理value的这个逻辑
    //必须要有判断条件，什么时候执行什么操作，以及条件是否会变更
    public static class JiOuObjSingleMethod{
        public final Object objLock = new Object();

        public static int value = 0;

        //我们称之为外部条件，就是调用者要我们做的事情
        public void print(int targetValue) {
            synchronized (objLock) {
                try {
                    if (value != targetValue) {
                        objLock.notifyAll();
                        objLock.wait();
                    }
                    Utils.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + ":" + targetValue);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void print1() {
            synchronized (objLock) {
                try {
                    if (value == 0) {
                        objLock.notifyAll();
                        objLock.wait();
                    }
                    Utils.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + ":" + value--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
