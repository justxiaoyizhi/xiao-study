package com.xyz.home.xiao20170423;

/**
 * Created by Xiao on 2017/4/23.
 */
public class Client {

    private int max;
    Client(ClientBuilder builder) {
        this.max = builder.getMax();
    }
    public int getMax() {
        return max;
    }
}
