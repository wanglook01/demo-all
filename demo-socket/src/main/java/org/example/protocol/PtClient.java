package org.example.protocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PtClient {

    public static void main(String[] args) throws Exception {
        EventLoopGroup worker = new NioEventLoopGroup(5);
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("encoder", new MsgProtocolEncoder());
                            pipeline.addLast("decoder", new MsgProtocolDecoder());
                            pipeline.addLast("ncClientHandler", new PtClientHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9000).sync();
            Channel channel = channelFuture.channel();
            log.info("NcClient connect success:{}", channel);
            //直接往通道写数据
            for (int i = 0; i < 10; i++) {
                String content = "helloWorld" + i;
                channel.writeAndFlush(new MsgProtocol(content.getBytes().length, content.getBytes()));
                log.info("发送数据成功:{}", content);
            }
            //等待发送完成
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
            }
        } finally {
            worker.shutdownGracefully();
        }
    }
}
