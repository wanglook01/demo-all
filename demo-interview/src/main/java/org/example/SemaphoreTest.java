package org.example;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) throws Exception{
        Semaphore semaphore = new Semaphore(10);
        /*semaphore.acquire();
        semaphore.release();
        semaphore.equals()*/
        int oldCapacity = 10;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println((oldCapacity >> 1));
        System.out.println(newCapacity);
    }
}
