package com.liz.study.sort;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/18 19:26
 */
public class 希尔排序 {

    /**
     * 希尔排序
     *每次循环比较间距两端的元素，交换两端元素使小的在前
     * @param array
     * @return
     */
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
