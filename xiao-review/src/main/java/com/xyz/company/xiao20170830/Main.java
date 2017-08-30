package com.xyz.company.xiao20170830;

import java.util.concurrent.Future;

/**
 * Created by Xiao on 2017/8/30.
 */
public class Main {

    public static void main(String[] args) {
        ThreadPoolManager threadPoolManager = new ThreadPoolManagerImpl();
        try {
            Future future = threadPoolManager.submit(new CallableResult());
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadPoolManager.close();
    }
}
