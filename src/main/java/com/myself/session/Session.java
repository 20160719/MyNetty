package com.myself.session;

import io.netty.channel.Channel;

/**
 * @author zhanghong
 *
 */
public class Session {
	
	private String account;
	
	private Channel channel;
	
	public Session() {
	}

	public Session(String account, Channel channel) {
		this.account = account;
		this.channel = channel;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
}
