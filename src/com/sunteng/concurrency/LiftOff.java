package com.sunteng.concurrency;

/**
 * Created by ST on 16-1-31.
 */
public class LiftOff implements Runnable{
    protected  int countDown = 10; //default
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){

    }

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

      public String status(){
        return  "#" + id +"(" + (countDown > 0 ? countDown :"LiftOff!") + "),";
    }



    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
