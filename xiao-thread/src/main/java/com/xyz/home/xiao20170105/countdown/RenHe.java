package com.xyz.home.xiao20170105.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Xiao on 2017/1/5.
 */
public class RenHe implements Runnable {
    private CountDownLatch latch;

    public RenHe(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            Thread.sleep(3000);
            latch.countDown();
            System.out.println("人和已经启动");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
