package com.sunteng.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ST on 2017/7/5.
 */
public class ReflectService {

    public void sayHello(String name){
        System.out.println("Hello" + name);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //通过反射获取ReflectService对象
       Object service =Class.forName(ReflectService.class.getName()).newInstance();
        //反射调用获取服务方法
        Method method = service.getClass().getMethod("sayHello",String.class);
        method.invoke(service,"张三");
    }
}
