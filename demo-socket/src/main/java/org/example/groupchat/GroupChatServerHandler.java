package org.example.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    //定义一个channel组，管理所有的channel,所有的客户共享的
    //全局的事件执行器，是有一个单例
    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    //表示建立连接，一旦连接，第一个被执行，给其他客户端看的
    //将当前channel加入到channelGroup,将该客户上线信息推送给其他客户端
    //本身就会遍历，并且发送消息,用这个比较方便
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        channels.writeAndFlush("大家好，我是客户端:" + ctx.channel().remoteAddress() + ",我加入聊天了\n");
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        channels.writeAndFlush("大家好，我是客户端:" + ctx.channel().remoteAddress() + ",我离开聊天了\n");
        //channels.remove(ctx.channel());不需要手动调用，因为会自动触发的
    }

    //表示channel处于活动状态，只给客户端看的
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("客户端:" + ctx.channel().remoteAddress() + ",上线了~~~\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        System.out.println("客户端:" + ctx.channel().remoteAddress() + ",下线了！！！\n");
    }

    //核心处理方法
    @Override
    protected void channelRead0(ChannelHandlerContext context, String s) throws Exception {
        //服务器端需要接收到客户端的消息并进行转发
        Channel channel = context.channel();
        //根据不同的情况回送不同的消息，主要是自己发的消息，不用再发回自己了
        channels.forEach(ch -> {
            if (channel != ch) {
                //直接转发
                ch.writeAndFlush("客户:" + channel.remoteAddress() + ",发送消息，内容是:" + s);
            } else {
                ch.writeAndFlush("发送成功!!!" + s);
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.channel().close();
    }
}
