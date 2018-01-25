package com.xyz.controller.user;

import com.xyz.dto.UserDTO;
import com.xyz.service.ThreadPoolManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 用户的控制层
 *
 * @author xiao
 * @create 2017-03-30 12:08
 **/
@RestController
public class UserController {

    @Resource
    private ThreadPoolManager threadPoolManager;

    @RequestMapping("/home")
    public String home(HttpServletRequest request) throws InterruptedException {
        String name = request.getParameter("name");
        UserDTO userDTO = new UserDTO(name);

        System.out.println("web:"+name);
        final UserDTO test = userDTO;
        threadPoolManager.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(test.getName());
            }
        });
        return "home";
    }
}
