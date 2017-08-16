package com.sunteng.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ST on 2016/1/19.
 */
public class NioDemo{

    public static void main(String[] args) throws Exception {
        RandomAccessFile  aFile = new RandomAccessFile("D:\\work\\exerciseworkspace\\node\\nodules.js","rw");
        FileChannel fileChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);
        int byteRead = fileChannel.read(buf);
        while(byteRead != -1){
            System.out.println("read" + byteRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            byteRead = fileChannel.read(buf);
        }
        aFile.close();

    }
}
