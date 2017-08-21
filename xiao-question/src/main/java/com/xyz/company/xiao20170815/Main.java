package com.xyz.company.xiao20170815;

import java.util.concurrent.Executors;

/**
 * Created by Xiao on 2017/8/15.
 */
public class Main {

    public static void main(String[] args){

        String str = new String("12313");


        final String str1 = str;
        Executors.newCachedThreadPool().execute(new Runnable() {
            public void run() {
                System.out.println(str1);
            }
        });

    }
}
