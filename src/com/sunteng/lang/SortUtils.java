package com.sunteng.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ST on 2016/4/7.
 */
public class SortUtils {

    public static void sort(){
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(3);
        al.add(1);
        al.add(5);

        System.out.println(al);
        Collections.sort(al);
        System.out.println(al);

        Comparator<Integer> comparator = Collections.reverseOrder();
        Collections.sort(al,comparator);
        System.out.println(al);

    }

    public static void main(String[] args){
        sort();
    }

}
