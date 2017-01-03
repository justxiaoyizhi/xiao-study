package com.xyz.home.thinking;

/**
 * 关于递增的字节码解析
 *
 * @author xiao
 * @create 2016-12-30 15:27
 **/
public class AboutIncrement {

    private int i = 0;

    public static void main(String[] args) {
        int i = 1;
        i = i++;
        System.out.println(i);
    }

    public void add() {
        int i = 1;
        System.out.println(i++);
    }
}
