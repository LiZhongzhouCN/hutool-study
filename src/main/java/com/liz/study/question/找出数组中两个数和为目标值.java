package com.liz.study.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liz
 * @Description: 每次循环后计算当前数组下标值与目标值的差值，通过二分查找查出当前下标之后的数组中所有与差值相等的数组下标
 */
public class 找出数组中两个数和为目标值 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 1, 1, 4, 4, 5, 7, 9};
        System.out.println(find(arr, 5));
    }

    public static List<String> find(int[] arr, int target) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> result = binarySearch(arr, target - arr[i], i + 1, arr.length - 1, new ArrayList<>());
            for (Integer li : result) {
                strings.add(arr[i] + "+" + arr[li] + "=" + target + "(" + i + "-" + li + ")");
            }
        }
        return strings;
    }

    /**
     * 二分查找
     *
     * @param arr
     * @param value
     * @param low
     * @param high
     * @param list
     * @return
     */
    public static List<Integer> binarySearch(int[] arr, int value, int low, int high, List<Integer> list) {
        if (low > high || value < arr[low] || value > arr[high]) {
            return list;
        }
        int middle = (low + high) / 2;
        if (arr[middle] > value) {
            return binarySearch(arr, value, low, middle - 1, list);
        } else if (arr[middle] < value) {
            return binarySearch(arr, value, middle + 1, high, list);
        } else {
            list.add(middle);
            int a = middle, b = middle;
            //往前查找相等的值
            while (--a >= low) {
                if (value == arr[a]){
                    list.add(a);
                }else {
                    break;
                }
            }
            //往后查找相等的值
            while (++b <= high) {
                if (value == arr[b]){
                    list.add(b);
                }else {
                    break;
                }
            }
            return list;
        }
    }
}
