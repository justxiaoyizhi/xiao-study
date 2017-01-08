package com.xyz.home.xiao20170108.readwritelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Xiao on 2017/1/7.
 */
public class Main {

    public static void main(String[] args) {
        Share share = new Share();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new ThreadOne(share));
        service.execute(new ThreadTwo(share));
        service.execute(new ThreadThree(share));
        service.shutdown();
    }
}
