package company.xiao20180608;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        System.out.println("=============splitter==============");
        SplitterDemo splitterDemo = new SplitterDemo();
        splitterDemo.demo();

        System.out.println("=============joiner==============");

        // Joiner
        Map map = new HashMap();
        map.put("id",1);
        map.put("age",23);
        map.put("name", "xiao");
        String join = Joiner.on("&").withKeyValueSeparator("=").join(map);
        System.out.println(join);

        List<String> list = Lists.newArrayList("a", "bc", "dog");
        String result = Joiner.on(",").join(list);
        System.out.println(result);


//        MapsUnindexDemo mapsUnindexDemo = new MapsUnindexDemo();
//        mapsUnindexDemo.demo();

        List<String> list1 = Splitter.on(CharMatcher.ASCII).omitEmptyStrings().splitToList("我们fasg把 v 下成长");
        System.out.println(list1);
    }

}
