package com.sunteng.nio;

import java.nio.ByteBuffer;

/**
 * Created by ST on 2016/2/17.
 */
public class GetData {

    private static final int BSIZE = 1024;

    public static void main(String[] args){

        ByteBuffer bb = ByteBuffer.allocate(BSIZE);

        int i = 0;
        while(i++ < bb.limit()){
            if(bb.get() != 0){
                System.out.println("nonzore");
            }
        }
        System.out.println("i = " + i);

        bb.rewind();


    }
}
