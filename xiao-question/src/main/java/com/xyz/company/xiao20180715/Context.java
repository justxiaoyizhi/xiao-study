package com.xyz.company.xiao20180715;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * Description: 上下文
 * <p>
 * PackageName: com.xyz.company.xiao20180715
 * FileName: Context.java
 * Copyright: Copyright (c)19/0. songxiaocai
 *
 * @author: xyz
 * @create: 19/07/2018
 */
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

    /**
     * description: 洗牌
     *
     * @param times 洗牌的次数
     * @return com.xyz.company.xiao20180715.Card[]
     * @author: xyz
     * @create: 15/07/2018
     */
    public Card[] washCard(int times) {
        return wash(this.cards, times);
    }

    /**
     * description:
     *
     * @param cards
     * @param times
     * @return com.xyz.company.xiao20180715.Card[]
     * @author: xyz
     * @create: 19/07/2018
     */
    private Card[] wash(Card[] cards, int times) {
        if (times == 0) {
            return cards;
        }
        int part = getCardLength() / 2;

        Card[] partCard = getPartCards(cards, part, 0);
        Card[] otherPartCard = getPartCards(cards, getCardLength() - part, part);
        Card[] cross = cross(partCard, otherPartCard);
        return wash(cross, times - 1);
    }


    /**
     * description: 将一副牌以{startPosition}为位置，partSize大小复制到一副新的牌
     *
     * @param cards         原来的牌
     * @param partSize      新的牌组大小
     * @param startPosition 新的牌大小
     * @return com.xyz.company.xiao20180715.Card[]
     * @author: xyz
     * @create: 19/07/2018
     */
    private Card[] getPartCards(Card[] cards, int partSize, int startPosition) {
        Card[] partCard = new Card[partSize];
        System.arraycopy(cards, startPosition, partCard, 0, partSize);
        return partCard;
    }

    /**
     * description: 牌交叉合并
     *
     * @param partCard      一部分的牌
     * @param otherPartCard 另一部分的牌
     * @return com.xyz.company.xiao20180715.Card[]
     * @author: xyz
     * @create: 19/07/2018
     */
    private Card[] cross(Card[] partCard, Card[] otherPartCard) {

        Card[] result = new Card[getCardLength()];

        List<Integer> randomNumList = genRandomNumList();

        int otherExistBot = 0;
        int existBot = 0;

        Boolean flag = new Random().nextBoolean();
        for (Integer randomNum : randomNumList) {

            // 交替进行
            if (flag) {
                // 如果超过数组大小了，抹去超过的数值
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

    /**
     * description: 获取随机数列表
     *
     * @return java.util.List<java.lang.Integer>
     * @author: xyz
     * @create: 19/07/2018
     */
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
