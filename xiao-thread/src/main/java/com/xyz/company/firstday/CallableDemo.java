package com.xyz.company.firstday;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author xiao
 * @create 2016-12-28 17:38
 **/
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            list.add(service.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : list) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
                return;
            } finally {
                service.shutdown();
            }
        }

    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        for (int i = 1; i < 10; i++) {
            System.out.print(count(i)+" ");
        }
        return "result of TaskWithResult "+id;
    }

    private int count(int a) {
        if(a <= 2) {
            return 1;
        }
        return count(a-1) + count(a-2);
    }
}