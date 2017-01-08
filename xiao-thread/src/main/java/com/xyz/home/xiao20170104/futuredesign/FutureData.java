package com.xyz.home.xiao20170104.futuredesign;

/**
 * Created by Xiao on 2017/1/2.
 */
public class FutureData implements Data {

    private RealData realData;
    private boolean isLoadRealData = false;

    public synchronized RealData getRealData() {
        // 没有加载成功
        if(!isLoadRealData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData;
    }

    // 这里很重要，有点迷糊
    public synchronized void setRealData(RealData realData) {
        // 已经加载了
        if(isLoadRealData) {
            return;
        }
        this.realData = realData;
        isLoadRealData = true;
        notify();
    }

    public String getResult() {
        return this.getRealData().getResult();
    }
}
