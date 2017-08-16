package com.sunteng.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ST on 2016/2/17.
 *
 *
 */
public class ChannelCopy {

    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception {
        if(args.length != 2){
            System.out.println("arguments : sourcefile destfile");
            System.out.println(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                    out = new FileOutputStream(args[1]).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        /*
        * 每次read()操作之后，就会将数据输入贷缓冲器中，flip()则是准备缓冲器以便他的信息可以由write()提取。write()操作之后，信息仍在缓冲中，接着clear()操作则对所有的内部指针重新安排，以便缓冲器在里一个
        * read() 操作前做好接收数据的准备
        * */
        while (in.read(buffer) != -1){
            buffer.flip(); // Prepare for writing
            out.write(buffer);
            buffer.clear(); // Prepare for reading
        }
    }
}
