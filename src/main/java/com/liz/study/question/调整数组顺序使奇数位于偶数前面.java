package com.liz.study.question;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 13:20
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public void reOrderArray(int [] array) {
        if(array==null || array.length ==0){
            return ;
        }
        int m = 0;
        for(int i=0;i<array.length;i++){
            if((Math.abs(array[i]) & 1) != 0){
                int tmp = array[i];
                int j=i;
                while(j>m){
                    array[j] = array[j-1];
                    j--;
                }
                m=j+1;
                array[j] = tmp;
            }
        }
    }
}
// j
// 4 6 1 3
// 4
// 4
