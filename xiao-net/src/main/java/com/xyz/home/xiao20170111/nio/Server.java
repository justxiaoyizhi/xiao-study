package com.xyz.home.xiao20170111.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

/**
 * Created by Xiao on 2017/1/11.
 */
public class Server implements Runnable {

    private Selector selector;

    private ByteBuffer bb = ByteBuffer.allocate(1024);

    public Server(int port) {
        init(port);
    }

    /**
     * 初始化Server
     */
    private void init(int port) {
        try {
            // 实例化选择器
            this.selector = SelectorProvider.provider().openSelector();
            // 打开服务器管道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 配置为非阻塞
            serverSocketChannel.configureBlocking(false);
            // 绑定到端口上
            serverSocketChannel.bind(new InetSocketAddress(port));
            // 将选择器注册到通道上，返回一个选择键
            serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                System.out.println("running ... ");
                //多路复用选择器开始监听
                this.selector.select();

                Iterator selectorKeys = this.selector.selectedKeys().iterator();
                while (selectorKeys.hasNext()) {
                    //这里找到当前的选择键
                    SelectionKey key = (SelectionKey) selectorKeys.next();
                    //然后将它从返回键队列中删除
                    selectorKeys.remove();
                    if (!key.isValid()) { // 选择键无效
                        continue;
                    }
                    if (key.isAcceptable()) {
                        //如果遇到请求那么就响应
                        this.accept(key);
                    } else if (key.isReadable()) {
                        //读取客户端的数据
                        this.read(key);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void accept(SelectionKey selectionKey) {
        ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
        try {
            SocketChannel client = ssc.accept();
            client.configureBlocking(false);
            client.register(this.selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(SelectionKey key) {
        try {
            SocketChannel client = (SocketChannel) key.channel();
            int count = client.read(this.bb);
            if (count == -1) {
                //取消这个通道的注册
                key.channel().close();
                key.cancel();
                return;
            }
            // 复位
            this.bb.flip();
            // 创建一个缓冲区长度的数组
            byte[] buffer = new byte[this.bb.remaining()];
            // 将buffer的数据读入字节数组中
            this.bb.get(buffer);
            String s = new String(buffer, "utf-8").trim();
            System.out.println("Server receive:" + s);
            this.bb.flip();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new Server(8099)).start();
    }
}
