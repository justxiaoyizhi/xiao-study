package com.xyz.home.xiao20170725;

/**
 * Created by Xiao on 2017/7/25.
 */
public class ThreadClient extends Thread {

    private TestNum testNum;

    public ThreadClient(TestNum testNum) {
        this.testNum = testNum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + testNum.getNextNum());
        }
    }
}
