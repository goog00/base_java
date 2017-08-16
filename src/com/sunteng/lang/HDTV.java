package com.sunteng.lang;

/**
 * Created by ST on 2016/4/7.
 */
public class HDTV implements Comparable<HDTV> {

    private int size;
    private String brand;

    public HDTV(int size,String brand){
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

    @Override
    public int compareTo(HDTV o) {

        if(this.getSize() >  o.getSize())
            return 1;
        else if(this.getSize() < o.getSize())
            return -1;
        else
            return 0;
    }

    public static void main(String[] args){
        HDTV tv1 = new HDTV(55,"sunteng");
        HDTV tv2 = new HDTV(60,"test");

        if(tv1.compareTo(tv2) > 0){
            System.out.println(tv1.getBrand() + " is better");
        } else {
            System.out.println(tv2.getBrand() + " is better");
        }
    }
}
