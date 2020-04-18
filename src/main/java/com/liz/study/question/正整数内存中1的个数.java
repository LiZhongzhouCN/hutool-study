package com.liz.study.question;

import java.util.Scanner;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/15 16:19
 */
public class 正整数内存中1的个数 {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            //计算1的个数
            int count = 0;
            String toBinary = Integer.toBinaryString(num);
            for(int i = 0; i < toBinary.length(); i++){
                char c = toBinary.charAt(i);
                if(c == '1'){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
