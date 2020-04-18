package com.liz.study.question;

import java.util.ArrayList;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/16 14:21
 */
public class Test<T> {

    private Test<T> a;
    private T b;

    public static void main(String[] args) {
        Test test = new Test<>();
        test.setB(new ArrayList<>());
        Object o = test.getB();
        System.out.println(o.getClass());
    }

    public Test(){}

    public Test(Test<T> a, T b) {
        this.a = a;
        this.b = b;
    }

    public Test<T> getA() {
        return a;
    }

    public void setA(Test<T> a) {
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }
}
