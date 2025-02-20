package org.example.encodedecode;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        //添加解码器和编码器
        pipeline.addLast("decoder", new MyByteToLongDecoder());
        pipeline.addLast("encoder", new MyLongToByteEncoder());
        pipeline.addLast(new MyClientHandler());
    }
}
