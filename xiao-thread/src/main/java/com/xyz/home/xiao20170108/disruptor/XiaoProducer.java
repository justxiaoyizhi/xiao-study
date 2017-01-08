package com.xyz.home.xiao20170108.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by Xiao on 2017/1/8.
 */
public class XiaoProducer {

    private RingBuffer<XiaoEvent> ringBuffer;

    public XiaoProducer(RingBuffer ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer) {
        // 得到数据的下一个索引
        long sequence = ringBuffer.next();
        try {
            // 得到空的“坑”
            XiaoEvent xiaoEvent = ringBuffer.get(sequence);
            xiaoEvent.setId(byteBuffer.getLong(0));
        } finally {
            // 发布索引里的数据
            ringBuffer.publish(sequence);
        }
    }
}
