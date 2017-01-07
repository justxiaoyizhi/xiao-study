package com.xyz.home.xiao20170107.dirtyread;

import com.xyz.util.XiaoThread;

/**
 * Created by Xiao on 2017/1/8.
 */
public class Main {

    public static void main(String[] args) {
        // defaultValue {name:lin,password:1234}
        Share share = new Share();
        // 想将Value变为{name:xiao,password:123456}
        new Thread(new ThreadOne(share)).start();
        XiaoThread.sleepSecond(1);
        share.getValue();
    }
}
