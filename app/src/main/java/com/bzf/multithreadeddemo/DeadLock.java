package com.bzf.multithreadeddemo;

import com.bzf.multithreadeddemo.utils.LogUtils;

/**
 *  死锁示例
 * @author baizhengfu
 * @version 1.0
 * @since JDK1.8
 * @date 2018/10/4
 */
public class DeadLock {

    private Object obj1 = new Object();
    private Object obj2 = new Object();

    public void deadLock(){
        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread1());
        thread1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();

    }

    private  class MyThread implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (obj1){
                    LogUtils.printJava(Thread.currentThread().getName()+"获取到锁:obj1");
                    try {
                        Thread.sleep(5);
                        synchronized(obj2){
                            LogUtils.printJava(Thread.currentThread().getName()+"获取到锁：obj2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        LogUtils.printJava("发生异常："+e.getMessage());
                        Thread.currentThread().interrupt();
                    }
                }
            }

        }
    }

    private  class MyThread1 implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (obj2){
                    LogUtils.printJava(Thread.currentThread().getName()+"获取到锁:obj2");
                    try {
                        Thread.sleep(5);
                        synchronized(obj1){
                            LogUtils.printJava(Thread.currentThread().getName()+"获取到锁：obj1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        LogUtils.printJava("发生异常："+e.getMessage());
                        Thread.currentThread().interrupt();
                    }
                }
            }

        }
    }

}
