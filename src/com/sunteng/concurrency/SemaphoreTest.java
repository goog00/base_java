package com.sunteng.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by ST on 16-2-4.
 */
public class SemaphoreTest {

    public static void main(String[] args){
        final  Semaphore sp = new Semaphore(3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < 10; i++){
            Runnable rn = new Runnable() {
                @Override
                public void run() {
                    try {
                        sp.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前线程" + Thread.currentThread().getName() + "已进入，并发" + (3 - sp.availablePermits()) +"个线程");

                    try {
                        Thread.sleep(new Random().nextInt(200));
                    } catch (InterruptedException e) {

                    }

                    System.out.println("线程：" + Thread.currentThread().getName() + "即将离开");
                    sp.release();
                    System.out.println("线程：" + Thread.currentThread().getName() + "已离开离开，并发" + (3 - sp.availablePermits()) + "个线程");
                }


             };
            executorService.execute(rn);
        }


    }

}
