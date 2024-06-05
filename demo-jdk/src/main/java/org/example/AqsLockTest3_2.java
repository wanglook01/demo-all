package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 先判断，不满足先等待，调换了一下if-else的顺序
 * 2种方法都是对的
 */
public class AqsLockTest3_2 {

    public static class NumService {
        Lock lock = new ReentrantLock();
        Condition waitOuCondition = lock.newCondition();
        Condition waitJiCondition = lock.newCondition();
        int i = 0;

        public void printOu() {
            try {
                lock.lock();
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "跳过:" + i);
                    waitJiCondition.signalAll();
                    waitOuCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
                i++;
            } catch (Exception e) {
                //do nothing
            } finally {
                lock.unlock();
            }
        }

        public void printJi() {
            try {
                lock.lock();
                if (i % 2 != 1) {
                    System.out.println(Thread.currentThread().getName() + "跳过:" + i);
                    waitOuCondition.signalAll();
                    waitJiCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
                i++;
            } catch (Exception e) {
                //do nothing
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
