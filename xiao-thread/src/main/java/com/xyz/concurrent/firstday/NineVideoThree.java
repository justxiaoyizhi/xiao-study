package com.xyz.concurrent.firstday;

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
}
