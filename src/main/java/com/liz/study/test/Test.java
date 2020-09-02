package com.liz.study.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/21 19:33
 */
public class Test {

    public static void main(String[] args) throws ParseException {

        dateFormatTest();
    }

    public static void dateFormatTest() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        String time = "2020/3/10 10:30:42.744";
        Date dateTime = simpleDateFormat.parse(time);
        long timeTime = dateTime.getTime();
        System.out.println(timeTime);
    }

}

