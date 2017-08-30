package com.xyz.company.xiao20170830;

import java.util.concurrent.*;

/**
 * Created by Xiao on 2017/8/30.
 */
public class ThreadPoolManagerImpl implements ThreadPoolManager {

    private ThreadPoolExecutor threadPoolExecutor;

    public void execute(Runnable runnable) throws Exception {
        threadPoolExecutor.execute(runnable);
    }

    public Future submit(Callable callable) throws Exception {
        return threadPoolExecutor.submit(callable);
    }

    public ThreadPoolManagerImpl() {
        threadPoolExecutor = new ThreadPoolExecutor(30, 60, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(128));
    }

    public void close() {
        threadPoolExecutor.shutdown();
    }
}
