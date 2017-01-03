package com.xyz.company.firstday;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单个线程执行器
 *
 * @author xiao
 * @create 2016-12-28 17:21
 **/
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
    }
}
