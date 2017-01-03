package com.xyz.home.firstday;

/**
 * double check lock
 * 指令重排序，需要添加volatile
 * @author xiao
 * @create 2016-12-30 17:57
 **/
public class NineVideoThree {
    private volatile static NineVideoThree nineVideoThree;

    private NineVideoThree() {

    }

    public static NineVideoThree getInstance() {
        if(nineVideoThree == null) {
            synchronized (NineVideoThree.class) {
                if(nineVideoThree == null) {
                    nineVideoThree = new NineVideoThree();/** http://www.oschina.net/question/2611757_2194452?fromerr=hoOa9wuB **/
                }
            }
        }
        return nineVideoThree;
    }

    /*public class Singleton {
        private static Singleton instance = null;
        private Singleton() { }
        public static Singleton getInstance() {
            if(instance == null) {
                synchronzied(Singleton.class) {
                    Singleton temp = instance;
                    if(temp == null) {
                        temp = new Singleton();
                        instance = temp
                    }
                }
            }
            return instance;
        }
    }*/
}
