package com.xyz.company.fourday.providerconsumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * (缓冲区)资源类，控制容器的处理
 *
 * @author xiao
 * @create 2017-01-04 18:55
 **/
public class Resource {

    private ArrayBlockingQueue<String> queue;

    public Resource(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    /**
     * 提供数据
     */
    public synchronized void provide() {
        try {
            // 已经放满了
            if(this.isFull()) {
                System.out.println("库存满了,不能提供了");
                this.wait();
            }
            Thread.sleep(500);
            queue.offer("xykj");
            System.out.println("提供了一个数据");
            // 通知消费者来消费
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消费数据
     */
    public synchronized void take() {
        try {
            // 已经没有数据了
            if (this.isEmpty()) {
                System.out.println("库存空了,不能再取了");
                this.wait();
            }
            Thread.sleep(500);
            String take = queue.take();
            System.out.println("取出了一个数据：" + take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notifyAll();
    }


    /**
     * 缓冲区是否满了
     * @return true is full, false not full
     */
    private boolean isFull() {
        return queue.size() == 10;
    }

    /**
     * 缓冲区是否空了了
     * @return true is empty, false not empty
     */
    private boolean isEmpty() {
        return queue.isEmpty();
    }
}
