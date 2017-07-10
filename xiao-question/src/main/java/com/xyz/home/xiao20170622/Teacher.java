package com.xyz.home.xiao20170622;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * Created by Xiao on 2017/6/22.
 */
public class Teacher implements InitializingBean {

    public Teacher() {
        System.out.println("construct method : teacher");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method : teacher");

    }

    public void init() {
        System.out.println("init method : teacher");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct method : teacher");

    }
}
