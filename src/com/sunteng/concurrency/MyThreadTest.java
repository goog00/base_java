package com.sunteng.concurrency;

/**
 * Created by ST on 16-1-31.
 */
public class MyThreadTest {

    public static void main(String[] args){
//        for(int i = 0; i < 3; i++){
//            Thread thread = new Thread(new MyThread());
//            thread.run();
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("runnable" + Thread.currentThread());
                }
            }
        }){
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread" + Thread.currentThread());
                }
            }
        }.start();
    }

}
