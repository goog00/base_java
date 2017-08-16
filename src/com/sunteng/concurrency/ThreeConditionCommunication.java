package com.sunteng.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ST on 16-2-1.
 */
public class ThreeConditionCommunication {
    /**
     * 子线程运行10，然后主线程运行100次，然后在回到子线程运行10次，主线程运行100次，往返循环运行50次
     *共同数据和共同算法的若干个方法要放在同一个类上，体现高类聚和程序的健壮性
     */
    public static void main(String[] args){
        new ThreeConditionCommunication().init();
    }

    private void  init(){
      final  Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 50;i++){
                    business.sub2(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 50;i++){
                    business.sub3(i);
                }
            }
        }).start();

        for(int i = 1; i <= 50; i++){
               business.main(i);
        }
    }
    class Business{
        private int shouldeSub = 1;
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        public  void sub2(int i){
            lock.lock();
            try{
                while(shouldeSub != 2 ){
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int j = 1;j <= 10; j++){
                    System.out.println("sub2运行"+ j +", loop of " + i);
                }
                shouldeSub = 3;
                condition3.signal();
            }finally {
                lock.unlock();
            }

        }

        public  void sub3(int i){
            lock.lock();
            try{
                while(shouldeSub != 3 ){
                    try {
//                    this.wait();//等待
                        condition3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int j = 1;j <= 10; j++){
                    System.out.println("sub3运行"+ j +", loop of " + i);
                }
                shouldeSub = 1;
                condition1.signal();
            }finally {
                lock.unlock();
            }

        }

        public  void main(int i){
            lock.lock();
            try{
                while (shouldeSub != 1){
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int j = 1;j <= 100; j++){
                    System.out.println("main运行"+ j +", loop of " + i);
                }
                shouldeSub = 2;
                condition2.signal();
            }finally {
                lock.unlock();
            }

        }
    }
}
