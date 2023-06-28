package com.practice.netty.client;

import com.practice.netty.Response;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Promise;

import java.nio.charset.Charset;

/**
 * @author LiWei
 * @version 1.0
 * netty 客户端
 * @date 2021/12/24 16:53
 **/
public class NettyClient {
    public static EventLoopGroup loopGroup;
    public static Bootstrap bootstrap;

    static {
        // 客户端启动辅助类
        bootstrap = new Bootstrap();

        // 开启一个线程组
        loopGroup = new NioEventLoopGroup();

        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(loopGroup);
        // 设置内存分配器
        bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
    }

    public static void main(String[] args) {
        try {
            // 新建一个promise对象
            Promise<Response> promise = new DefaultPromise<>(loopGroup.next());
            // 业务handler
            ClientHandler clientHandler = new ClientHandler();
            // 把promise对象赋值给handler 用于获取返回服务端的响应结果
            clientHandler.setPromise(promise);
            // 把handler对象加到服务管道中
            bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                    // 把接受到的byteBuff数据包转换成string
                    ch.pipeline().addLast(new StringDecoder());
                    // 业务逻辑处理handler
                    ch.pipeline().addLast(clientHandler);
                    ch.pipeline().addLast(new LengthFieldPrepender(4, false));
                    ch.pipeline().addLast(new StringEncoder(Charset.defaultCharset()));
                }
            });
            // 连接服务器
            ChannelFuture sync = bootstrap.connect("127.0.0.1", 8080).sync();
            // todo pdf28 未完成


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
