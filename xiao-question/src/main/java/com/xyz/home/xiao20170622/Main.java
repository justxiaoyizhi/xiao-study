package com.xyz.home.xiao20170622;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Xiao on 2017/6/22.
 */
public class Main {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("message.xml");
    }
}
