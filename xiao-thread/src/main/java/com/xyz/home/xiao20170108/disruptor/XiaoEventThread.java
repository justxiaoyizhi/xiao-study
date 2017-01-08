package com.xyz.home.xiao20170108.disruptor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Xiao on 2017/1/8.
 */
public class XiaoEventThread extends Thread {

    private AtomicInteger atomic;
    private Runnable runnable;

    public XiaoEventThread(AtomicInteger atomic, Runnable runnable) {
        this.atomic = atomic;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        try {
            runnable.run();
        } finally {
            int c = atomic.getAndDecrement();
            System.out.println("terminate no " + c + " Threads");
        }
    }
}
