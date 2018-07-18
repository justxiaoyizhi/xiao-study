package com.xyz.company.xiao20180713;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> peopleList = Lists.newArrayList(new Person(1, 10), new Person(2, 12), new Person(3, 15), new
                Person(1, 10));

        HashSet<Person> peopleSet = Sets.newHashSet(peopleList);

        System.out.println(peopleList.size() == peopleSet.size());
    }

}
