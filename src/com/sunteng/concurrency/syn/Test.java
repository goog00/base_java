package com.sunteng.concurrency.syn;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ST on 16-2-7.
 */
public class Test extends Thread
{

    private String key1;
    private String key2;
    private String value;

    public Test(String key1, String key2,String value) {
        this.value = value;
        this.key1 = key1;
        this.key2 = key2;
    }

    public static void main(String[] args){
        System.out.println("Begain:" + System.currentTimeMillis()/1000);
        Test test1 = new Test("1","","333");
        Test test2 = new Test("2","","444");
        Test test3 = new Test("1","","554");
        Test test4 = new Test("4","","777");
        test1.start();
        test2.start();
        test3.start();
        test4.start();
    }
    public void run(){

        TestDo.getInstance().doSome(key1 + key2, value);
    }
}

class TestDo{
    private TestDo(){}
    private static TestDo testDo = new TestDo();
    public static TestDo getInstance(){
        return testDo;
    }

    private ArrayList arrayList = new ArrayList();
    public void doSome(String key ,String value)  {


        Object o = key;
        if(!arrayList.contains(o)){
            arrayList.add(o);
        } else {
            for(Iterator itr = arrayList.iterator(); itr.hasNext();){
                Object oo = itr.next();
                if(oo.equals(o)){
                    o = oo;
                }
            }
        }
        synchronized (o){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(key +":"  + value +":"+System.currentTimeMillis()/1000);
        }


    }
}


