package com.sunteng.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by ST on 16-2-2.
 */
public class BeeperControl {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
            @Override
            public void run() {
                System.out.println("beep");
            }
        };

        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {

                beeperHandle.cancel(true);
                System.out.println("cancel 定时任务");

            }
        },
                30 ,
                TimeUnit.SECONDS);
    }

    public static void main(String[] args){
        BeeperControl beeperControl = new BeeperControl();
        beeperControl.beepForAnHour();
    }
}
