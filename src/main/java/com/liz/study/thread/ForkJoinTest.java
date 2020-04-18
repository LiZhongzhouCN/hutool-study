package com.liz.study.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/16 14:45
 */
public class ForkJoinTest extends RecursiveTask {

    private final int[] array;
    private final int begin;
    private final int end;
    private static final int THRESHOLD = 1;

    public ForkJoinTest(int[] array, int begin, int end) {
        this.array = array;
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Object compute() {
        long sum = 0;

        if (end - begin < THRESHOLD) {      // 小于阈值, 直接计算
            for (int i = begin; i <= end; i++) {
                sum += array[i];
            }
        } else {
            int middle = (end + begin) / 2;
            ForkJoinTest subtask1 = new ForkJoinTest(this.array, begin, middle);
            ForkJoinTest subtask2 = new ForkJoinTest(this.array,middle + 1, end);

            subtask1.fork();
            subtask2.fork();

            long sum1 = (long) subtask1.join();
            long sum2 = (long) subtask2.join();

            sum = sum1 + sum2;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool executor = ForkJoinPool.commonPool();
        int[] array = new int[]{1,2,3,4,5};
        ForkJoinTest task = new ForkJoinTest(array, 0, array.length-1);
        ForkJoinTask future = executor.submit(task);
        if (future.isCompletedAbnormally()) {
            System.out.println(future.getException());
        }
        try {
            System.out.println("result: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
