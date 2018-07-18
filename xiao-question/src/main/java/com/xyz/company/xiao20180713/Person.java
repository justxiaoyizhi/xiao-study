package com.xyz.company.xiao20180713;


import java.util.Objects;

public class Person {

    public Person(Integer id, Integer age) {
        this.id = id;
        this.age = age;
    }

    private Integer id;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age);
    }
}
