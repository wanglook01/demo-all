package org.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchTest {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        AtomicInteger integer = new AtomicInteger(0);
        Thread thread1 = new Thread(() -> {
            try {
                if (integer.get() < 3) {
                    System.out.println(Thread.currentThread().getName() + ":等待");
                    countDownLatch.await();
                }
                System.out.println(Thread.currentThread().getName() + ":" + integer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "thread1");
        Thread thread2 = new Thread(() -> {
            try {
                if (integer.get() < 3) {
                    System.out.println(Thread.currentThread().getName() + ":等待");
                    countDownLatch.await();
                }
                System.out.println(Thread.currentThread().getName() + ":" + integer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "thread2");
        thread1.start();
        thread2.start();
        Thread thread3 = new Thread(() -> {
            integer.incrementAndGet();
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + ":countDown");
        }, "thread3");
        Thread thread4 = new Thread(() -> {
            integer.incrementAndGet();
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + ":countDown");
        }, "thread4");
        Thread thread5 = new Thread(() -> {
            integer.incrementAndGet();
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + ":countDown");
        }, "thread5");
        thread3.start();
        thread4.start();
        thread5.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
        }

    }
}
