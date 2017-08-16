package com.sunteng.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ST on 16-2-1.
 */
public class LockTest {

    public static void main(String[] args) {

        new LockTest().init();
    }

    private void init() {
        final Outputer out = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    out.output("sunteng");
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    out.output("kongjian");
                }

            }
        }).start();

    }

    static class Outputer {
        Lock lock = new ReentrantLock();
        public void output(String name) {
            int len = name.length();
//            synchronized (Outputer.class) {
            lock.lock();
            try{
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            } finally {
                lock.unlock();
            }

        }

        public synchronized void output2(String name) {
            int len = name.length();

            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();


        }

        public static synchronized void output3(String name) {
            int len = name.length();

            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();


        }
    }


}
