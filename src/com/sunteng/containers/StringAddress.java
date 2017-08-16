package com.sunteng.containers;

import java.util.*;

/**
 * Created by ST on 2016/2/13.
 */
public class StringAddress {

    private String s ;

    public StringAddress(String s){
        this.s = s;
    }

    public String toString(){
        return super.toString() + " " + s;
    }

    public static  void main(String[] args){
        List<StringAddress>  list1 = new ArrayList<StringAddress>(Collections.nCopies(4,new StringAddress("Hello")));

        System.out.println(list1);

        Collections.fill(list1,new StringAddress("World"));

        Set set = new HashSet();
        set.add("d");
        set.iterator();

        System.out.println(list1);
    }
}
