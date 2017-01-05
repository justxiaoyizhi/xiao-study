package com.xyz.home.xiao20170105.futuretask;

import com.xyz.company.util.CodeTimer;

import java.util.concurrent.*;

/**
 * Created by Xiao on 2017/1/5.
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = CodeTimer.start();
        ExecutorService service = Executors.newFixedThreadPool(2);
        // FutureTask模式
        FutureTask task = new FutureTask(new Task("小兰"));
        Future<?> submit = service.submit(task);
        // 直接Future模式
        Future<String> future = service.submit(new Task("小红"));
        String s = future.get();
        // FutureTask中Future的get()
        System.out.println(submit.get());
        // FutureTask的get()
        System.out.println(task.get());
        // Future的get()
        System.out.println(s);
        System.out.println("执行完了");
        CodeTimer.store("thread", start);
        CodeTimer.printAll();
    }
}
