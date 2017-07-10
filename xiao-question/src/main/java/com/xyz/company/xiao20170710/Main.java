package com.xyz.company.xiao20170710;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Xiao on 2017/7/10.
 */
public class Main {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1", "q");
        map.put("2", "w");
        map.put("3", "e");
        map.put("4", "r");

        // 第一种遍历
//        for (Object object : map.entrySet()) {
//            Map.Entry entry = (Map.Entry) object;
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }

        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
