package com.sunteng.concurrency;

/**
 * Created by ST on 16-1-31.
 */
public class MainThread {

    public static void  main(String[] args){

        LiftOff launch = new LiftOff();
        launch.run();
    }
}
