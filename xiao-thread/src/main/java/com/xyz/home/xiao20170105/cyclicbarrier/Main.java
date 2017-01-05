package com.xyz.home.xiao20170105.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Xiao on 2017/1/5.
 */
public class Main {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4);
        Random random = new Random();
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(new Runner(barrier, random, "小红"));
        service.execute(new Runner(barrier, random, "小李"));
        service.execute(new Runner(barrier, random, "小毛"));
        service.execute(new Runner(barrier, random, "小黑"));
        service.shutdown();
    }
}
