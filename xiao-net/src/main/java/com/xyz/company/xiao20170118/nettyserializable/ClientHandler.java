package com.xyz.company.xiao20170118.nettyserializable;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * 客户端处理器
 *
 * @author xiao
 * @create 2017-01-18 19:25
 **/
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
            Response response = (Response) msg;
            System.out.println("服务器的响应数据："+response);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
