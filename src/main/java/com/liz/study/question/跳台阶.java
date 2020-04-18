package com.liz.study.question;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 10:50
 */
public class 跳台阶 {

    public static void main(String[] args) {
        跳台阶 c = new 跳台阶();
        int i = c.JumpFloor(2);
        System.out.println(i);
    }

    public int JumpFloor(int target) {
        int a = 1, b = 1;
        while (target-- > 1){
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
