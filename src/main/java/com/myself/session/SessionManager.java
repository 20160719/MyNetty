package com.myself.session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SessionManager {
	
	private static Map<String, Session> sessionMap = new ConcurrentHashMap<String, Session>();
	
	public static Session put(String key, Session session) {
		Session curSession = sessionMap.get(key);
		if(null != curSession) {
			return null;
		}
		return sessionMap.put(key, session);
	}
	
	public static Session get(String key) {
		return sessionMap.get(key);
	}

	public static Session remove(String key) {
		return sessionMap.remove(key);
	}
	
}
