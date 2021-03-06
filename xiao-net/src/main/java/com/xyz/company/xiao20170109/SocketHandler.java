package com.xyz.company.xiao20170109;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.Socket;

/**
 * 处理客户端
 *
 * @author xiao
 * @create 2017-01-09 19:56
 **/
public class SocketHandler implements Runnable {

    private Socket socket;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            String str = IOUtils.toString(socket.getInputStream(), "utf-8");
            System.out.println(str);
            IOUtils.write("瞅你咋滴？",socket.getOutputStream());
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
