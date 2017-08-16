package com.sunteng.java8.model;

/**
 * Created by ST on 2017/8/15.
 */
public class Track {
    private String name;
    private int duration;

    public Track() {
    }

    public Track(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


}
