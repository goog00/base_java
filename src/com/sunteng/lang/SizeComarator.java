package com.sunteng.lang;

import java.util.Comparator;

/**
 * Created by ST on 2016/4/7.
 */
public class SizeComarator implements Comparator<HDTV1> {
    @Override
    public int compare(HDTV1 o1, HDTV1 o2) {

        int tv1Size = o1.getSize();
        int tv2Size = o2.getSize();

        if(tv1Size > tv2Size){
            return 1;
        } else if(tv1Size < tv2Size){
            return -1;
        } else {
            return 0;
        }
    }


}
