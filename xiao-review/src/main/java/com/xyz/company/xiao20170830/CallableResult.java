package com.xyz.company.xiao20170830;

import java.util.concurrent.Callable;

/**
 * Created by Xiao on 2017/8/30.
 */
public class CallableResult implements Callable {

    public String call() throws Exception {
        System.out.println("!!!");
        return "result";
    }
}
