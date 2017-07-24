package com.xyz.home.xiao20170724;

/**
 * Created by Xiao on 2017/7/24.
 * Reference:http://blog.csdn.net/Le_773/article/details/52743165
 */
public class ThisEscape {

    public ThisEscape(EventSource source) {
        source.register(new EventListener() { // 启动一个线程,调用了this,但是对象可能还没有构造完成
            public void onEvent(Event event) {
                doSomething();
            }
        });
    }

    interface EventSource {
        void register(EventListener eventListener);
    }

    interface EventListener {
        void onEvent(Event event);
    }

    interface Event {

    }

    void doSomething() {
        System.out.println("do somethings");
    }

}
