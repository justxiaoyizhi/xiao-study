package com.xyz.xiao20180831;

import org.springframework.stereotype.Service;

@Service
public class BizService {

    @CodeTimer
    public void cal() {
        try {
            Thread.sleep(4075);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
