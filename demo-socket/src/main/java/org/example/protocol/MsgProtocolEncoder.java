package org.example.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;


public class MsgProtocolEncoder extends MessageToByteEncoder<MsgProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MsgProtocol msgProtocol, ByteBuf byteBuf) throws Exception {
        int length = msgProtocol.getLength();
        byteBuf.writeInt(length);
        byteBuf.writeBytes(msgProtocol.getContent());
    }
}
