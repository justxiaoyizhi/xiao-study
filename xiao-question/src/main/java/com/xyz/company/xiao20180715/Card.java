package com.xyz.company.xiao20180715;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Card {

    /**
     * 数字
     */
    private String num;

    /**
     * 花色
     */
    private String color;

    @Override
    public String toString() {
        return "\"" + color + num + "\"";
    }
}
