package com.xyz.home.xiao20170725;

/**
 * Created by Xiao on 2017/7/25.
 */
public class Main {

    public static void main(String[] args){
      TestNum num = new TestNum();
      ThreadClient t1 = new ThreadClient(num);
      ThreadClient t2 = new ThreadClient(num);
      ThreadClient t3 = new ThreadClient(num);
      t1.start();
      t2.start();
      t3.start();
    }
}
