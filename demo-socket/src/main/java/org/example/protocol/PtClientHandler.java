package org.example.protocol;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 发送数据，并且接收数据
 */
@Slf4j
public class PtClientHandler extends SimpleChannelInboundHandler<MsgProtocol> {

    private final AtomicInteger count = new AtomicInteger(1);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MsgProtocol msgProtocol) throws Exception {
        Channel channel = channelHandlerContext.channel();
        String content = new String(msgProtocol.getContent());
        log.info("当前channel:{},第{}次，开始读取数据,长度为{},结果为:{}",
                channel, count.getAndIncrement(), msgProtocol.getLength(), content);
    }
}
