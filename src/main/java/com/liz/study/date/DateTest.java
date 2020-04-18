package com.liz.study.date;

import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @author liz
 * @Description:
 * @date: 2020/3/27 11:30
 */
public class DateTest {

    public static void main(String[] args) {


        //当前时间
        Date date = DateUtil.date();
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today= DateUtil.today();
    }

    public void parse(){
//        String dateStr = "2017-03-01";
//        Date date = DateUtil.parse(dateStr);

        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr, "yyyy-MM-dd");
    }
}
