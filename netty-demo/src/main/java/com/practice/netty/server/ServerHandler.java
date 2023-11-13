package com.practice.netty.server;

import com.alibaba.fastjson.JSONObject;
import com.practice.netty.RequestFuture;
import com.practice.netty.Response;
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
//        if (msg instanceof ByteBuf){
//            // ByteBuf的toString()方法将二进制转换字符串，utf-8
//            System.out.println(((ByteBuf) msg).toString(Charset.defaultCharset()));
//        }
//        ctx.channel().writeAndFlush("msg has received！");
        RequestFuture requestFuture = JSONObject.parseObject(msg.toString(), RequestFuture.class);
        long id = requestFuture.getId();
        System.out.println("请求信息为==="+msg.toString());
        Response response = new Response();
        response.setId(id);
        response.setResult("服务器响应ok");
        // 相应结果返回给客户端
        ctx.channel().writeAndFlush(JSONObject.toJSONString(response));
    }
}
