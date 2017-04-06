package com.xyz.home.xiao20170405;

import java.io.UnsupportedEncodingException;

/**
 * Created by Xiao on 2017/4/5.
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] b = {104, 101, 108, 108, 111, 119, 111, 114, 108, 100, 57, 51};
        String s = new String(b,"utf-8");
        System.out.println(s);
    }
}
