package com.liz.study.question;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/15 13:49
 */
public class Demo2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] intArr = new int[n];
            for (int i = 0; i < n; i++) {
                intArr[i] = scanner.nextInt();
            }
            int[] array = Arrays.stream(intArr).distinct().sorted().toArray();
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        }
    }
}
