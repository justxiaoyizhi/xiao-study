package com.xyz.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户的控制层
 *
 * @author xiao
 * @create 2017-03-30 12:08
 **/
@RestController
public class UserController {

    @RequestMapping("/home")
    public String home() throws InterruptedException {
        Thread.sleep(10000);
        return "home";
    }

    @RequestMapping("/")
    public String test() throws InterruptedException {
        return "{\"status\":1,\"desc\":\"成功\",\"body\":\"{}\"}";
    }

}
