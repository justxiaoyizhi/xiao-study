package com.xyz.company.xiao20170109;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器套接字
 *
 * @author xiao
 * @create 2017-01-09 19:54
 **/
public class XiaoServerSocket {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();
            new Thread(new SocketHandler(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
