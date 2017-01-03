package com.xyz.concurrent.firstday;

/**
 * double check lock 每次加锁
 *
 * @author xiao
 * @create 2016-12-30 17:47
 **/
public class NineVideoTwo {

    private NineVideoTwo() {

    }

    private static NineVideoTwo nineVideoTwo;

    public static NineVideoTwo getInstance() {
        synchronized (NineVideoTwo.class) {
            if(nineVideoTwo == null) {
                nineVideoTwo = new NineVideoTwo();
            }
            return nineVideoTwo;
        }
    }
}
