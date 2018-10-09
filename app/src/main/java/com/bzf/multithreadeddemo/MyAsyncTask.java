package com.bzf.multithreadeddemo;

import android.os.AsyncTask;
import android.os.Handler;

import java.util.concurrent.Executors;

/**
 * AsyncTask示例
 * @author baizhengfu
 * @version 1.0
 * @since JDK1.8
 * @date 2018/10/9
 */
public class MyAsyncTask{


    public void base(){

        AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String //参数类型
                , Integer   //后台任务执行进度的类型
                , String>() { //返回结果的类型

            //在线程池中执行,执行一些耗时操作
            @Override
            protected String doInBackground(String... strings) {
                return null;
            }

            //在主线程中执行，在任务执行前调用
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            //在主线程中执行，任务完成时回调
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
            }

            //主线程中执行，用于更新进度
            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }
        };
        asyncTask.execute("");

        //并行处理任务
//        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR"");

        //还可以传入自定义的线程
//        asyncTask.executeOnExecutor(Executors.newCachedThreadPool(),"");

    }
    
}
