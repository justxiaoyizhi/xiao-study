package com.xyz.home.xiao20170107.threadnosafe;

/**
 * Created by Xiao on 2017/1/7.
 */
public class Share {
    private String name;

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }
}
