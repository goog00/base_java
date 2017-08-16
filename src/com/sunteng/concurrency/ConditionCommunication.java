package com.sunteng.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ST on 16-2-1.
 */
public class ConditionCommunication {
    /**
     * 子线程运行10，然后主线程运行100次，然后在回到子线程运行10次，主线程运行100次，往返循环运行50次
     *共同数据和共同算法的若干个方法要放在同一个类上，体现高类聚和程序的健壮性
     */
    public static void main(String[] args){
        new ConditionCommunication().init();
    }

    private void  init(){
      final  Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 50;i++){
                    business.sub(i);
                }
            }
        }).start();

        for(int i = 1; i <= 50; i++){
               business.main(i);
        }
    }
    class Business{
        private boolean bShouldeSub = true;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        public  void sub(int i){
            lock.lock();
            try{
                while(!bShouldeSub){
                    try {
//                    this.wait();//等待
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int j = 1;j <= 10; j++){
                    System.out.println("sub运行"+ j +", loop of " + i);
                }
                bShouldeSub = false;
//            this.notify();//唤醒等待的线程
                condition.signal();
            }finally {
                lock.unlock();
            }

        }

        public  void main(int i){
            lock.lock();
            try{
                while (bShouldeSub){
                    try {
//                        this.wait();
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int j = 1;j <= 100; j++){
                    System.out.println("main运行"+ j +", loop of " + i);
                }
                bShouldeSub = true;
                condition.signal();
            }finally {
                lock.unlock();
            }

        }
    }
}
