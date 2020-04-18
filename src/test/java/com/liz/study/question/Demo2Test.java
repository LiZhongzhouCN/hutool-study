package com.liz.study.question;


import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/15 13:50
 */

public class Demo2Test {

    @Test
    public void demo1() {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] intArr = new int[n];
            for (int i = 0; i < n; i++) {
                intArr[i] = scanner.nextInt();
            }
            Arrays.sort(intArr);
            for (int i = 0; i < intArr.length; i++) {
                // 第一个数字或者不等于前一个数字都可以输出
                if (i == 0 || intArr[i] != intArr[i - 1]) {
                    System.out.println(intArr[i]);
                }
            }
        }
    }
}