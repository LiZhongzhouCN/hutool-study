package com.liz.study.sort;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/18 19:15
 */
public class 插入排序 {

    /**
     * 插入排序
     * 每次循环的当前元素与前面的元素逐个比较，直到大于前一个元素
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
