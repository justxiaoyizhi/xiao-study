package com.xyz.company.xiao20170622;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Xiao on 2017/6/22.
 */
public class Main {

    public static void main(String[] args){
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode("123".getBytes());
        /**
         * 123对应的asc ii码是49 50 51 110000
         */
        System.out.println(encode);

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] mtIzs = decoder.decodeBuffer("MTIz");
            System.out.println(Arrays.toString(mtIzs));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
