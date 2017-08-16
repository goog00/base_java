package com.sunteng.agent;

/**
 * Created by ST on 2016/4/5.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        UserMgr mgr = new UserMgrImpl();

        //为用户管理添加事务处理
        InvocationHandler h = new TransactionHandler(mgr);

        //为用户管理添加事务处理
        UserMgr u = (UserMgr) Proxy.newProxyInstance(UserMgr.class,h);
        u.addUser();
        //为用户管理添加显示方法执行时间功能




    }
}
