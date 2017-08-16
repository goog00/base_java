package com.sunteng.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ST on 2016/2/16.
 */
public class BerylliumSphere {

    private static  long counter;
    private final long id = counter++;
    public String toString(){
        return "Sphere" +  id;
    }


    public static void  main(String[] args){
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for(int i = 0; i < 5; i++){
            spheres[i] = new BerylliumSphere();

        }
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);

        List<BerylliumSphere> spheres1 = new ArrayList<BerylliumSphere>();
        for(int i = 0; i < 5; i++){
            spheres1.add(new BerylliumSphere());
        }
        System.out.println(spheres1);
        System.out.println(spheres1.get(4));

        int [] integers = {0,1,2,3,4,5};

        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5));
        integerList.add(97);
        System.out.println(integerList);
        System.out.println(integerList.get(4));

    }
}
