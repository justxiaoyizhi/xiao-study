package com.xyz.company.xiao20170118.nettyserializable;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 响应信息
 *
 * @author xiao
 * @create 2017-01-18 19:57
 **/
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    private int status;

    @Setter
    @Getter
    private String desc;

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }
}
