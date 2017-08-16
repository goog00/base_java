package com.sunteng;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ST on 2015/12/30.
 */
public class PasswordUtils {

    @UseCase(id = "47",description = "Passwords must contain at least one numberic")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\*"));
    }

    @UseCase(id="")
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    public static void main(String[] args){
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases,47,48,49,50);

        trackUseCases(useCases,PasswordUtils.class);

    }


    public static void trackUseCases(List<Integer> useCase,Class<?> cl){
        //获取方法
        for(Method m : cl.getDeclaredMethods()){
            //获取classs 对象
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null){
                System.out.println("Found Use Case:" + uc.id() + "  " + uc.description());
            useCase.remove(new Integer(uc.id()));
            }
        }

        for(int i : useCase){
            System.out.println("warn: missing use case - " + i);
        }
    }
}
