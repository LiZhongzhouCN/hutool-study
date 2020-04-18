package com.liz.study.sort;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/18 17:48
 */
public class 冒泡排序 {

    /**
     * 每次循环将比较相邻两个元素大小，最大的往后移
     * @param array
     * @return
     */
    public static int[] sort(int[] array) {
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        return array;
    }

}
