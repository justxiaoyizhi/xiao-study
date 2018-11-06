package com.xyz.company.xiao20181106;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.error("msg:{}", "i am wrong!");
    }
}
