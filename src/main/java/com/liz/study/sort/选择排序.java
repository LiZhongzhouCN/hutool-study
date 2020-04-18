package com.liz.study.sort;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/18 18:58
 */
public class 选择排序 {

    /**
     * 选择排序
     * 每次循环找出最小的第j个元素并与i交换，选择小的元素往前交换
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
