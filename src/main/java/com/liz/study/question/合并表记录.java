package com.liz.study.question;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/15 15:55
 */
public class 合并表记录 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int next = sc.nextInt();
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for (int i = 0; i < next; i++) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                if (map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else {
                    map.put(key,value);
                }
            }
            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                System.out.println(integerIntegerEntry.getKey()+" "+integerIntegerEntry.getValue());
            }
        }
    }
}
