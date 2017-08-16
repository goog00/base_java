package com.sunteng.reflect;

/**
 * Created by ST on 2017/7/5.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
