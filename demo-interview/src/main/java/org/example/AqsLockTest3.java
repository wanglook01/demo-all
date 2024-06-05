package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition测试
 */
public class AqsLockTest3 {




    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread thread = new Thread(() -> {
            System.out.println("---");
            try {
                lock.lock();
                condition.await();
                System.out.println("----------");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.setName("thread-1");
        thread.start();
        Thread.sleep(1000);
        lock.lock();
        System.out.println("===");
        condition.signal();
        lock.unlock();
        Thread.sleep(2000);
    }

}
