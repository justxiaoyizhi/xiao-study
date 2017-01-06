package com.xyz.home.xia20170107.threadnosafe;

/**
 * Created by Xiao on 2017/1/7.
 */
public class ThreadTwo implements Runnable {

    private Share share;

    public ThreadTwo(Share share) {
        this.share = share;
    }

    public void run() {
        share.setName("ThreadTwo");
    }
}
