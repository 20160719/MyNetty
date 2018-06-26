package com.myself.server;

import org.slf4j.Logger;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public abstract class AbstractNettyServer {
	
//	private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

	protected EventLoopGroup mainGroup;
	protected EventLoopGroup workGroup;
	protected ServerBootstrap serverBootstrap;
	protected ChannelFuture future;
	protected Channel channel;
	protected int mainThreads;
	protected int workThreads;
	protected int port;

	public AbstractNettyServer(int mainThreads, int workThreads, int port) {
		this.mainThreads = mainThreads;
		this.workThreads = workThreads;
		this.port = port;
	}

	private void init() {
		this.mainGroup = new NioEventLoopGroup(this.mainThreads);
		this.workGroup = new NioEventLoopGroup(this.workThreads);
		this.serverBootstrap = new ServerBootstrap();
		this.serverBootstrap.group(this.mainGroup, this.workGroup).channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel arg0) throws Exception {
						initChannel(arg0);
//						ChannelPipeline pip = arg0.pipeline();
						// pip.addLast(new IdleStateHandler(5, 0, 0, TimeUnit.SECONDS));
//						pip.addLast(new MyDelimiterBasedFrameDecoder(100,
//								Unpooled.copiedBuffer(CommonUtils.STRING_SPLIT.getBytes())));
//						// pip.addLast(new MyDecoder());
//						pip.addLast(new StringDecoder());
//						pip.addLast(new StringEncoder());
//						pip.addLast(new NettyServerHandler());
					}
				});
		getLogger().info("服务器初始化完成...");
	}

	public void bind() throws Exception {
		init();
		try {
			this.future = this.serverBootstrap.bind(this.port).sync();
			if (this.future.isSuccess()) {
				getLogger().info("服务器已启动...");
			}
			this.channel = this.future.sync().channel();
			this.channel.closeFuture().sync();
		} catch (Exception e) {
			getLogger().error(e.getMessage(), e);
		} finally {
			this.mainGroup.shutdownGracefully();
			this.workGroup.shutdownGracefully();
		}
	}
	
	protected void initChannel(SocketChannel arg0) {
		
	}
	
	protected Logger getLogger() {
		return null;
	}

}



