package com.xyz.concurrent.firstday;

/**
 * 第九个视频——单例遇上多线程
 *
 * @author xiao
 * @create 2016-12-30 17:33
 **/
public class NineVideo {

    private NineVideo() {
    }

    private static class Single {
        private static NineVideo single = new NineVideo();
    }

    public static NineVideo getInstance() {
        return Single.single;
    }
}
