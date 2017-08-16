package com.sunteng.reflect;

import java.lang.reflect.Method;

/**
 * Created by ST on 16-2-4.
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        String startingClasseName = args[0];
        Method mainMethod = Class.forName(startingClasseName).getMethod("main",String[].class);
        mainMethod.invoke(null,(Object)new String[]{"11","22","33"});
    }
}

class MainTest{
    public static void main(String[] args){
        for(int i = 0; i < args.length;i++){
            System.out.println(args[i]);
        }

    }
}
