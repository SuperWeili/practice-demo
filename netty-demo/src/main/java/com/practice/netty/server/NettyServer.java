package com.practice.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;

/**
 * @author LiWei
 * @version 1.0
 * @date 2021/12/24 10:06
 **/
public class NettyServer {
    public static void main(String[] args) {

        /*
         * 新建两个线程组，boos线程组监听op_accept事件
         * worker线程组默认启动cpu核数*2
         * 监听客户端连接的op_read和op_write事件，处理i/o事件
         */
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // ServerBootstrap为netty服务启动辅助类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup);
            // 设置tcp通道为NioServerSocketChannel udp为DatagramChannel
            serverBootstrap.channel(NioServerSocketChannel.class);
            //  A：SYN ，客户端发起同步请求。你好呀，听说你开启了监听端口，我想给你传数据，方便建立连接吗，我先发一个序列号 x ？
            //  B：SYN + ACK ，服务端发起同步请求。是的呀，我给你发一个我的序列号 y，对了，你的下一个序列号是 x +1 吗？
            //  SO_BACKLOG 配置就是控制 A + B 队列总长度的参数，如果这两个队列都满了，那么 Netty 服务将不会再接收新的连接请求了
            serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024)
                    /*
                     * 当有客户端链路注册读写时间事件后，初始化Handler
                     * 并将Handler加入管道中
                     */
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            /*
                             * 向worker线程的管道双向链表中添加处理类ServerHandler
                             * 整个处理流向如下：HandlerContext-channelRead 读数据-->ServerHandler-channelRead
                             * 读取数据进行业务处理，最后将结果返回给客户端-->TailContext-write->HeadContext-write
                             */
                            socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                            // 把接受到的byteBuff数据包转换成string
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new ServerHandler());

                            // 业务逻辑处理handler
                            socketChannel.pipeline().addLast(new LengthFieldPrepender(4, false));
                            socketChannel.pipeline().addLast(new StringEncoder());
                        }
                    });
            // 同步绑定端口
            ChannelFuture sync = serverBootstrap.bind(8080).sync();
            sync.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
