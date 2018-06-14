package company.xiao20180608;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.shiro.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: Splitter演示类
 * <p>
 * PackageName: company.xiao20180608
 * FileName: SplitterDemo.java
 * Copyright: Copyright (c)13/0. songxiaocai
 *
 * @author: xyz
 * @create: 13/06/2018
 */
public class SplitterDemo {

    public void demo() {

        String demoStr = ",1415 ,16,  ,17";
//        List<Integer> collect = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(demoStr)
//                .stream().map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("=============Guava的Splitter==============");
        List<String> strings = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(demoStr);
        System.out.println(strings);

        System.out.println("=============Java的for迭代==============");
        String[] split = demoStr.split(",");
        List<String> result = Lists.newArrayList();
        for (String s : split) {
            if (StringUtils.hasText(s)) {
                result.add(s);
            }
        }
        System.out.println(result);

        System.out.println("=============Java的流式操作==============");
        List<String> collect = Arrays.stream(split).filter(StringUtils::hasText).collect(Collectors.toList());
        System.out.println(collect);
    }

}
