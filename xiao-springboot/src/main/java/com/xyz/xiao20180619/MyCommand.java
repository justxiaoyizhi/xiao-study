package com.xyz.xiao20180619;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Scope(value = "prototype")
public class MyCommand {

    private int state;

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
