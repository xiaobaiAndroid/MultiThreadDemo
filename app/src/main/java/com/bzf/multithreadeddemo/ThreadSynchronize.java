package com.bzf.multithreadeddemo;

import com.bzf.multithreadeddemo.utils.LogUtils;

/**
 *  线程同步示例
 * @author baizhengfu
 * @version 1.0
 * @since JDK1.8
 * @date 2018/10/4
 */
public class ThreadSynchronize {

    /**
     * Lock示例
     * @author baizhengfu
     * @return void
     * @throws 
     * @date 2018/10/4
     */
    public void testLock(){
        final int number = 6;
        final Alipay alipay = new Alipay(number, 20);
        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.printJava("开启线程："+Thread.currentThread().getName());
                try {
                    alipay.transfer(0,1,15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.printJava("开启线程："+Thread.currentThread().getName());
                try {
                    alipay.transfer(0,2,15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.printJava("开启线程："+Thread.currentThread().getName());
                try {
                    alipay.transfer(3,0,15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }


    /**
     * 测试同步方法
     * @author baizhengfu
     * @return void
     * @throws
     * @date 2018/10/4
     */
    public void testSynchronize(){
        final int number = 6;
        final Alipay alipay = new Alipay(number, 20);
        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.printJava("开启线程："+Thread.currentThread().getName());
                try {
                    alipay.transfer2(0,1,15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.printJava("开启线程："+Thread.currentThread().getName());
                try {
                    alipay.transfer2(0,2,15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.printJava("开启线程："+Thread.currentThread().getName());
                try {
                    alipay.transfer2(3,0,15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    /**
     * 测试同步代码块
     * @author baizhengfu
     * @return void
     * @throws
     * @date 2018/10/4
     */
    public void testSynchronizePiece(){
        final int number = 6;
        final Alipay alipay = new Alipay(number, 20);
        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.printJava("开启线程："+Thread.currentThread().getName());
                try {
                    alipay.transfer3(0,1,15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.printJava("开启线程："+Thread.currentThread().getName());
                try {
                    alipay.transfer3(0,2,15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.printJava("开启线程："+Thread.currentThread().getName());
                try {
                    alipay.transfer3(3,0,15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
