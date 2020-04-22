package com.liz.study.test;


import com.liz.study.clone.Clone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/21 19:33
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Clone.Cat cat = new Clone.Cat();
        Clone.Cat cat1 = cat.clone();
        System.out.println(cat == cat1);

    }

    public void dateFormatTest() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        String time = "2020/4/5 14:56:46.748";
        Date dateTime = simpleDateFormat.parse(time);
        long timeTime = dateTime.getTime();
        System.out.println(timeTime);
    }
}

