package com.xyz.home.xiao20170115.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by Xiao on 2017/1/15.
 */
public class ClientHandler extends ChannelHandlerAdapter {
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
            System.out.println("Server say:"+request);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
