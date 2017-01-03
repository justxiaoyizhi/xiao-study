package com.xyz.company.fourday.masterworker;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 主干类,收集任务以及分配任务给Worker，汇总Worker的结果
 *
 * @author xiao
 * @create 2017-01-03 17:49
 **/
public class Master {

    /**
     * 收集任务的阻塞队列
     */
    private BlockingQueue<Task> tasks = new LinkedBlockingDeque<Task>();

    /**
     * 注册所有的工作者Worker
     */
    private Map<String,Thread> workers = new HashMap<String, Thread>();

    /**
     * Worker写入结果（收集结果）
     */
    private ConcurrentHashMap<String,Object> results = new ConcurrentHashMap();

    public Master(Worker worker,int size) {
        for (int i = 0; i < size; i++) {
            worker.setTasks(tasks);
            worker.setResults(results);
            workers.put("worker"+i,new Thread(worker));
        }
    }

    /**
     * 收集任务
     * @param task 收集的任务
     */
    public void submit(Task task) {
        tasks.add(task);
    }

    /**
     * 执行计算
     */
    public void execute() {
        for (Map.Entry entry : workers.entrySet()) {
            ((Thread)entry.getValue()).start();
        }
    }

    /**
     * 是否结束
     * @return true为已经结束，false表示还没有结束
     */
    public boolean isComplete() {
        return CollectionUtils.isEmpty(tasks);
    }

    /**
     * 汇总结果
     * @return 将结果暴露
     */
    public long getResult() {
        int result = 0;
        for (Map.Entry<String, Object> entry : results.entrySet()) {
            result += (Integer) entry.getValue();
        }
        return result;

    }
}
