package com.xyz.home.xiao20170108.readwritelock;

/**
 * Created by Xiao on 2017/1/7.
 */
public class ThreadOne implements Runnable {

    private Share share;

    public ThreadOne(Share share) {
        this.share = share;
    }

    public void run() {
        share.read();
    }
}
