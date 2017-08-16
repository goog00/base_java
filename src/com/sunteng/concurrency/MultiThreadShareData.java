package com.sunteng.concurrency;

/**
 * Created by ST on 16-2-2.
 */
public class MultiThreadShareData {

    public static void main(String[] args) {
     final    ShareData1 data1 = new ShareData1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                data1.decrement();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                data1.increment();
            }
        }).start();
    }


}

class ShareData1 /*implements Runnable*/ {
    private int j = 0;

    public synchronized void increment() {
        j++;
        System.out.println(Thread.currentThread().getName()+ " ++  " +j);
    }

    public synchronized void decrement() {
        j--;
        System.out.println(Thread.currentThread().getName() + "---" +j);
    }

//    Integer count = 100;

//    @Override
//    public  void run() {
//        synchronized (count){
//            while (count > 0) {
//                count--;
//                System.out.println(Thread.currentThread().getName() + "   " + count);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }




    }

//    class Business {
//        int count = 100;
//
//        public synchronized void dec() {
//            while (count > 0) {
//                count--;
//                System.out.println(Thread.currentThread().getName() + " " + count);
//            }
//        }
//    }
//}


