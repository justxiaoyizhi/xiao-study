package com.xyz.company.xiao20170905;

import java.util.concurrent.Executors;

/**
 * Created by Xiao on 2017/9/5.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            main.test(new Context("name" + i));
        }
    }


    private void test(Context context) {
        final String str = context.getName();

        Executors.newCachedThreadPool().execute(new Runnable() {
            public void run() {
                System.out.println(str);
            }
        });
    }

}
