package com.liz.study.question;

import java.util.Stack;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 20:58
 */
public class 栈的压入弹出序列 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int len = pushA.length;
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0, j=0;  i < len; i++){
            s.push(pushA[i]);
            while(j < len && s.peek() == popA[j]){
                s.pop();
                j = j+1;
            }
        }
        return s.empty();
    }
}
