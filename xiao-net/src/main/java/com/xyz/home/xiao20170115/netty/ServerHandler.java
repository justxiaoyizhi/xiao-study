package com.xyz.home.xiao20170115.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by Xiao on 2017/1/15.
 * 需要继承ChannelHandlerAdapter类而不是你自己去实现接口方法。
 */
public class ServerHandler extends ChannelHandlerAdapter {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            // do something msg
            ByteBuf buf = (ByteBuf) msg;
            byte[] data = new byte[buf.readableBytes()];
            buf.readBytes(data);
            String request = new String(data,"utf-8");
            System.out.println("Client say:"+request);
            /**
             * 向客户端写数据,写了之后就关闭服务器端
             * 另外一个点需要注意的是ChannelHandlerContext.write()(和writeAndFlush())方法会返回一个ChannelFuture对象，
             * 一个ChannelFuture代表了一个还没有发生的I/O操作。这意味着任何一个请求操作都不会马上被执行，
             * 因为在Netty里所有的操作都是异步的。举个例子下面的代码中在消息被发送之前可能会先关闭连接。
             */
            ctx.channel().writeAndFlush(Unpooled.copiedBuffer("Hello Client".getBytes("utf-8")))
                    .addListener(ChannelFutureListener.CLOSE);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
