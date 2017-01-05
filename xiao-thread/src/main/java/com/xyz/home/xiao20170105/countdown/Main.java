package com.xyz.home.xiao20170105.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Xiao on 2017/1/5.
 */
public class Main {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(new Plan(latch));
        service.execute(new Plan2(latch));
        service.execute(new TianShi(latch));
        service.execute(new DiLi(latch));
        service.execute(new RenHe(latch));
        service.shutdown();
    }
}
