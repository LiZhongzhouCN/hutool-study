package com.liz.study.question;

import java.util.*;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/15 10:58
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = Integer.valueOf(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int j = 0;j<i;j++){
            sb.append(sc.nextLine()).append(",");
        }
        String[] str = sb.toString().split(",");
        int[] ints = sum(str);
        for (int j = 0; j < ints.length; j++) {
            System.out.println(ints[j]);
        }
    }

    public static Integer sum(String str){
        String[] strings = str.split(" ");
        int length = strings[strings.length-1].length();
        return length;
    }

    public static Integer sum(String str,String s){
        List<String> strings = Arrays.asList(str.split(""));
        final int[] num = {0};
        strings.forEach(c ->{
            if (c.equalsIgnoreCase(s))
                num[0]++;
        });
        return num[0];
    }

    public static int[] sum(String[] str){
        int[] array = new ArrayList<>(Arrays.asList(str)).stream().mapToInt(Integer::valueOf).distinct().sorted().toArray();
        return array;
    }
}
