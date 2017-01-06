package com.xyz.company.xiao20170106.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 读书室
 *
 * @author xiao
 * @create 2017-01-06 18:26
 **/
public class ReaderRoom {

    /**
     * 读书室的座位
     */
    private Semaphore semaphore;

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSeats(int seats) {
        semaphore = new Semaphore(seats);
    }
}
