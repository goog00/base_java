package com.sunteng.concurrency;

/**
 * Created by ST on 16-1-31.
 */
public class MyThread implements Runnable{
    public MyThread(){
        System.out.println("线程创建了");
    }
    @Override
    public void run() {
        System.out.println("hello");
        Thread.yield();
    }
}
