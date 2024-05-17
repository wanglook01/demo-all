package org.example.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil {

    private static final ExecutorService ex = new ThreadPoolExecutor(20, 20, 100, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100));

    public static void run(Runnable runnable) {
        ex.submit(runnable);
    }

}
