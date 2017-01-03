package com.xyz.company.firstday;

/**
 * 主线程
 *
 * @author xiao
 * @create 2016-12-28 16:27
 **/
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        Thread t = new Thread(launch);
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
