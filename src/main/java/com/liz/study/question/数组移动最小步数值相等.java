package com.liz.study.question;

import java.util.Arrays;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/22 10:43
 */
public class 数组移动最小步数值相等 {

    public static void main(String[] args) {
        int[] a = new int[]{1,4,9};
        int[] b = new int[a[a.length - 1] - a[0] + 1];
        for (int i = a[0]; i < a[a.length-1] + 1; i++){
            int temp = 0;
            for (int j = 0; j < a.length; j++) {
                temp += Math.abs(a[j] - i) ;
            }
            b[i - a[0]] = temp;
        }
        Arrays.sort(b);
        System.out.println(b[0]);
    }
}
