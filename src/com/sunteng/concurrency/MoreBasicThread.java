package com.sunteng.concurrency;

/**
 * Created by ST on 16-1-31.
 */
public class MoreBasicThread {
    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            new Thread(new LiftOff()).start();
            System.out.println("Waiting for LiftOff");
        }
    }
}
