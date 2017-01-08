package com.xyz.home.xiao20170108.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.xyz.util.XiaoThread;

import java.nio.ByteBuffer;

/**
 * Created by Xiao on 2017/1/8.
 */
public class Main {

    public static void main(String[] args) {
        // 事件工厂类
        XiaoEventFactory eventFactory = new XiaoEventFactory();
        // 缓冲区大小
        int ringBufferSize = 1024 * 1024;
        // 线程工厂类
        XiaoEventThreadFactory threadFactory = new XiaoEventThreadFactory();
        // 创建一个Disruptor实例
        Disruptor<XiaoEvent> disruptor = new Disruptor<XiaoEvent>(eventFactory, ringBufferSize, threadFactory, ProducerType.SINGLE, new YieldingWaitStrategy());
        // 事件处理类（消费者）
        disruptor.handleEventsWith(new XiaoEventHandler());
        // 开始运行disruptor
        disruptor.start();
        // 得到缓冲区
        RingBuffer<XiaoEvent> ringBuffer = disruptor.getRingBuffer();
        // 生产数据（生产者）
        XiaoProducer producer = new XiaoProducer(ringBuffer);

        /****************** start: 生产数据 ******************/
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (int i = 0; i < 10; i++) {
            bb.putLong(0,i);
            producer.onData(bb);
            XiaoThread.sleepMilliSeconds(100);
        }
        /****************** end: 生产数据 ******************/
        disruptor.shutdown();
    }
}
