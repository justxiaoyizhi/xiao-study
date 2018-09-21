package company.xiao20170606.impl;

import com.alibaba.dubbo.config.annotation.Service;
import company.xiao20170606.DemoService;
import company.xiao20180921.CustomException;

/**
 * Created by xiaoyizhi on 2017/6/6.
 */
@Service
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        throw new CustomException("not cast");
//        return "hello " + name + ", i'm dubbo";
    }
}
