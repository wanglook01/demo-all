package org.example.nianbaochaibao;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 继承了解码器，因为我一开始不知道是使用byte[]接收还是ByteBuf接收
 * 本质上这个也是一个InboundHandler
 * 后续的更改，没有使用编解码器的接口了，编解码器使用了byteArrayEncoder，然后直接转化为byte[]，我们直接处理这种类型即可
 */
@Slf4j
public class NcServerHandler extends SimpleChannelInboundHandler<byte[]> {

    private final AtomicInteger count = new AtomicInteger(1);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, byte[] bytes) throws Exception {
        //接收数据
        Channel channel = channelHandlerContext.channel();
        String content = new String(bytes);
        log.info("当前channel:{},第{}次，开始读取数据,长度为{},结果为:{}", channel, count.getAndIncrement(), bytes.length, content);
        //返回数据
        channelHandlerContext.writeAndFlush("ok接收成功啦！！！".getBytes());
    }

}
