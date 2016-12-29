package com.xyz.thread.firstday;

/**
 * @author xiao
 * @create 2016-12-28 16:39
 **/
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
            System.out.println("Waiting for LiftOff");
        }
    }
}
