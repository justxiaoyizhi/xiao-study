package com.xyz.home.xiao20170105.futuretask;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

/**
 * Created by Xiao on 2017/1/5.
 */
@AllArgsConstructor
public class Task implements Callable<String> {

    private String name;

    public String call() throws Exception {
        Thread.sleep(3000);
        return "执行完毕----"+name;
    }
}
