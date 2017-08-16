package com.sunteng.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 模拟AOP处理事务
 * Created by ST on 2016/3/31.
 */
public class TransactionInterceptor implements InvocationHandler {
    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start Transaction");
        method.invoke(target,args);
        System.out.println("end Transaction");
        return null;
    }
}
