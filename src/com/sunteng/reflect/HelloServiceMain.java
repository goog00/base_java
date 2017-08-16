package com.sunteng.reflect;

/**
 * Created by ST on 2017/7/5.
 */
public class HelloServiceMain {
    public static void main(String[] args) {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService proxy = (HelloService) helloServiceProxy.bind(new HelloServiceImpl());
        proxy.sayHello("lisi");
    }
}
