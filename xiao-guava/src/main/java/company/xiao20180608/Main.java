package company.xiao20180608;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xyz.util.CodeTimer;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: 演示类
 * <p>
 * PackageName: company.xiao20180608
 * FileName: Main.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author: xyz
 * @create: 2018/6/8
 */
public class Main {

    public static void main(String[] args) {

            // Splitter
//        List<Integer> collect = Splitter.on(",").omitEmptyStrings().trimResults().trimResults(CharMatcher.is('1')).splitToList(", 1415,16,,17")
//                .stream().map(Integer::parseInt).collect(Collectors.toList());

//        List<String> strings = Splitter.on(",").omitEmptyStrings().trimResults().trimResults(CharMatcher.is('1')).splitToList(", 1415,16,,17");
//        System.out.println(strings);

            // Joiner
//        Map map = new HashMap();
//        map.put("id",1);
//        map.put("age",23);
//        map.put("name", "xiao");
//        String join = Joiner.on("&").withKeyValueSeparator("=").join(map);
//        System.out.println(join);


        MapsUnindexDemo mapsUnindexDemo = new MapsUnindexDemo();
        mapsUnindexDemo.demo();
    }

}
