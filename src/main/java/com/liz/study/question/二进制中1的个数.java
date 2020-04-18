package com.liz.study.question;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 12:54
 */
public class 二进制中1的个数 {
    public int NumberOf1(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
        }
        return count;
    }

    public int NumberOf2(int n){
        int count = 0;
        while (n != 0){
            count ++;
            n = n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        二进制中1的个数 c = new 二进制中1的个数();
        System.out.println(c.NumberOf1(10));
        System.out.println(c.NumberOf1(-10));
        System.out.println(c.NumberOf2(10));
        System.out.println(c.NumberOf2(-10));
    }
}
