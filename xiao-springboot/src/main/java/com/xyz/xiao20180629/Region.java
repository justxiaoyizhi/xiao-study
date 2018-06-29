package com.xyz.xiao20180629;

public class Region {

    // 编码，唯一标识
    private Integer code;

    // 父（省）编码
    private Integer upCode;

    // 全称
    private String name;

    public Region(Integer code, Integer upCode, String name) {
        this.code = code;
        this.upCode = upCode;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getUpCode() {
        return upCode;
    }

    public void setUpCode(Integer upCode) {
        this.upCode = upCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
