package com.bzf.multithreadeddemo;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 双重检查模式（DCL）
 * @author baizhengfu
 * @version 1.0
 * @since JDK1.8
 * @date 2018/10/4
 */
public class Singleton {

    private volatile static Singleton instance = null;

    private static Object lock = new Object();

    public static Singleton getInstance(){

        if(instance==null){
            synchronized (lock){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
