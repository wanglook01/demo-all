package org.example;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.lang.ref.WeakReference;
import java.util.concurrent.*;

public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,10L, TimeUnit.MINUTES,new ArrayBlockingQueue<>(10));
        Future<String> submit = threadPoolExecutor.submit(() -> {
            return "";
        });
        String s = submit.get();
        System.out.println(s);
        //
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {

        });
        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.allOf(voidCompletableFuture);
        Void unused = voidCompletableFuture1.get();

    }


}
