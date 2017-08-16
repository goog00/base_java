package base;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Created by ST on 2016/2/18.
 */
public class StringToInt {

    public  static void main(String[] args){
        System.out.println("Please enter an Integer number");

        Scanner scnr = new Scanner(System.in);

        String input = scnr.nextLine();

        int i = Integer.parseInt(input);
        System.out.println("String converted to int : " + i);

        System.out.println("Please enter another integer number");

        String str = scnr.nextLine();

        int j  = Integer.valueOf(str);

        System.out.println("String to in using valueOf():" + j);

        try {
            String str1 = new String(new byte[]{'1','s'},"");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte bt = 1;
        long l = bt;

    }
}
