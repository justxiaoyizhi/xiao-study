package com.xyz.home.xiao20170104.futuredesign;

/**
 * Created by Xiao on 2017/1/2.
 */
public class FutureClient {

    // 返回一个代理的对象，表示请求成功，代理开一个线程自己去请求真实数据
    public FutureData sendRequest(final String queryStr) {
        final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            public void run() {
                // 请求到真实数据
                final RealData realData = new RealData(queryStr);
                // 必须要等请求真的结束
                futureData.setRealData(realData);
            }
        }).start();
        return futureData;
    }
}
