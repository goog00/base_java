package com.sunteng.concurrency;

import java.util.Random;

/**
 * Created by ST on 16-2-2.
 */
public class ThreadLocalTest {


    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    //同一个线程访问A和访问B得到结果一样，A和B拥有的数据属于当前线程
                    System.out.println(Thread.currentThread().getName() + " 生成的数据为 ： " + data);
                    ThreadScopeData.getThreadInstance().setAge(data);
                    ThreadScopeData.getThreadInstance().setName("name" + data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }


    static class A {

        public void get() {
//            System.out.println("A " + Thread.currentThread().getName() + " 拥有的数据：" + map.get(Thread.currentThread()));
            ThreadScopeData data = ThreadScopeData.getThreadInstance();
            System.out.println("A " + Thread.currentThread().getName() + " 拥有的name：" + data.getName() + " age :" + data.getAge());
        }
    }

    static class B {
        public void get() {
//            System.out.println("B " + Thread.currentThread().getName() + " 拥有的数据：" + map.get(Thread.currentThread()));
            ThreadScopeData data = ThreadScopeData.getThreadInstance();
            System.out.println("B " + Thread.currentThread().getName() + " 拥有的name：" + data.getName() + " age :" + data.getAge());
        }
    }


}

class ThreadScopeData {
    private ThreadScopeData() {
    }

    public static ThreadScopeData getThreadInstance() {

        ThreadScopeData instance = map.get();
        if (instance == null) {
            instance = new ThreadScopeData();
            map.set(instance);
        }
        return instance;
    }

    private static ThreadLocal<ThreadScopeData> map = new ThreadLocal<ThreadScopeData>();


    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
