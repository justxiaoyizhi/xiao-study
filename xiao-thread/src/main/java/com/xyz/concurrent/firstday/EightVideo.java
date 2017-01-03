package com.xyz.concurrent.firstday;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 第八个视频，模拟Queue
 *
 * @author xiao
 * @create 2016-12-30 13:54
 **/
public class EightVideo {

    private static LinkedList<String> ll = new LinkedList();

    private static final EightVideo ev = new EightVideo(5);
    private static int min_size = 0;
    private static int max_size;
    private static final Object lock = new Object();
    private static AtomicInteger count = new AtomicInteger(1);

    public EightVideo(int max_size) {
        this.max_size = max_size;
    }

    private void put(String s) {
        if (count.get() >= max_size) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ll.add(s);
        count.incrementAndGet();
        System.out.println("Hello #Thread1 put aaa time = " + count.get());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.notify();
    }

    private String get() {
        String object = null;
        synchronized (lock) {
            if (count.get() <= min_size) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            object = ll.getFirst();
            count.decrementAndGet();
            System.out.println("Hello #Thread2 get aaa time = " + count.get());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.notify();
        }
        return object;
    }

    // 放入
    private static Runnable r1 = new Runnable() {
        public void run() {
            synchronized (lock) {
                while (true) {
                    ev.put("aaaa");
                }
            }
        }
    };

    // 取出
    static Runnable r2 = new Runnable() {
        public void run() {
            while (true) {
                ev.get();
            }
        }
    };

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(r1);
        service.execute(r2);
    }

}
