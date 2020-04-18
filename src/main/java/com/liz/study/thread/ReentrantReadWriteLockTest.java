package com.liz.study.thread;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/16 13:54
 */
public class ReentrantReadWriteLockTest {

    public final Map<String,Object> map = new TreeMap<>();

    public final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public AtomicInteger atomicRead = new AtomicInteger();

    public AtomicInteger atomicWrite = new AtomicInteger();

    public final Lock readLock = lock.readLock();

    public final Lock writeLock = lock.writeLock();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ReentrantReadWriteLockTest reentrantReadWriteLockTest = new ReentrantReadWriteLockTest();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                String key = UUID.randomUUID().toString();
                reentrantReadWriteLockTest.pub(key,key);
                reentrantReadWriteLockTest.get(key);
                reentrantReadWriteLockTest.getAllKeys();
            });
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------"+reentrantReadWriteLockTest.getAllKeys().size());
        System.out.println(reentrantReadWriteLockTest.getAllKeys());
        executorService.shutdown();

    }

    public Object get(String key){
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
            atomicRead.incrementAndGet();
            System.out.println(key + "读取成功" + atomicRead.get());
        }
    }

    public Set<String> getAllKeys(){
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }

    public void pub(String key,Object value){
        writeLock.lock();
        try {
            map.put(key,value);
        }finally {
            writeLock.unlock();
            atomicWrite.incrementAndGet();
            System.out.println(key + "写入成功" + atomicWrite.get());
        }
    }
}
