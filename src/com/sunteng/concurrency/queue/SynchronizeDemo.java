package com.sunteng.concurrency.queue;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by ST on 16-2-7.
 *
 * 功能描述：10个线程 每秒钟 按顺序消费 数据，
 */
public class SynchronizeDemo {

    public static void main(String[] args){

     final  Semaphore semaphore = new Semaphore(1);

        /**
         * SynchronousQueue
         *A blocking queue in which each insert operation must wait for a corresponding remove operation by another thread
         */
     final SynchronousQueue queue = new SynchronousQueue();


        for(int i = 0; i < 10 ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        Integer k  = (Integer) queue.take();
                        TestDo.doSome(k);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


        for(int i = 0; i < 10; i++){
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TestDo{
    public static void doSome(int i) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + ":" + i + ":" + (System.currentTimeMillis()/1000));
    }
}
