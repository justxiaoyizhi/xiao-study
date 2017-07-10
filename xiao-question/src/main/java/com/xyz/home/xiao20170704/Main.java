package com.xyz.home.xiao20170704;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xiao on 2017/7/4.
 */
public class Main {

    public static void main(String[] args){
        Map map = new HashMap();
        User user = new User();
        user.setId(1L);
        user.setName("1");
        map.put("1",user);
        user.setId(2L);
        map.put("2",user);
        System.out.println(map);
    }
}
