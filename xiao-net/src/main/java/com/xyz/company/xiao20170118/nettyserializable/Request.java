package com.xyz.company.xiao20170118.nettyserializable;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 请求信息
 *
 * @author xiao
 * @create 2017-01-18 19:51
 **/
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    @Setter
    @Getter
    private int id;
    @Setter
    @Getter
    private String name;

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
