package com.liz.study.question;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 0:07
 */
public class 斐波那契数列 {
//斐波那契数列的标准公式为：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
public int Fibonacci(int n) {
    int a = 0;
    int b = 1;
    while(n-->0){
        b = a + b;
        a = b - a;
    }
    return a;
}

    public static void main(String[] args) {
        斐波那契数列 c = new 斐波那契数列();
        Long i = Long.valueOf(c.Fibonacci(1000));

        System.out.println(i);
    }
}
