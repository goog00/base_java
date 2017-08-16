package com.sunteng.concurrency;

import java.util.concurrent.Callable;

/**
 * Created by ST on 16-1-31.
 */
public class TaskWithResult implements Callable<String> {
    private  int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result of TaskWithResult" + id;
    }


}
