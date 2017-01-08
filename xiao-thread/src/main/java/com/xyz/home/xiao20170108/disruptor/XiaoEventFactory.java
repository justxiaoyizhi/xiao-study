package com.xyz.home.xiao20170108.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Xiao on 2017/1/8.
 */
public class XiaoEventFactory implements EventFactory {

    public Object newInstance() {
        return new XiaoEvent();
    }
}
