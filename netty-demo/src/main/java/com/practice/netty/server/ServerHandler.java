package com.practice.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @author LiWei
 * @date 2021/12/24 10:28
 * @version 1.0
 * sharable 表示此handler对所有的Channel共享，得注意多线程并发
 **/
@ChannelHandler.Sharable
public class ServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取客户端发送的数据
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf){
            // ByteBuf的toString()方法将二进制转换字符串，utf-8
            System.out.println(((ByteBuf) msg).toString(Charset.defaultCharset()));
        }
        ctx.channel().writeAndFlush("msg has received");
    }
}
