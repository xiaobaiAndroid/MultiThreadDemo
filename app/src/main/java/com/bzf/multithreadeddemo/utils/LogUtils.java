package com.bzf.multithreadeddemo.utils;

/**
 * 日志打印工具
 * @author baizhengfu
 * @version 1.0
 * @since JDK1.8
 * @date 2018/10/4
 */
public class LogUtils {

    private static boolean isOpen = true;

    public static void printJava(String message){
        if(isOpen){

            System.out.println(message);
        }
    }

}
