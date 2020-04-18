package com.liz.study.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/9 10:02
 */
class LowCase {
    void call(int a, String b, Map<String, List<String>> map) {
        a = 3;
        b = "str2";
        map.get("list2").add("three");
    }

    public static void main(String[] args) {
        int a = 2;
        String b = "str1";

        List<String> list = new ArrayList();
        list.add("str1");
        Map<String, List<String>> map = new HashMap();
        map.put("list2", list);

        String aa = "ABC";
        aa.toLowerCase();

        new LowCase().call(a, b, map);
        System.out.println(a);
        System.out.println(b);
        System.out.println(map);

        System.out.println(toLowerCase("AbCDFe"));
        // 此处打印a,b,map，结果是什么？
    }


    public static String toLowerCase(String str){
        char[] c = str.toCharArray();  //先将字符串转换成字符数组
        int value = 'a'-'A';  //计算大小写间差值：32
        //循环遍历字符数组
        for(int i = 0; i < c.length; i++){
            if('A'<=c[i] && c[i] <='Z'){
                c[i] = (char)(c[i]+value);      //大写变小写
            }
        }
        String result = new String(c);  //再将字符数组转换成字符串
        return result;
    }

}

