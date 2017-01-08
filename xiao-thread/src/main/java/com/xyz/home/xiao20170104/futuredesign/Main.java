package com.xyz.home.xiao20170104.futuredesign;

/**
 * Created by Xiao on 2017/1/2.
 */
public class Main {
    public static void main(String[] args) {
        // 创建一个FutureClient对象发送请求数据库数据
        FutureClient client = new FutureClient();
        // 得到数据的虚假反馈信息
        Data data = client.sendRequest("xiao");
        System.out.println("请求发送成功");
        System.out.println("做其他事情");
        // 获取RealData比较慢，所以要加锁锁住
        String result = data.getResult();
        System.out.println(result);
    }
}
