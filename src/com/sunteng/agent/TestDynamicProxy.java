package com.sunteng.agent;

import java.lang.reflect.Proxy;

/**
 * Created by ST on 2016/3/31.
 */
public class TestDynamicProxy {

    public static void main(String[] args){
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        UserService userService = new UserServiceImpl();
        transactionInterceptor.setTarget(userService);

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),userService.getClass().getInterfaces(),transactionInterceptor);
        userServiceProxy.addUser();
    }
}
