package com.liz.study.singleton;

/**
 * @author liz
 * @Description:双重校验锁
 * @date: 2020/4/19 22:32
 */
public class Singleton {

    private static Singleton  singleton = null;

    private Singleton(){}

    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }
}
