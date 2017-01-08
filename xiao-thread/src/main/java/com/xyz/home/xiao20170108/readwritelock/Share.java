package com.xyz.home.xiao20170108.readwritelock;

import com.xyz.util.XiaoThread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Xiao on 2017/1/7.
 */
public class Share {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            // read some things
            System.out.println(XiaoThread.getThreadName()+"into read()");
            XiaoThread.sleepSecond(1);
            System.out.println(XiaoThread.getThreadName()+"finish read()");
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            // write some things
            System.out.println(XiaoThread.getThreadName()+"into write()");
            XiaoThread.sleepSecond(3);
            System.out.println(XiaoThread.getThreadName()+"finish write()");
        } finally {
            lock.writeLock().unlock();
        }
    }
}
