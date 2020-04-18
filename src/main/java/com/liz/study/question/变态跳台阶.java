package com.liz.study.question;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 11:19
 */
public class 变态跳台阶 {
//    f(n)=f(n-1)+f(n-2)+...+f(1)
//    f(n-1)=f(n-2)+...f(1)
//    得:f(n)=2*f(n-1)
    public int JumpFloorII(int target) {
        return 1<<(target-1);
    }
}
