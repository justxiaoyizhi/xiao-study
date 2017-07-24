package com.xyz.home.xiao20170724;

/**
 * Created by Xiao on 2017/7/24.
 */
public class SafeListener {
    private final EventListener eventListener;

    private SafeListener(EventSource source) {
        eventListener = new EventListener() {
            public void onEvent(Event event) {
                doSomething();
            }
        };
    }

    public void doSomething() {
        System.out.println("do something");
    }



    public static SafeListener getInstance(EventSource source) {
        SafeListener safeListener = new SafeListener(source);
        source.register(safeListener.eventListener); // 启动一个线程,this才会被调用,那么就不会溢出
        return safeListener;
    }

    interface EventSource {
        void register(EventListener eventListener);
    }

    interface EventListener {
        void onEvent(Event event);
    }

    interface Event {

    }

}
