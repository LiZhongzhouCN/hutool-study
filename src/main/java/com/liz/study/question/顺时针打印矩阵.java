package com.liz.study.question;

import java.util.ArrayList;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 15:05
 */
public class 顺时针打印矩阵 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        while (matrix.length > 0) {
            for (int i : matrix[0]) {
                list.add(i);
            }
            if (matrix.length ==1){
                return list;
            }
            int temp[][] = new int[matrix.length - 1][matrix[0].length];
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    temp[i - 1][j] = matrix[i][j];
                }
            }
                matrix = arrayRotate(temp);
        }
        return list;
    }

    public static int[][] arrayRotate(int[][] matrix) {
        int temp[][] = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp[i][j] = matrix[j][matrix[0].length - 1 - i];
            }
        }
        return temp;
    }


    public static void main(String[] args) {
        顺时针打印矩阵 c = new 顺时针打印矩阵();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> list = c.printMatrix(matrix);
        System.out.println(list);
    }
}
