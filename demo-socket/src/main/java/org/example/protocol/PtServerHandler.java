package org.example.protocol;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用自定义协议处理
 */
@Slf4j
public class PtServerHandler extends SimpleChannelInboundHandler<MsgProtocol> {

    private final AtomicInteger count = new AtomicInteger(1);


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MsgProtocol msgProtocol) throws Exception {
        //接收数据
        Channel channel = channelHandlerContext.channel();
        String content = new String(msgProtocol.getContent());
        log.info("当前channel:{},第{}次，开始读取数据,长度为{},结果为:{}",
                channel, count.getAndIncrement(), msgProtocol.getLength(), content);
        //返回数据
        byte[] res = "执行成功!".getBytes();
        channelHandlerContext.writeAndFlush(new MsgProtocol(res.length, res));
    }

}
