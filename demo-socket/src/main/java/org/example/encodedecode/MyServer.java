package org.example.encodedecode;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * 定义自己的编码器和解码器，从而看一看是如何运行的，同时也知道了编码器解码器都是handler的一种
 */
@Slf4j
public class MyServer {

    public static void main(String[] args) throws Exception {
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup(8);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new MyServerInitializer());
            log.info("netty服务器启动");
            ChannelFuture channelFuture = serverBootstrap.bind(8000).sync();
            log.info("netty服务器启动,bind");
            //监听关闭事件
            channelFuture.channel().closeFuture().sync();
            log.info("netty服务器启动2");
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
