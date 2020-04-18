package com.liz.study.question;

import java.util.stream.IntStream;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 23:02
 */
public class 数组中出现次数超过一半的数字 {


    public int MoreThanHalfNum_Solution(int[] array) {
        int i = array[array.length / 2];
        return IntStream.of(array).filter(k -> k == i).count() > array.length >> 1 ? i : 0;
    }
}
