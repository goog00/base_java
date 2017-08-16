package com.sunteng.concurrency;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ST on 16-2-1.
 */
public class TraditionTimerTest {
    public static void main(String[] args){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing");
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("bombing2");
                    }
                },1000,3000);
            }
        },2000,1000);
    }
}
