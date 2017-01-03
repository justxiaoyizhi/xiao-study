package com.xyz.home.threeday.futuredesign;

/**
 * Created by Xiao on 2017/1/2.
 */
public class RealData implements Data {

    private String result;

    public RealData(String queryStr) {
        // 模拟已经在数据库取数据
        System.out.println("根据" + queryStr + "进行查询，这是一个很耗时的操作");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("操作完毕，获取结果");
        result = "结果";
    }

    public String getResult() {
        return result;
    }
}
