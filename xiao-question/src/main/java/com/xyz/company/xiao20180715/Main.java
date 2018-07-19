package com.xyz.company.xiao20180715;

import com.google.common.collect.Lists;

public class Main {

    public static void main(String[] args) {
        Card[] initCards = Factory.initCard();
        System.out.println("初始化之前的牌组:" + Lists.newArrayList(initCards));
        Context context = new Context(initCards);

        Card[] cards = context.washCard(3);
        System.out.println("洗牌后的牌组:" + Lists.newArrayList(cards));
    }

}
