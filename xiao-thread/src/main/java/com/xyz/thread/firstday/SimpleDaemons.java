package com.xyz.thread.firstday;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程学习
 *
 * @author xiao
 * @create 2016-12-28 20:01
 **/
public class SimpleDaemons implements Runnable {

    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread()+" : "+this);
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new SimpleDaemons());
            t.setDaemon(true);
            t.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
