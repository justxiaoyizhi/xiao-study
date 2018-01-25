package com.xyz.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xiao on 2017/9/5.
 */
@Service
public class ThreadPoolManager {
    private ThreadPoolExecutor threadPoolExecutor;

    public ThreadPoolManager(){
        threadPoolExecutor = new ThreadPoolExecutor(2, 64, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(128));
    }

    public void execute(Runnable runnable){
        threadPoolExecutor.execute(runnable);
    }
}
