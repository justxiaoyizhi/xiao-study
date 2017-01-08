package com.xyz.company.xiao20170104.masterworker;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 工作者，计算
 *
 * @author xiao
 * @create 2017-01-03 17:50
 **/
public class Worker implements Runnable {

    @Setter
    @Getter
    private BlockingQueue tasks;

    @Setter
    @Getter
    private ConcurrentHashMap results;

    public void run() {
        while(true) {
            try {
                Thread.sleep(500);
                Task task = (Task) tasks.poll();
                if(task == null) {
                    break;
                }
                //System.out.println("执行了一些计算");
                // TODO: 优化，给一个实现类去实现业务逻辑
                Task out = handler(task);
                results.put(String.valueOf(task.getId()),task.getPrice());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理数据
     * @param task 传入的数据
     * @return 计算后的数据
     */
    private Task handler(Task task) {
        // 假装执行一大堆计算
        return task;
    }
}
