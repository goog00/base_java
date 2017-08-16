package com.sunteng.holding;

import java.util.LinkedList;

/**
 * Created by ST on 2016/2/15.
 */
public class Stack<T> {

    java.util.Stack k = new java.util.Stack();

    private LinkedList<T> storage = new LinkedList<T>();

    public void push(T v){
        storage.addFirst(v);
    }

    public T peek(){
        return storage.getFirst();
    }

    public T pop(){
        return storage.removeFirst();
    }
    public boolean empty(){
        return storage.isEmpty();
    }

    public String toString(){
        return storage.toString();
    }

}
