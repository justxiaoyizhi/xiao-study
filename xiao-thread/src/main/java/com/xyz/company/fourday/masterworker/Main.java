package com.xyz.company.fourday.masterworker;

import java.util.Random;

/**
 * 运行类
 *
 * @author xiao
 * @create 2017-01-03 17:49
 **/
public class Main {


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Random random = new Random();

        // 定义一个任务调度器，里面住了一些Worker，以及开多少个线程
        Master master = new Master(new Worker(),10);
        for (int i = 0; i < 100; i++) {
            Task task = new Task();
            task.setId(i);
            task.setName("Task" + i);
            task.setPrice(random.nextInt(1000));
            // 提交任务
            master.submit(task);
        }
        // 开启线程执行
        long start = System.currentTimeMillis();
        master.execute();

        // 判断是否结束
        while(true) {
            if(master.isComplete()) {
                break;
            }
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("执行了"+time+"时间,最终结果是"+master.getResult());
    }
}
