package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 循环打印数字
 * 打印的结果是：
 * ji-Thread跳过
 * ji-Thread跳过
 * ji-Thread跳过
 * ji-Thread跳过
 * ji-Thread跳过
 * ji-Thread跳过
 * ji-Thread跳过
 * ji-Thread跳过
 * ji-Thread跳过
 * ji-Thread跳过
 * ou-Thread:0
 * ou-Thread跳过
 * ou-Thread跳过
 * ou-Thread跳过
 * ou-Thread跳过
 * ou-Thread跳过
 * ou-Thread跳过
 * ou-Thread跳过
 * 不符合预期且性能有极大的问题
 */
public class AqsLockTest1 {

    public static class NumService {
        //Lock lock = new ReentrantLock();使用非公平锁，实现不了循环打印，因为提前就会抢到锁
        Lock lock = new ReentrantLock(true);
        int i = 0;

        public void printOu() {
            try {
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
