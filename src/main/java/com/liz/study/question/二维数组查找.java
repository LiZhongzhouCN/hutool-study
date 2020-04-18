package com.liz.study.question;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/16 21:41
 */
public class 二维数组查找 {

    public boolean Find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (target == array[i][j])
                    return true;
            }
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {

        String s = str.toString().replace(" ", "%20");
        return s;

    }

}
