package com.xyz.home.xiao20170108.condition.providerconsumer;

/**
 * 生产者
 *
 * @author xiao
 * @create 2017-01-04 18:27
 **/
public class Producer implements Runnable {
    // 缓冲区
    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }


    public void run() {
        // 往里放数据
        while (true) {
            resource.provide();
        }
    }
}
