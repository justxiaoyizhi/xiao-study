package com.xyz.company.xiao20170106.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 运行类
 *
 * @author xiao
 * @create 2017-01-06 18:25
 **/
public class Main {

    public static void main(String[] args) {
        // 有一个读书室
        ReaderRoom readerRoom = new ReaderRoom();
        // 读书室有5个座位
        readerRoom.setSeats(5);

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            service.execute(new Reader(readerRoom, "xiao" + i));
        }
        service.shutdown();
    }
}
