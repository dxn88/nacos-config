package com.dxn.mynett;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author Dai.xn
 * @since 2021/3/1
 */
public class MyNetty {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();

        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                /**
                 * 半连接
                 */
                .option(ChannelOption.SO_BACKLOG, 65535)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new NettyServerHandler());
                    }
                });
        System.out.println("开始启动服务。。。");

        ChannelFuture bindFuture = bootstrap.bind(new InetSocketAddress(6666)).sync();

        bindFuture.channel().closeFuture().addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                System.out.println("closeFuture");
            }
        }).sync();

    }

    public static class NettyServerHandler extends ChannelInboundHandlerAdapter {
        public NettyServerHandler() {
            super();
            System.out.println("NettyServerHandler.NettyServerHandler");
        }

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("NettyServerHandler.channelRegistered");
            super.channelRegistered(ctx);
        }

        @Override
        public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("NettyServerHandler.channelUnregistered");
            super.channelUnregistered(ctx);
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("NettyServerHandler.channelActive");
            super.channelActive(ctx);
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("NettyServerHandler.channelInactive");
            super.channelInactive(ctx);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("NettyServerHandler.channelRead");
            super.channelRead(ctx, msg);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            System.out.println("NettyServerHandler.channelReadComplete");
            super.channelReadComplete(ctx);
        }

        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            System.out.println("NettyServerHandler.userEventTriggered");
            super.userEventTriggered(ctx, evt);
        }

        @Override
        public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
            System.out.println("NettyServerHandler.channelWritabilityChanged");
            super.channelWritabilityChanged(ctx);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            System.out.println("NettyServerHandler.exceptionCaught");
            super.exceptionCaught(ctx, cause);
        }

        @Override
        protected void ensureNotSharable() {
            System.out.println("NettyServerHandler.ensureNotSharable");
            super.ensureNotSharable();
        }

        @Override
        public boolean isSharable() {
            System.out.println("NettyServerHandler.isSharable");
            return super.isSharable();
        }

        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            System.out.println("NettyServerHandler.handlerAdded");
            super.handlerAdded(ctx);
        }

        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
            System.out.println("NettyServerHandler.handlerRemoved");
            super.handlerRemoved(ctx);
        }

    }
}