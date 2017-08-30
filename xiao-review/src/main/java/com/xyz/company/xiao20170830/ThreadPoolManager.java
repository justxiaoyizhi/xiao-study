package com.xyz.company.xiao20170830;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by Xiao on 2017/8/30.
 */
public interface ThreadPoolManager {

    void execute(Runnable runnable) throws Exception;

    Future submit(Callable callable) throws Exception;

    void close();
}
