package com.liz.study.question;

import java.util.Scanner;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/15 14:59
 */
public class Demo4 {


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            String str = scanner.nextLine();
            System.out.println(Integer.valueOf(str.substring(2),16).toString());
        }
    }
}
