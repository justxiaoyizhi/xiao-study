package com.xyz.home.xiao20170107.dirtyread;

/**
 * Created by Xiao on 2017/1/8.
 */
public class ThreadOne implements Runnable {
    private Share share;

    public ThreadOne(Share share) {
        this.share = share;
    }

    public void run() {
        share.setValue("xiao","123456");
    }
}
