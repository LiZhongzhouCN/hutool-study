package com.liz.study.question;

import java.util.Scanner;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/15 14:28
 */
public class Demo3 {

    public static void main(String[] args) {
        final String ss = "00000000";
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine().replace(" ","");
            int len = (int) Math.ceil(str.length()/8.0);
            String[] s = new String[len];
            for (int i = 0; i < len; i++) {
                if (str.length() - 8*i >= 8){
                    s[i] = str.substring(8*i,(i+1)*8);
                }else if (str.length() - 8*i >=1){
                    String  aa = str.substring(8*i,str.length());
                    aa += ss.substring(0,8-aa.length());
                    s[i] = aa;
                }
            }
            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
            }
        }
    }
}
