package com.liz.study.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/16 10:59
 */
public class ReentrantLockTest {

    public static int THREADTOTAL = 200;

    public final static int CLIENTTOTAL = 1000000;

    public static int COUNT = 0;

    public static AtomicInteger atomicInteger = new AtomicInteger();
    private final static Lock LOCK = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(THREADTOTAL);
        final CountDownLatch countDownLatch = new CountDownLatch(CLIENTTOTAL);
        for (int i = 0; i < CLIENTTOTAL; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    add1();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(COUNT);
        System.out.println(atomicInteger.get());
    }

    private static void add() {
        LOCK.lock();
        try {
            COUNT++;
        }finally {
            LOCK.unlock();
        }
    }

    private static void add1() {
        atomicInteger.incrementAndGet();
    }


}
