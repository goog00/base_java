package com.sunteng.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ST on 16-2-7.
 */
public class CurrentCollectionTest {

    public static void main(String[] args){
        Collection<User> users = new CopyOnWriteArrayList<User>();

//                new ArrayList<User>();
        users.add(new User("张三"));
        users.add(new User("李四"));
        users.add(new User("王五"));

        Iterator itr = users.iterator();
        while(itr.hasNext()){
            User user1 = (User) itr.next();
            if(user1.getName().equals("张三")){
                itr.remove();
            } else {
                System.out.println(user1.getName());
            }

        }

    }
}
