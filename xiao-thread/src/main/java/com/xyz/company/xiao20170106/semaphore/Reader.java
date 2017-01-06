package com.xyz.company.xiao20170106.semaphore;

import com.xyz.util.XiaoThread;

/**
 * 阅读者
 *
 * @author xiao
 * @create 2017-01-06 18:26
 **/
public class Reader implements Runnable {

    private ReaderRoom readerRoom;
    private String name;

    public Reader(ReaderRoom readerRoom, String name) {
        this.readerRoom = readerRoom;
        this.name = name;
    }

    /**
     * 坐下，抢到座位
     */
    private void sit() {
        try {
            readerRoom.getSemaphore().acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 离开，放开座位
     */
    private void leave() {
        readerRoom.getSemaphore().release();
    }


    public void run() {
        sit();
        System.out.println(name+"----坐下来了");
        // 学习
        XiaoThread.sleepRandomSecond(8);
        System.out.println(name+"----离开了读书室");
        leave();
    }
}
