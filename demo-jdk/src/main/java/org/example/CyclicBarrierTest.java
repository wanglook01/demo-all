package org.example;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) throws Exception{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Thread thread1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ":start");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + ":end");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "thread1");
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ":start");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + ":end");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "thread2");
        Thread thread3 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ":start");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + ":end");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "thread3");
        Thread thread4 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ":start");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + ":end");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "thread4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
        }
    }
}
