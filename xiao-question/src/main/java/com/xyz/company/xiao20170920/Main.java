package com.xyz.company.xiao20170920;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Xiao on 2017/9/20.
 */
@Slf4j
public class Main {

    public static void main(String[] args) {

        try {
            Main main = new Main();
            main.test();
        } catch (Exception e) {
            log.error("meet exception", e);
        }
        System.out.println(111);
    }

    public void test() {
        String s = null;
        System.out.println(s.length());
    }
}
