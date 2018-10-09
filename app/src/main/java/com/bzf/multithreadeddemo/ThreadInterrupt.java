package com.bzf.multithreadeddemo;

import com.bzf.multithreadeddemo.utils.LogUtils;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断示例
 * @author baizhengfu
 * @version 1.0
 * @since JDK1.8
 * @date 2018/10/4
 */
public class ThreadInterrupt {

    public void interruptThread(){
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }

    public static class MyRunnable implements Runnable{

        private  int i;

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                LogUtils.printJava(String.valueOf(i++));
            }
            LogUtils.printJava("线程运行完成");
        }
    }

}
