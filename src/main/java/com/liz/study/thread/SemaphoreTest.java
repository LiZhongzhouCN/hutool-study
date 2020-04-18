package com.liz.study.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/13 14:23
 */
public class SemaphoreTest {

    private Semaphore semaphore = new Semaphore(3, true);
    private Random random = new Random();


    class Task implements Runnable{
        private String id;
        public Task(String id){
            this.id = id;
        }
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("茅坑" + id + " 被占用了");
                work();
                System.out.println("茅坑" + id + " 空了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                semaphore.release();
            }
        }

        public void work(){
            int worktime = random.nextInt(1000);
            System.out.println("茅坑  " + id + "使用了"+ worktime + "秒");
            try {
                Thread.sleep(worktime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        newCachedThreadPool.submit(semaphoreTest.new Task(1+""));
        newCachedThreadPool.submit(semaphoreTest.new Task(2+""));
        newCachedThreadPool.submit(semaphoreTest.new Task(3+""));
        newCachedThreadPool.submit(semaphoreTest.new Task(4+""));
        newCachedThreadPool.submit(semaphoreTest.new Task(5+""));
        newCachedThreadPool.submit(semaphoreTest.new Task(6+""));
        newCachedThreadPool.submit(semaphoreTest.new Task(7+""));
        newCachedThreadPool.shutdown();
    }
}
