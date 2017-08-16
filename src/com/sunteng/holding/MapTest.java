package com.sunteng.holding;


import java.util.*;

/**
 * Created by ST on 2016/2/16.
 */
public class MapTest {

    public static  void main(String[] args){

//        Map<String,Object> map = new HashMap<String,Object>();
//
//        map.put("k1","sunteng");
//        map.put("k2",1234);
//        map.put("k3",5678);
//
//
//        Set set = map.entrySet();
//        Set set1 = map.keySet();
//        for(Object o : set1){
//            System.out.println(o.toString());
//        }


        Map<String,Object> map = new HashMap<String,Object>();

        System.out.println(map.hashCode());

        for(int i = 0; i< 100 ; i++){
            map.put("key" + i * i,i*i);
        }

        //将键值保存到集合
        List<Map.Entry<String,Object>> list = new ArrayList<Map.Entry<String,Object>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Object>>() {
            @Override
            public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
//                System.out.println(o1.hashCode() + "--------------" + o2.hashCode());
                return o1.hashCode() - o2.hashCode();
            }
        });

        for(Map.Entry<String, java.lang.Object> entry : list){

            System.out.println(entry.hashCode()+": " +entry.getKey() + "--->" +entry.getValue());
        }

//        String k = new String("kk");
//        String k1 = new String("kk");
//        System.out.println(k.equals(k1));
//        System.out.println(k.hashCode() + " ;"  + k1.hashCode());
//        map.values();

    }
}
