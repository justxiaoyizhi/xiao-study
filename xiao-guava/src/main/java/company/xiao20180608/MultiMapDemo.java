package company.xiao20180608;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MultiMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: MultiMap演示类
 * <p>
 * PackageName: company.xiao20180608
 * FileName: MultiMapDemo.java
 * Copyright: Copyright (c)12/0. songxiaocai
 *
 * @author: xyz
 * @create: 12/06/2018
 */
public class MultiMapDemo {

    public void demo() {
        Map<Integer, List<Student>> map = new HashMap();
        if (!map.containsKey(1)) {
            map.put(1, Lists.newArrayList());
        }
        map.get(1).add(new Student(1, 15, "demo"));


        ArrayListMultimap<Integer, Student> multimap = ArrayListMultimap.create();
        multimap.put(1, new Student(1, 15, "demo"));
        List<Student> students = multimap.get(1);
        System.out.println(students);
    }

}
