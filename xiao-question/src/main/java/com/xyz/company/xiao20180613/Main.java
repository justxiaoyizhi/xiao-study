package com.xyz.company.xiao20180613;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Object> objects = Lists.newArrayList();
        List<Object> collect = objects.stream().filter(o -> o.hashCode() == 11111).collect(Collectors.toList());
        System.out.println(collect);
    }

}
