package com.xyz.home.xiao20170111.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Xiao on 2017/1/11.
 */
public class Client {
    //创建缓冲区
    private ByteBuffer buffer = ByteBuffer.allocate(1024);
    //访问服务器

    public void query(String host, int port) throws IOException {
        InetSocketAddress address = new InetSocketAddress(host, port);
        SocketChannel socket = null;
        socket = SocketChannel.open();
        socket.connect(address);
        while (true) {
            try {
                byte[] bytes = new byte[1024];
                System.in.read(bytes);
                buffer.put(bytes);
                buffer.flip();
                socket.write(buffer);
                buffer.clear();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    socket.close();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Client().query("127.0.0.1", 8099);
    }
}
