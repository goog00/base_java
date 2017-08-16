package com.sunteng.concurrency;

/**
 * Created by ST on 16-1-31.
 */
public class BasicThread {
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");

    }
}
