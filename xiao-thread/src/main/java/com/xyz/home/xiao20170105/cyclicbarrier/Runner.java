package com.xyz.home.xiao20170105.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 运动员，跑步者
 * Created by Xiao on 2017/1/5.
 */
public class Runner implements Runnable {

    private CyclicBarrier barrier;
    private Random random;
    private String name;

    public Runner(CyclicBarrier barrier, Random random, String name) {
        this.barrier = barrier;
        this.random = random;
        this.name = name;
    }

    public void run() {
        try {
            int time = random.nextInt(8);
            System.out.println(name+"--进入准备赛道-----等待时间是"+time+"秒");
            Thread.sleep(1000*time);
            System.out.println(name+"准备好了");
            barrier.await();
            System.out.println(name+"跑！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
