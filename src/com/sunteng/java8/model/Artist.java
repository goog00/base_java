package com.sunteng.java8.model;

/**
 * Created by ST on 2017/8/15.
 */
public class Artist {
    private String name;
    private String members;
    private String origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isFrom(String name){
        if(origin.equals(name)){
            return true;
        }
        return false;
    }
}
