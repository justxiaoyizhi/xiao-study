package com.xyz.home.xiao20170107.threadnosafe;

/**
 * Created by Xiao on 2017/1/7.
 */
public class Main {

    public static void main(String[] args) {
        Share share = new Share();
        // 五个线程执行
        new Thread(new ThreadOne(share)).start();
        new Thread(new ThreadOne(share)).start();
        new Thread(new ThreadOne(share)).start();
        new Thread(new ThreadOne(share)).start();
        new Thread(new ThreadOne(share)).start();
    }
}
