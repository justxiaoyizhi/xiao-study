package com.xyz.home.xiao20170107.threadnosafe;

import com.xyz.util.XiaoThread;

/**
 * Created by Xiao on 2017/1/7.
 */
public class Share {

    private int count = 5;

    /**
     * 对Share对象的成员变量count进行递减
     */
    public void desert() {
        count--;
        System.out.println(XiaoThread.getThreadName()+count);
    }
}
