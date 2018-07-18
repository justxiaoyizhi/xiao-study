package com.xyz.company.xiao20180715;

public class Main {

    public static void main(String[] args) {
        Context context = new Context(Factory.initCard());
        context.washCard(3);
    }

}
