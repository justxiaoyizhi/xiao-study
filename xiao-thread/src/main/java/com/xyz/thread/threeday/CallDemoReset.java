package com.xyz.thread.threeday;

import java.util.concurrent.*;

/**
 * Created by Xiao on 2017/1/2.
 */
public class CallDemoReset {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(new TaskWithResult());
        String s = future.get();
        System.out.println(s);
        service.shutdown();
    }
}

class TaskWithResult implements Callable<String> {

    public String call() throws Exception {
        return "123";
    }
}
