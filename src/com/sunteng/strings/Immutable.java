package com.sunteng.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ST on 2016/2/18.
 */
public class Immutable {
    public static String upcase(String s){
        //表示s传递的引用的copy
        System.out.println(s);

//        String k = s;
//        k = "kkkk";
//        s = new String("kkllll");
        s+="ppp";

        return s;
    }

    public  static void changeData(StringBuffer stringBuffer){
            stringBuffer.append("dddddd");
    }
    public static void main(String[] args){
        String q = "howdy";
        System.out.println(q);
        String qq = upcase(q);
        System.out.println(qq);
        System.out.println(q);

        System.out.println("=======================");

        List<String> list = new ArrayList<String>();
        list.add("k1");
        list.add("k2");

        test(list);
        System.out.println(list);

        System.out.println("=======================");

        StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("Before change, sb = " + sb);
        changeData(sb);
        System.out.println("After changeData(n), sb = " + sb);



    }



    public static List<String> test(List<String> k ){

//        k = new ArrayList<String>();
        k.add("22");

//        switch ("33"){
//            case 2 : String k3 = "ee";
//
//        }

        return k;
    }
}
