package com.myself.session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;

public final class SessionManager {
	
	private static Map<String, String> userToAddressRela = new ConcurrentHashMap<String, String>();
	
	private static Map<String, Channel> addressToChannelRela = new ConcurrentHashMap<String, Channel>();

}
