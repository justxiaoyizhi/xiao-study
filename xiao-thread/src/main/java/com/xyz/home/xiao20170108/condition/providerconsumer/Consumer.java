package com.xyz.home.xiao20170108.condition.providerconsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消费者
 *
 * @author xiao
 * @create 2017-01-04 18:28
 **/
public class Consumer implements Runnable {
    // 缓冲区
    private Resource resource;

    private Lock lock = new ReentrantLock();

    public Consumer(Resource resource) {
        this.resource = resource;
    }


    public void run() {
        // 往外取数据
        while (true) {
            resource.take();
        }
    }
}
