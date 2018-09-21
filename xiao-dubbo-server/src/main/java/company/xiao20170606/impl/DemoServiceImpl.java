package company.xiao20170606.impl;

import com.alibaba.dubbo.config.annotation.Service;
import company.xiao20170606.DemoService;

/**
 * Created by xiaoyizhi on 2017/6/6.
 */
@Service
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        throw new ClassCastException("not cast");
//        return "hello " + name + ", i'm dubbo";
    }
}
