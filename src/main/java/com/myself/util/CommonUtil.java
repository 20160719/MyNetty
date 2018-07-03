package com.myself.util;

import java.net.SocketAddress;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author zhanghong
 *
 */
public final class CommonUtil {

	public static String getRemoteAddress(ChannelHandlerContext ctx) {
		return getSocketAddress(ctx, false).toString();
	}

	public static String getLocalAddress(ChannelHandlerContext ctx) {
		return getSocketAddress(ctx, true).toString();
	}

	private static SocketAddress getSocketAddress(ChannelHandlerContext ctx, boolean isLocal) {
		if (isLocal) {
			return ctx.channel().localAddress();
		} else {
			return ctx.channel().remoteAddress();
		}
	}

}
