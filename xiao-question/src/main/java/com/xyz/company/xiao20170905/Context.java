package com.xyz.company.xiao20170905;

/**
 * Created by Xiao on 2017/9/5.
 */
public class Context {
    private String name;

    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Context(String name) {
        this.name = name;
    }
}
