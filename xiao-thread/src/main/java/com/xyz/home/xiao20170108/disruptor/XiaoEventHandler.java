package com.xyz.home.xiao20170108.disruptor;

import com.lmax.disruptor.EventHandler;
import com.xyz.util.XiaoThread;

/**
 * Created by Xiao on 2017/1/8.
 */
public class XiaoEventHandler implements EventHandler<XiaoEvent> {

    public void onEvent(XiaoEvent xiaoEvent, long l, boolean b) throws Exception {
        System.out.println(XiaoThread.getThreadName()+xiaoEvent.getId());
    }
}
