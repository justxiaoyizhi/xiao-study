package com.xyz.home.thinking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 关于自增是不是原子性
 *
 * @author xiao
 * @create 2016-12-30 14:06
 **/
public class AtomicIncrement {

    private static int total = 0;
    private static int countT1 = 0;
    private static int countT2 = 0;
    private boolean run = true;

    public AtomicIncrement() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(t1);
        executorService.execute(t2);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(AtomicIncrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        run = false;
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(AtomicIncrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println((countT1 + countT2 + " == " + total));


    }

    private Runnable t1 = new Runnable() {
        public void run() {
            while (run) {
                total++;
                countT1++;
                System.out.println("Hello #" + countT1 + " from Thread 1! Total hello: " + total);
            }
        }
    };

    private Runnable t2 = new Runnable() {
        public void run() {
            while (run) {
                total++;
                countT2++;
                System.out.println("Hello #" + countT2 + " from Thread 2! Total hello: " + total);
            }
        }
    };

    public static void main(String[] args) {
        new AtomicIncrement();
    }
}
