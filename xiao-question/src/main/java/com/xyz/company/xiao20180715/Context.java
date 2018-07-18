package com.xyz.company.xiao20180715;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Context {

    /**
     * 只能随机1～RANDOM_THRESHOLD的数字
     */
    private static final Integer RANDOM_THRESHOLD = 4;

    private Card[] cards;

    public Context(Card[] cards) {
        this.cards = cards;
    }

    public int getCardLength() {
        return cards.length;
    }

    public List<Card> washCard(int times) {
        List<Card> cards = Lists.newArrayList(wash(this.cards, times));
        System.out.println(cards);
        return cards;
    }

    private Card[] wash(Card[] cards, int times) {
        if (times == 0) {
            return cards;
        }
        int part = getCardLength() / 2;

        Card[] partCard = getPartCards(cards, part);
        Card[] otherPartCard = getOtherPartCards(cards, part);
        Card[] cross = cross(partCard, otherPartCard);
        return wash(cross, times - 1);
    }

    private Card[] getOtherPartCards(Card[] cards, int otherPart) {
        Card[] otherPartCard = new Card[otherPart];
        System.arraycopy(cards, cards.length - otherPart, otherPartCard, 0, otherPart);
        return otherPartCard;
    }

    private Card[] getPartCards(Card[] cards, int part) {
        Card[] partCard = new Card[part];
        System.arraycopy(cards, 0, partCard, 0, part);
        return partCard;
    }

    private Card[] cross(Card[] partCard, Card[] otherPartCard) {

        Card[] result = new Card[getCardLength()];

        List<Integer> randomNumList = genRandomNumList();

        int otherExistBot = 0;
        int existBot = 0;

        Boolean flag = new Random().nextBoolean();
        for (Integer randomNum : randomNumList) {

            if (flag) {
                if (otherExistBot + randomNum > otherPartCard.length) {
                    randomNum = otherPartCard.length - otherExistBot;
                }
                System.arraycopy(otherPartCard, otherExistBot, result, otherExistBot + existBot, randomNum);
                otherExistBot += randomNum;
                flag = !flag;
            } else {
                if (existBot + randomNum > partCard.length) {
                    randomNum = partCard.length - existBot;
                }
                System.arraycopy(partCard, existBot, result, otherExistBot + existBot, randomNum);
                existBot += randomNum;
                flag = !flag;
            }

        }

        return result;
    }

    private List<Integer> genRandomNumList() {
        Random random = new Random();
        List<Integer> randomNumList = Lists.newArrayList();

        for (int i = 0; i < getCardLength(); i++) {
            int randomNum = random.nextInt(RANDOM_THRESHOLD) + 1;
            randomNumList.add(randomNum);
        }

        return randomNumList;
    }

}
