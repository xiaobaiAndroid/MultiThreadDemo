package com.bzf.multithreadeddemo;

import com.bzf.multithreadeddemo.utils.LogUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 四种线程池示例
 *
 * @author baizhengfu
 * @version 1.0
 * @date 2018/10/7
 * @since JDK1.8
 */
public class ThreadPool {


    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
//        threadPool.fixedThreadPool();
//        threadPool.cachedThreadPool();
//        threadPool.singleThreadPool();
//        threadPool.scheduledThreadPool();
        threadPool.customThreadPool();
    }


    /**
     *  自定义线程池
     * @author baizhengfu
     * @version 1.0
     * @since JDK1.8
     * @date 2018/10/7
     */
    public void customThreadPool(){
        int processors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(processors //核心线程数
                , Integer.MAX_VALUE //线程池允许创建的最大线程数
                , 60L //非核心线程闲置的超时时间，超过这个时间，线程会被回收。
                , TimeUnit.SECONDS //参数的时间单位
                , new SynchronousQueue<Runnable>() //任务队列类型
                ,new ThreadPoolExecutor.DiscardPolicy());//饱和策略

        for (int i = 0; i < 10; i++) {
            executor.execute(new MyRunnable(i));
        }
    }

    /**
     * 可重用固定线程池
     *
     * @author baizhengfu
     * @version 1.0
     * @date 2018/10/7
     * @since JDK1.8
     */
    public void fixedThreadPool() {
        int processors = Runtime.getRuntime().availableProcessors();
        LogUtils.printJava("cpu的核心数：" + processors);
        ExecutorService executorService = Executors.newFixedThreadPool(processors);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable(i));
        }
    }


    /**
     * 实现定时和周期性任务的线程池
     * @author baizhengfu
     * @return void
     * @throws 
     * @date 2018/10/7
     */
    public void scheduledThreadPool(){
        int processors = Runtime.getRuntime().availableProcessors();
        LogUtils.printJava("cpu的核心数：" + processors);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(processors);
        executorService.execute(new MyRunnable(0));//马上执行

        executorService.schedule(new MyRunnable(1),5000,TimeUnit.MINUTES);//延迟5秒执行


    }

    
    /**
     * 根据需要创建线程的线程池
     * @author baizhengfu
     * @return void
     * @throws 
     * @date 2018/10/7
     */
    public void cachedThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable(i));
        }
    }
    
    /**
     * 使用单个线程的工作池
     * @author baizhengfu
     * @return void
     * @throws 
     * @date 2018/10/7
     */
    public void singleThreadPool(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable(i));
        }
    }


    private static class MyRunnable implements Runnable {

        private int value;

        public MyRunnable(int value) {
            this.value = value;
        }

        @Override
        public void run() {

            LogUtils.printJava(Thread.currentThread().getName() + "开始处理---"+value);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LogUtils.printJava(Thread.currentThread().getName() + "处理完成---"+value);
        }

    }
}

