package com.sunteng.concurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by ST on 16-2-1.
 */
public class BlockingQueueCommunication {
    /**
     * 子线程运行10，然后主线程运行100次，然后在回到子线程运行10次，主线程运行100次，往返循环运行50次
     *共同数据和共同算法的若干个方法要放在同一个类上，体现高类聚和程序的健壮性
     */
    public static void main(String[] args) throws InterruptedException {
        new BlockingQueueCommunication().init();
    }

    private void  init() throws InterruptedException {
      final  Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 50;i++){
                    try {
                        business.sub(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        for(int i = 1; i <= 50; i++){
               business.main(i);
        }
    }
    class Business{

        BlockingQueue queue1 = new ArrayBlockingQueue(1);
        BlockingQueue queue2 = new ArrayBlockingQueue(1);
        {
            Collections.synchronizedMap(new HashMap());
            try {
                queue2.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public  void sub(int i) throws InterruptedException {

            queue1.put(1);
            for(int j = 1;j <= 10; j++){
                System.out.println("sub运行"+ j +", loop of " + i);
            }

            queue2.take();
        }

        public void main(int i) throws InterruptedException {
           queue2.put(1);
            for(int j = 1;j <= 100; j++){
                System.out.println("main运行"+ j +", loop of " + i);
            }
            queue1.take();

        }
    }
}
