package org.example;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 加一个睡眠更能看到问题
 * D:\apps\JDK8\bin\java.exe
 * ji-Thread跳过
 * ji-Thread跳过
 * ou-Thread:0
 * ji-Thread:1
 * ou-Thread:2
 * ji-Thread:3
 * ou-Thread:4
 * ji-Thread:5
 * ou-Thread:6
 * ji-Thread:7
 * ou-Thread:8
 * ji-Thread:9
 * ji-Thread跳过
 * ou-Thread:10
 * ou-Thread跳过
 * ji-Thread:11
 * ou-Thread:12
 * ji-Thread:13
 * ou-Thread:14
 * ou-Thread跳过
 *
 * Process finished with exit code 0
 * 问题1：无论是公平锁还是非公平锁，只能唤醒，而不能通知
 * 问题2、上下文切换消耗性能
 * 问题3：外层的fori不是循环10次，是每一个线程循环10次，所以一共打印出来了20个结果
 */
public class AqsLockTest1_1 {

    public static void sleep(){
        try {
            Random random = new Random();
            int randomNumber = random.nextInt(11);
            Thread.sleep(randomNumber*100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static class NumService {
        Lock lock = new ReentrantLock(true);
        int i = 0;

        public void printOu() {
            try {
                sleep();
                lock.lock();
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                } else {
                    System.out.println(Thread.currentThread().getName() + "跳过");
                }
            } finally {
                lock.unlock();
            }
        }

        public void printJi() {
            try {
                sleep();
                lock.lock();
                if (i % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                } else {
                    System.out.println(Thread.currentThread().getName() + "跳过");
                }
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        NumService numService = new NumService();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                numService.printJi();
            }
        });
        thread1.setName("ji-Thread");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                numService.printOu();
            }
        });
        thread2.setName("ou-Thread");
        thread2.start();

        Thread.sleep(50000);
    }

}
