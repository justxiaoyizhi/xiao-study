package com.xyz.home.xiao20170108.readwritelock;

/**
 * Created by Xiao on 2017/1/7.
 */
public class ThreadTwo implements Runnable {

    private Share share;

    public ThreadTwo(Share share) {
        this.share = share;
    }

    public void run() {
        share.read();
    }
}
