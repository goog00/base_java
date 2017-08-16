package com.sunteng.agent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ST on 2016/4/5.
 */
public class TransactionHandler implements InvocationHandler{


    private Object target;

    public TransactionHandler(Object target){
        super();
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {

        System.out.println("开启事务");

        try {
            m.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("提交事务");
    }
}
