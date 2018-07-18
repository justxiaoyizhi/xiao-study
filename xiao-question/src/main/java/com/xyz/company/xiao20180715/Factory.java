package com.xyz.company.xiao20180715;

public class Factory {

    private static String[] numList = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private static String[] colors = {"红桃", "黑桃", "方块", "梅花"};

    public static Card[] initCard() {
        Card[] cards = new Card[52];
        int count = 0;

        for (String num : numList) {
            for (String color : colors) {
                cards[count] = new Card(num, color);
                count++;
            }
        }

        return cards;
    }

}
