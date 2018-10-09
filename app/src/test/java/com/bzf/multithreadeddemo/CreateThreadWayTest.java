package com.bzf.multithreadeddemo;

import com.bzf.multithreadeddemo.utils.LogUtils;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class CreateThreadWayTest {

    @Test
    public void testThread(){
        new CreateThreadWay.myThread().start();
    }

    @Test
    public void testRunnable(){
        new Thread(new CreateThreadWay.MyRunnable()).start();
    }

    @Test
    public void testCallable(){
        CreateThreadWay.MyCallable callable = new CreateThreadWay.MyCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Boolean> future = executorService.submit(callable);

        try {
            if(future.get()){//此方法会阻塞当前线程
                LogUtils.printJava("线程运行完成");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            LogUtils.printJava("线程中断异常");
        } catch (ExecutionException e) {
            e.printStackTrace();
            LogUtils.printJava("线程执行异常");
        }
    }

}