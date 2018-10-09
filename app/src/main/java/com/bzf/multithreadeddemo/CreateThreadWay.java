package com.bzf.multithreadeddemo;

import com.bzf.multithreadeddemo.utils.LogUtils;

import java.util.concurrent.Callable;

/**
 * 创建线程的三种方式
 * @author baizhengfu
 * @version 1.0
 * @since JDK1.8
 * @date 2018/10/4
 */
public class CreateThreadWay {


    public static class myThread extends Thread{

        @Override
        public void run() {
            LogUtils.printJava(Thread.currentThread().getName()+"----继承Thread方式");
        }
    }

    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            LogUtils.printJava(Thread.currentThread().getName()+"----实现Runnable方式");
        }
    }


    public static class MyCallable implements Callable<Boolean>{

        @Override
        public Boolean call() throws Exception {

            LogUtils.printJava(Thread.currentThread().getName()+"-----实现Callable方式");
            return true;
        }
    }
}
