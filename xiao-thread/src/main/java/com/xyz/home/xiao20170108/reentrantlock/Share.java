package com.xyz.home.xiao20170108.reentrantlock;

import com.xyz.util.XiaoThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Xiao on 2017/1/7.
 */
public class Share {

    private int count = 6;

    private Lock lock = new ReentrantLock();

    /**
     * 对Share对象的成员变量count进行递减
     */
    public void desert() {
        try{
            lock.lock();
            count--;
            System.out.println(XiaoThread.getThreadName()+count);
        } finally {
            lock.unlock();
        }
    }
}
