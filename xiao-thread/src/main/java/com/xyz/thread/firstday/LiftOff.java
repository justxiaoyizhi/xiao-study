package com.xyz.thread.firstday;

/**
 * 测试并发代码运行时间
 *
 * @author xiao
 * @create 2016-12-28 15:59
 **/
public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public LiftOff() {
    }

    public void run() {
        while(countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }

    private String status() {
        return "#" + id +"(" + (countDown > 0 ? countDown : "Liftoff") + ")";
    }
}
