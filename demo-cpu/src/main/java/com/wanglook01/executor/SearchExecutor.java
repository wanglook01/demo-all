package com.wanglook01.executor;

import java.util.concurrent.*;

public class SearchExecutor {

    public static class CustomArrayBlockQueue extends ArrayBlockingQueue<Runnable> {

        public CustomArrayBlockQueue(int capacity) {
            super(capacity);
        }

        @Override
        public boolean offer(Runnable runnable) {
            return false;
        }

        public boolean customOffer(Runnable runnable) {
            return super.offer(runnable);
        }
    }

    public static class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

        CustomArrayBlockQueue customArrayBlockQueue;

        public CustomRejectedExecutionHandler(CustomArrayBlockQueue customArrayBlockQueue) {
            this.customArrayBlockQueue = customArrayBlockQueue;
        }

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (!customArrayBlockQueue.customOffer(r)) {
                throw new RejectedExecutionException("拒绝");
            }
        }
    }

    public static CustomArrayBlockQueue customArrayBlockQueue = new CustomArrayBlockQueue(5);
    public static ThreadPoolExecutor customExecutorService = new ThreadPoolExecutor(
            2, 4, 10L, TimeUnit.MINUTES, customArrayBlockQueue,
            new CustomRejectedExecutionHandler(customArrayBlockQueue));
    public static ThreadPoolExecutor executorService = new ThreadPoolExecutor(
            2, 4, 10L, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 15; i++) {
            int index = i;
            customExecutorService.execute(()->{
                System.out.println(index);
            });
            Thread.sleep(1000);
        }

    }

}
