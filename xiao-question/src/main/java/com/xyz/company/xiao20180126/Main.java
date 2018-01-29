package com.xyz.company.xiao20180126;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xiao on 2018/1/26.
 */
public class Main {

    public static void main(String[] args){
        Map<String, String> params = new HashMap<String, String>();
        params.put("33","6456537");
        params.put("23","6456547");
        params.put("13","6456517");
        for (Map.Entry<String, String> stringStringEntry : params.entrySet()) {
            System.out.println(stringStringEntry.getValue());
        }
    }

}
