package com.sunteng.typeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ST on 2016/4/4.
 */
public class FilledList<T> {

    private Class<T> type;
    public FilledList(Class<T> type){
        this.type = type;
    }

    public List<T> create(int nElement){
        List<T> result = new ArrayList<T>();

        try{
            for(int i = 0;i < nElement;i++){
                result.add(type.newInstance());
            }
        } catch (Exception e){

        }
        return result;
    }

    public static  void main(String[] args){
        FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);

        System.out.println(fl.create(15));
    }


}
