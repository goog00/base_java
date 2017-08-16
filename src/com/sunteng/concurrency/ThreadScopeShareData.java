package com.sunteng.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by ST on 16-2-2.
 */
public class ThreadScopeShareData {

    private  static int data = 0;

    private static Map<Thread,Integer> map = new HashMap<Thread, Integer>();
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 2; i++) {
//            data  = new Random().nextInt();
//            //同一个线程访问A和访问B得到结果一样，A和B拥有的数据属于当前线程
//            System.out.println(Thread.currentThread().getName() + " 生成的数据为 ： " + data);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int  data  = new Random().nextInt();
                    //同一个线程访问A和访问B得到结果一样，A和B拥有的数据属于当前线程
                    System.out.println(Thread.currentThread().getName() + " 生成的数据为 ： " + data);
                    map.put(Thread.currentThread(),data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }


    static class A {

        public void get() {
            System.out.println("A " + Thread.currentThread().getName() + " 拥有的数据：" + map.get(Thread.currentThread()));
        }
    }

    static class B {
        public void get() {
            System.out.println("B " + Thread.currentThread().getName() + " 拥有的数据：" + map.get(Thread.currentThread()));
        }
    }

}
