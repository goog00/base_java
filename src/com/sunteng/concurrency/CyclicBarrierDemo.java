package com.sunteng.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ST on 16-2-4.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
       ExecutorService executorService =  Executors.newCachedThreadPool();
      final   CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for(int i = 0; i < 3; i++){
            Runnable rn = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random()*10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 线程 到达集合点1， 当前已有" + (cyclicBarrier.getNumberWaiting() +1) + "到达");

                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep((long) (Math.random()*10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 线程 到达集合点2， 当前已有" + (cyclicBarrier.getNumberWaiting() +1) + "到达");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }

            };

            executorService.execute(rn);
        }
    }
}
