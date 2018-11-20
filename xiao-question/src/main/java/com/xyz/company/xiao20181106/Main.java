package com.xyz.company.xiao20181106;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Main.class);
    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.error("msg:{}");
    }
}
