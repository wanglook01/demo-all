package com.wanglook01.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CompletableFutureService {

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5,
            30L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.DiscardOldestPolicy());

    private Integer getStock() {
        sleep(5000);
        return 1;
    }

    private Double getPrice() {
        return 1.0D;
    }

    private String getActivity() {
        return "满减";
    }

    public void getSku() {
        CompletableFuture<Integer> stockFuture = CompletableFuture.supplyAsync(this::getStock, executor);
        CompletableFuture<Double> priceFuture = CompletableFuture.supplyAsync(this::getPrice, executor);
        CompletableFuture<String> activityFuture = CompletableFuture.supplyAsync(this::getActivity, executor);
        //
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(stockFuture, priceFuture, activityFuture);
        System.out.println("111111111111");
    }


    public void getSku2() {

    }

    public static void main(String[] args) throws Exception {
        CompletableFutureService service = new CompletableFutureService();
        for (int i = 0; i < 15; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Future<Integer> stockFuture = executor.submit(service::getStock);
                    Integer i1 = stockFuture.get();
                    log.info("----------result:{}", i1);
                } catch (Exception e) {
                    log.error("----------error----------", e);
                }
            });
            thread.setName("并发userId:" + i);
            thread.start();
        }
        for (int i = 0; i < 600000; i++) {
            service.sleep(1);
        }
        log.error("----end----");
    }

    private void sleep(Integer millions) {
        try {
            Thread.sleep(millions);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
