package com.liz.study.question;

import java.util.Stack;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/16 23:06
 */
public class 两个栈实现队列 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <=0){
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
        }

        int result = stack2.pop();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        两个栈实现队列 c = new  两个栈实现队列();
        c.push(1);
        c.push(2);
        c.push(3);
        c.push(4);
        c.pop();
        c.pop();
        c.push(5);
        c.pop();
    }
}
