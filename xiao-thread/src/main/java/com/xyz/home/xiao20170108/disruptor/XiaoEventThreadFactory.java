package com.xyz.home.xiao20170108.disruptor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Xiao on 2017/1/8.
 */
public class XiaoEventThreadFactory implements ThreadFactory {

    private AtomicInteger atomic = new AtomicInteger(0);

    public Thread newThread(Runnable r) {
        int c = atomic.incrementAndGet();
        System.out.println("create no " + c + " Threads");
        return new XiaoEventThread(atomic,r);
    }
}
