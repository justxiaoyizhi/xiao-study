package com.xyz.home.xiao20170108.condition.providerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * (缓冲区)资源类，控制容器的处理
 *
 * @author xiao
 * @create 2017-01-04 18:55
 **/
public class Resource {

    public ArrayBlockingQueue<String> queue;

    public Lock lock = new ReentrantLock();

    Condition proCondition = lock.newCondition();
    Condition conCondition = lock.newCondition();

    public Resource(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    /**
     * 提供数据
     */
    public void provide() {
        try {
            lock.lock();
            // 已经放满了(重点在这里，要充分理解为什么是while不是if)
            /**
             * 死锁原因：生产者唤醒生产者，消费者唤醒消费者
             * 因为当我们第一个生产者wait时，第二个生产者也进来wait，第三个生产者也是。
             * 此时一个消费者notifyAll唤醒了第一个生产者，第一个生产者生产唤醒后唤醒第二个，
             * 如果是if的话，第二个生产者就不会再去判断，就再也睡不着了。
             * 如果是while,接着wait之后执行会再去判断，所以还是会睡着的。
             * http://www.cnblogs.com/shuqingstudy/p/5057382.html(感谢)
             */
            while (this.isFull()) {
                // 锁住生产者
                System.out.println("库存满了,不能提供了");
                proCondition.await();
            }
            Thread.sleep(200);
            queue.offer("xykj");
            System.out.println("提供了一个数据");
            conCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费数据
     */
    public void take() {
        try {
            lock.lock();
            // 已经没有数据了
            while (this.isEmpty()) {
                System.out.println("库存空了,不能再取了");
                conCondition.await();
            }
            Thread.sleep(200);
            String take = queue.take();
            System.out.println("取出了一个数据：" + take);
            proCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    /**
     * 缓冲区是否满了
     *
     * @return true is full, false not full
     */
    private boolean isFull() {
        try {
            lock.lock();
            return queue.size() == 10;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 缓冲区是否空了了
     *
     * @return true is empty, false not empty
     */
    private boolean isEmpty() {
        try {
            lock.lock();
            return queue.isEmpty();
        } finally {
            lock.unlock();
        }
    }
}
