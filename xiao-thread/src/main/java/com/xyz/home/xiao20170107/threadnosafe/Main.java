package com.xyz.home.xiao20170107.threadnosafe;

import com.xyz.util.XiaoThread;

/**
 * Created by Xiao on 2017/1/7.
 */
public class Main {

    public static void main(String[] args) {
        Share share = new Share();
        share.setName("share");
        new Thread(new ThreadOne(share)).start();
        new Thread(new ThreadTwo(share)).start();
        XiaoThread.sleepMilliSeconds(1000);
        System.out.println(share.getName());
    }
}
