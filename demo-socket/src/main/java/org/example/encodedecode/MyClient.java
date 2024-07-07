package org.example.encodedecode;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyClient {

    public static void main(String[] args) throws Exception {
        EventLoopGroup worker = new NioEventLoopGroup(2);
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker)
                    .channel(NioSocketChannel.class)
                    .handler(new MyClientInitializer());
            System.out.println("netty客户端启动");
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8000).sync();
            Channel channel = channelFuture.channel();
            //
            System.out.println("netty客户端获取连接channel:" + channel);
            //方式1，监听输入事件
            /*Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                channel.writeAndFlush(Long.valueOf(msg));
            }*/
            //方式2，直接发送8个字节
            //channel.writeAndFlush(Unpooled.copiedBuffer("abcdabcd".getBytes())); //7017280452178371428
            //方式3，直接发送12+12个字节
            channel.writeAndFlush(Unpooled.copiedBuffer("abcdabcdabcd".getBytes())).sync();
            System.out.println("第一阶段写入成功");
            channel.writeAndFlush(Unpooled.copiedBuffer("abcdabcdabcd".getBytes())).sync();;
            System.out.println("第二阶段写入成功");
            Thread.sleep(1000);
            log.info("----");
        } finally {
            worker.shutdownGracefully();
        }
    }
}
