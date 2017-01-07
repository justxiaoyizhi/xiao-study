package com.xyz.util;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * xyz写的一些线程工具类
 *
 * @author xiao
 * @create 2017-01-06 18:37
 **/
public class XiaoThread {

    /**
     * 睡眠（秒钟）
     * @param second 睡眠的时间参数（秒钟）
     */
    public static void sleepSecond(long second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 睡眠（毫秒）
     * @param milliSeconds 睡眠的时间参数（毫秒）
     */
    public static void sleepMilliSeconds(long milliSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 随机睡眠（秒钟）
     * @param randomSecond 随机睡眠的时间参数（秒钟）
     */
    public static void sleepRandomSecond(int randomSecond) {
        Random random = new Random();
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(randomSecond));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回线程的名字
     * @return 线程的名字
     */
    public static String getThreadName() {
        return Thread.currentThread().getName()+"------";
    }
}
