package com.sunteng.concurrency.read;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by ST on 16-2-7.
 */
public class Test {

    public  static void main(String[] args) throws InterruptedException {

        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(4);


        for(int i = 0; i < 4; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            String log =  queue.take();
                            Test.printLog(log);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        System.out.println("begain : " + (System.currentTimeMillis()/1000));
        for(int i = 0; i < 16; i++){

            final String log = "" + (i +1);

            {
//                Test.printLog(log);
                queue.put(log);
            }

        }

    }

    public static void printLog(String log){
        System.out.println(log + ":" +(System.currentTimeMillis()/1000));
    }


}
