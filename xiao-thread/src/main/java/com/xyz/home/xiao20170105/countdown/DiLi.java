package com.xyz.home.xiao20170105.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * 地利
 * Created by Xiao on 2017/1/5.
 */
public class DiLi implements Runnable {

    private CountDownLatch latch;

    public DiLi(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            Thread.sleep(2000);
            latch.countDown();
            System.out.println("地利已经启动");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
