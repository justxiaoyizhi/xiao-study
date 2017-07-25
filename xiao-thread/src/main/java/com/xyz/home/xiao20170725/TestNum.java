package com.xyz.home.xiao20170725;

/**
 * Created by Xiao on 2017/7/25.
 */
public class TestNum {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }
}
