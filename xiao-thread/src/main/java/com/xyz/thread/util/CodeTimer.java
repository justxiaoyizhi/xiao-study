package com.xyz.thread.util;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 代码计时器
 *
 * @author xiao
 * @create 2016-12-22 9:39
 **/
public class CodeTimer {
    private static final Map<String, AtomicLong> times = Maps.newConcurrentMap();

    public static void store(String key, long startTime) {
        if (!times.containsKey(key)) {
            times.put(key, new AtomicLong());
        }
        times.get(key).getAndAdd(System.currentTimeMillis() - startTime);
    }

    public static long start() {
        return System.currentTimeMillis();
    }

    public static void printAll() {
        System.out.println("\n-------------------\nxy.utils.CodeTimer\n-------------------");
        for (Map.Entry e : times.entrySet()) {
            System.out.printf("%s = %sms\n", e.getKey(), e.getValue());
        }
    }
}
