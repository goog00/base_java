package com.sunteng.Collectionquestion;

import java.util.*;

/**
 * http://www.programcreek.com/2013/09/top-10-questions-for-java-collections/
 * Created by ST on 2016/4/4.
 */
public class CollectionQuestion {

    /**
     * How do I removerepeated elements from ArrayList?
     * @param list
     */
    public static void test(List<Integer> list){
        Set<Integer> set = new HashSet<Integer>(list);
        list.clear();
        list.addAll(set);
    }

    public static void test2(List<Integer> list){
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(list);
        list.clear();
        list.addAll(set);
    }

    /**
     * Effcient equivalent for removing elements while iterating the Collection
     */
    public static void test3(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(9);
        list.add(9);
        list.add(9);

        Iterator<Integer> itr = list.iterator();
//        while (itr.hasNext()){
//            //do something
//            itr.next();
//            itr.remove();
//        }

        /**
         *  you will get a ConcurrentModificationException by running the code.
         *  This is because an iterator has been generated (in for statement) to
         *  traverse over the list,but at the same time the list is changed by Iterator.remove()
         *  In Java ,"it is not generally permissible for one thread to modify a collection while another thread is iterating over it "
         */

        for(Integer i : list){
            list.remove(i);
        }
    }

    /**
     * How to convert List to int[]
     *
     * The easiest way might be using ArrayUtils in Apache Commons Lang library.
     * int[] array = ArrayUtils.toPrimitive(list.toArray(new Integer[0]));
     */

    public static void test4(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(9);
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }

    }

    /**
     * What is the best way to filter a Colection?
     */
    public static <T> void filter(Collection<T> collection,Predicate predicate){
        if((collection != null) && (predicate != null)){
            Iterator<T> itr = collection.iterator();
            while (itr.hasNext()){
                T obj = itr.next();
                if(!predicate.test(obj)){
                    itr.remove();
                }
            }
        }
    }



    public static void main(String[] args){
//        List<Integer> list = new ArrayList<Integer>();
//
//        list.add(4);
//        list.add(8);
//        list.add(8);
//        list.add(9);
//        list.add(1);
//        list.add(2);
//
//        test(list);
//
//        for(Integer item : list){
//            System.out.println(item);
//        }
//        test3();

        //test filter ---start
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(8);
        list.add(9);
        list.add(1);
        list.add(2);
        filter(list, new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i < 5;
            }
        });
        for(Integer item : list){
            System.out.println(item);
        }
        //test filter ---end


      List<String> list2 =   Collections.emptyList();
        list2.add("dd");
//        List<String> list3 = new ArrayList<String>();
//        list2 = list3;



    }

}
