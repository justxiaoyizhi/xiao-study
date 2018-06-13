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
 * Description: MapsUniqueIndexDemo的演示类
 * 
 * PackageName: company.xiao20180608
 * FileName: MapsUnindexDemo.java
 * Copyright: Copyright (c)12/0. songxiaocai
 *
 * @author: xyz
 * @create: 12/06/2018
 */
public class MapsUnindexDemo {

    public void demo() {
        for (int j = 0; j < 10; j++) {
            // Maps的用法
            long start = CodeTimer.start();
            ArrayList<Student> students = Lists.newArrayListWithCapacity(1500000);
            for (int i = 0; i < 1000000; i++) {
                students.add(new Student(i, 10 + i, "小" + i));
            }


            ImmutableMap<Integer, Student> idKeyStudents = Maps.uniqueIndex(students, Student::getId);
//            System.out.println(idKeyStudents);

//            ImmutableMap<Integer, Student> idKeyStudents = Maps.uniqueIndex(students, Student::getAge);
//            System.out.println(idKeyStudents);

//            Map<Integer, Student> collect = students.stream().collect(Collectors.toMap(Student::getId, Function.identity()));
//            System.out.println(collect);

//            ImmutableListMultimap<Integer, Student> ageKeyStudents = Multimaps.index(students, Student::getAge);
//            ImmutableCollection<Map.Entry<Integer, Student>> entries = ageKeyStudents.entries();
//            System.out.println(entries);

            CodeTimer.store("codeTimeExec" + j, start);
        }

        CodeTimer.printAll();
    }

}
