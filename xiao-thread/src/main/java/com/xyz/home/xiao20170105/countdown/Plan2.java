package com.xyz.home.xiao20170105.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Xiao on 2017/1/5.
 */
public class Plan2 implements Runnable {

    private CountDownLatch latch;

    public Plan2(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            System.out.println("进入计划了,需要天时地利人和");
            latch.await();
            System.out.println("执行计划成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
