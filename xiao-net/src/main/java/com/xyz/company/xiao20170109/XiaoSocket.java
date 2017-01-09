package com.xyz.company.xiao20170109;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.Socket;

/**
 * 客户端
 * @author xiao
 * @create 2017-01-09 20:01
 **/
public class XiaoSocket {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.1.73",9999);
            IOUtils.write("见到你很高兴",socket.getOutputStream());
            String response = IOUtils.toString(socket.getInputStream(), "utf-8");
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
