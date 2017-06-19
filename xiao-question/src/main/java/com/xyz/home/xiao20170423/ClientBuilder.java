package com.xyz.home.xiao20170423;

/**
 * Created by Xiao on 2017/4/23.
 */
public class ClientBuilder {

    private int max;

    ClientBuilder() {}

    public static ClientBuilder newBuilder() {
        return new ClientBuilder();
    }

    public ClientBuilder setMax(int max) {
        this.max = max;
        return this;
    }

    public int getMax() {
        return max;
    }

    public Client build() {
        return new Client(this);
    }
}
