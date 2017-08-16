package com.sunteng.lang;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ST on 2016/4/7.
 */
public class HDTV1 {

    private int size;
    private String brand;

    public HDTV1(int size, String brand) {
        this.size = size;
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static void main(String[] args){
        HDTV1 tv1 = new HDTV1(55,"test1");
        HDTV1 tv2 = new HDTV1(60,"test2");
        HDTV1 tv3 = new HDTV1(65,"test3");

        ArrayList<HDTV1> al = new ArrayList<HDTV1>();
        al.add(tv1);
        al.add(tv2);
        al.add(tv3);

        Collections.sort(al,new SizeComarator());

        for(HDTV1 a : al){
            System.out.println(a.getBrand());
        }
    }
}
