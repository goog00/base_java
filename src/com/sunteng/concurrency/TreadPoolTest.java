package com.sunteng.concurrency;

import java.util.concurrent.*;

/**
 * Created by ST on 16-2-2.
 */
public class TreadPoolTest {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(3);
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 10; i++) {
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(Thread.currentThread().getName() + "is loop of " + i + " task of " + task);
                    }

                }
            });
        }

        System.out.println("commited");

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("bombing");
            }
        },
                10,
                2,
                TimeUnit.SECONDS);

    }
}
