package com.practice.netty.client;

import com.alibaba.fastjson.JSONObject;

import com.practice.netty.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.Promise;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiWei
 * @date 2021/12/24 17:07
 * @version 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ClientHandler extends ChannelInboundHandlerAdapter {
    private Promise<Response> promise;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 读取服务器返回的响应结果，并转换成response对象
        // 由于经过了stringdeconder解码器-》string类型
        Response response = JSONObject.parseObject(msg.toString(), Response.class);
        promise.setSuccess(response);
    }
}
