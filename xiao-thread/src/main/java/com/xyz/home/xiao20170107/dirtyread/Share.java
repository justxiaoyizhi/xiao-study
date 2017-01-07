package com.xyz.home.xiao20170107.dirtyread;

import com.xyz.util.XiaoThread;

/**
 * Created by Xiao on 2017/1/8.
 */
public class Share {

    private String name = "lin";
    private String password = "1234";

    public synchronized void setValue(String name, String password) {
        this.name = name;
        XiaoThread.sleepSecond(2);
        this.password = password;
        System.out.println("setValue的结果是----name:"+this.name+",password:"+this.password);
    }

    public synchronized void getValue() {
        System.out.println("getValue的结果是----name:"+name+",password:"+password);
    }
}
