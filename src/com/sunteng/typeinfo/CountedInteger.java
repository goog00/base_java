package com.sunteng.typeinfo;

/**
 * Created by ST on 2016/4/4.
 */
public class CountedInteger {
    private static long counter;
    private final long id = counter++;
    public String toString(){
        return Long.toString(id);
    }
}
