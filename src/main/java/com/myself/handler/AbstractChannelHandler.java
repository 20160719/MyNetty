package com.myself.handler;

import org.slf4j.Logger;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public abstract class AbstractChannelHandler<T> extends SimpleChannelInboundHandler<T> {

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent) evt;
			IdleState state = e.state();
			if (IdleState.READER_IDLE == state) {
				handleReaderIdle(ctx);
			} else if (IdleState.WRITER_IDLE == state) {
				handleWriterIdle(ctx);
			} else if (IdleState.ALL_IDLE == state) {
				handleAllIdle(ctx);
			}
		}
	}

	protected void handleReaderIdle(ChannelHandlerContext ctx) {
		// TODO 自动生成的方法存根

	}

	protected void handleWriterIdle(ChannelHandlerContext ctx) {
		// TODO 自动生成的方法存根

	}

	protected void handleAllIdle(ChannelHandlerContext ctx) {
		// TODO 自动生成的方法存根

	}

	protected Logger getLogger() {
		return null;
	}

}
