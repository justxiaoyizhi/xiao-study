package com.xyz.home.xiao20170622;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Created by Xiao on 2017/6/22.
 */
public class Student implements InitializingBean {

    public Student() {
        System.out.println("construct method : student");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method : student");

    }

    public void init() {
        System.out.println("init method : student");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct method : student");

    }
}
