package com.xyz.home.xiao20170105.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * 计划类
 * Created by Xiao on 2017/1/5.
 */
public class Plan implements Runnable {

    private CountDownLatch latch;

    public Plan(CountDownLatch latch) {
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
