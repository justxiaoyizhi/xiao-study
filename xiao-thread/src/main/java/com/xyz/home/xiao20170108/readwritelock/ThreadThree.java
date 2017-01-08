package com.xyz.home.xiao20170108.readwritelock;

/**
 * Created by Xiao on 2017/1/7.
 */
public class ThreadThree implements Runnable {

    private Share share;

    public ThreadThree(Share share) {
        this.share = share;
    }

    public void run() {
        share.write();
    }
}
