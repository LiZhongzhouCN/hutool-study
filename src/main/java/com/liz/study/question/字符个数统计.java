package com.liz.study.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/15 16:07
 */
public class 字符个数统计 {


    public static void main(String[] agrs){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(getResult(input));
    }

    public static int getResult(String input){
        Map<Character,Object> map = new HashMap<>();
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(0<c &&c<127){
                map.put(c,new Object());
            }
        }
        return map.keySet().size();
    }
}
