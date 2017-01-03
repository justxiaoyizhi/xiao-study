package com.xyz.thread.secondday;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 后台进程不进行finally
 *
 * @author xiao
 * @create 2016-12-30 18:47
 **/
public class ADaemon implements Runnable {
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Logger.getLogger(ADaemon.class.getName()).log(Level.INFO,e.getLocalizedMessage());
        } finally {
            System.out.println("This should always run?");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        //t.setDaemon(true);
        TimeUnit.MILLISECONDS.sleep(100);
        t.start();
    }
}
