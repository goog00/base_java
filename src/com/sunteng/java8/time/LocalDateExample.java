package com.sunteng.java8.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * Created by ST on 2017/8/15.
 */
public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Current date " +  today);

        LocalDate firstDay_2014 = LocalDate.of(2017, Month.APRIL,1);
        System.out.println("Specific date" + firstDay_2014);

        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time" + currentTime);

        //格式化
        System.out.println(today.format(DateTimeFormatter.ofPattern("uu/M/d")));
    }
}
