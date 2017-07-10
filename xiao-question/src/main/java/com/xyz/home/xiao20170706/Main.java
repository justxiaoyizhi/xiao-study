package com.xyz.home.xiao20170706;

import java.util.Date;

/**
 * Created by Xiao on 2017/7/6.
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {

                public void run() {
                    Date date = DateUtil.processEndTime(DateUtil.parseEndTime("20:12:12"));
                    System.out.println(date);
                }
            }).start();

        }
    }

}
