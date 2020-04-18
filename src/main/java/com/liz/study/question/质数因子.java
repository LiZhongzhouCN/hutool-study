package com.liz.study.question;

import java.util.Scanner;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/15 15:35
 */
public class 质数因子 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long num = Long.parseLong(scan.next());
        getPrimer(num);
    }

    public static void getPrimer(long num){
        for (int i= 2;i <= num; i++){
            if (num % i==0){
                System.out.print(i + " ");
                getPrimer(num/i);
                break;
            }
            if (i==num){
                System.out.print( i + "");
            }
        }
    }
}
