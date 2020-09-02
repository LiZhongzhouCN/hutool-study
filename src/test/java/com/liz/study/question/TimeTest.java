package com.liz.study.question;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;

/**
 * @author liz
 * @Description:
 * @date: 2020/9/1 16:05
 */
public class TimeTest {

    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime = DateUtil.parse("2020-09-01T14:12:19.000+08:00","yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(dateTime.toString());

    }
}
