package com.liz.study.question;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 12:41
 */
public class 矩形覆盖 {

    public int RectCover(int target) {
        if (target == 0){
            return 0;
        }
        int a = 1,b = 1;
        while (target-- > 1){
            a = a+b;
            b = a-b;
        }
        return a;
    }

    public static void main(String[] args) {
        矩形覆盖 c = new 矩形覆盖();
        System.out.println(c.RectCover(0));
        System.out.println(c.RectCover(1));
        System.out.println(c.RectCover(2));
        System.out.println(c.RectCover(3));
        System.out.println(c.RectCover(4));
        System.out.println(c.RectCover(5));
    }
}
