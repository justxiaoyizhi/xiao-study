package com.xyz.home.xiao20170423;

/**
 * Created by Xiao on 2017/4/23.
 */
public class Main {
    public static void main(String[] args) {
        Client client = ClientBuilder.newBuilder().build();
        System.out.println(client.getMax());
    }
}
