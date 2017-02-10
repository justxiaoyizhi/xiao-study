package com.xyz.company.xiao20170120;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * 定时执行任务
 *
 * @author xiao
 * @create 2017-01-20 16:51
 **/
public class MsgSendRetryTaskExecutor extends ScheduledThreadPoolExecutor {
    public MsgSendRetryTaskExecutor(int corePoolSize) {
        super(corePoolSize);
    }


}
