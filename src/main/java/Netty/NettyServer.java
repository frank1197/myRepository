package Netty;/**
 * Netty服务端
 *
 * @author yanfeng3
 * @create 2019-05-08 16:14
 **/

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @Title: interviewTest
 * @Package Netty
 * @Description: todo
 * @author yanfeng3
 * @date 2019/5/8 16:14
 * @version V1.0
 */
public class NettyServer {

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boos = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
            .group(boos, worker)
            .channel(NioServerSocketChannel.class)
            .childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) {
                    ch.pipeline().addLast(new StringDecoder());
                    ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                        @Override
                        protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                            System.out.println(msg);
                        }
                    });
                }
            })
            .bind(8000);
    }
}
