package com.sunteng.concurrency;

/**
 * Created by ST on 16-2-1.
 */
public class TraditionalThreadSynchronized {

    public static void main(String[] args) {

        new TraditionalThreadSynchronized().init();
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
                    out.output3("kongjian");
                }

            }
        }).start();

    }

    static class Outputer {
        public void output(String name) {
            int len = name.length();
            synchronized (Outputer.class) {
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
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
