package com.xyz.company.xiao20170104.providerconsumer;

/**
 * 消费者
 *
 * @author xiao
 * @create 2017-01-04 18:28
 **/
public class Consumer implements Runnable {
    // 缓冲区
    private Resource resource;

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
