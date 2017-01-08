package com.xyz.company.xiao20170104.providerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 运行类
 *
 * @author xiao
 * @create 2017-01-04 18:27
 **/
public class Main {
    public static void main(String[] args) {
        // 缓冲区的队列
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        // 缓冲区
        Resource resource = new Resource(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new Producer(resource));
            service.execute(new Consumer(resource));
        }
    }
}
