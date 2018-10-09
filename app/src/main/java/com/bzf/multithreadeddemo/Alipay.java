package com.bzf.multithreadeddemo;

import com.bzf.multithreadeddemo.utils.LogUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  转账示例类
 * @author baizhengfu
 * @version 1.0
 * @since JDK1.8
 * @date 2018/10/4
 */
public class Alipay {

    private double[] accounts;
    private Condition condition;
    private Lock lock;

    private Object obj = new Object();

    public Alipay(int n, double money){
        accounts = new double[n];
        lock = new ReentrantLock();

        condition = lock.newCondition();

        for(int i=0; i<accounts.length; i++){
            accounts[i] = money;
        }
    }

    /**
     * @author baizhengfu
     * @param amount 转账金额
     * @return void
     * @throws 
     * @date 2018/10/4
     */
    public void transfer(int from,int to,int amount) throws InterruptedException{
        lock.lock();

        try {
            while (accounts[from]<amount){
                //阻塞当前线程，并放弃锁
                condition.await();
                LogUtils.printJava("转账方："+from+",余额不足，暂停执行");
            }

            accounts[from] = accounts[from] - amount;
            accounts[to] = accounts[to] + amount;

            LogUtils.printJava("转账方："+from+"给接收方："+to+"转账"+amount+"元,转账方余额："+accounts[from]+",接收方余额："+accounts[to]);

            //激活因为调用await方法阻塞的所有线程，它仅仅接触了阻塞状态。是否运行还是根据系统调度。
            condition.signalAll();
        } finally {
            lock.unlock();//释放锁
        }
    }

    /**
     * 同步方法
     * @author baizhengfu
     * @return void
     * @throws 
     * @date 2018/10/4
     */
    public synchronized void transfer2(int from,int to,int amount)throws InterruptedException{
        while(accounts[from]<amount){
            wait();
            LogUtils.printJava("转账方："+from+",余额不足，暂停执行");
        }
        accounts[from] = accounts[from] - amount;
        accounts[to] = accounts[to] + amount;

        LogUtils.printJava("转账方："+from+"给接收方："+to+"转账"+amount+"元,转账方余额："+accounts[from]+",接收方余额："+accounts[to]);

        notifyAll();
    }


    /**
     * 同步代码块
     * @author baizhengfu
     * @return void
     * @throws 
     * @date 2018/10/4
     */
    public  void transfer3(int from,int to,int amount)throws InterruptedException{
        synchronized(obj){
            while(accounts[from]<amount){
                LogUtils.printJava("转账方："+from+",余额不足，暂停执行");
                return;
            }
            accounts[from] = accounts[from] - amount;
            accounts[to] = accounts[to] + amount;

            LogUtils.printJava("转账方："+from+"给接收方："+to+"转账"+amount+"元,转账方余额："+accounts[from]+",接收方余额："+accounts[to]);
        }

    }


}
