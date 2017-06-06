package company.xiao20170606.impl;

import company.xiao20170606.DemoService;

/**
 * Created by xiaoyizhi on 2017/6/6.
 */
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "hello " + name + ", i'm dubbo";
    }
}
