package com.xyz.company.xiao20170118.nettyserializable;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * 服务端处理器
 *
 * @author xiao
 * @create 2017-01-18 19:24
 **/
public class ServerHandler extends ChannelHandlerAdapter {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            Request req = (Request) msg;
            System.out.println("客户端发来的数据"+req);

            Response response = new Response();
            response.setStatus(200);
            response.setDesc("成功响应");
            /**
             * 向客户端写数据,写了之后就关闭服务器端
             * 另外一个点需要注意的是ChannelHandlerContext.write()(和writeAndFlush())方法会返回一个ChannelFuture对象，
             * 一个ChannelFuture代表了一个还没有发生的I/O操作。这意味着任何一个请求操作都不会马上被执行，
             * 因为在Netty里所有的操作都是异步的。举个例子下面的代码中在消息被发送之前可能会先关闭连接。
             */
            ctx.channel().writeAndFlush(response);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
