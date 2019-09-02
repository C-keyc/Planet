package vc.client.view.message;

import java.util.HashMap;
import java.util.Map;

import vc.client.view.message.MessageRoll_mainFrm;

public class MessageRoll_mainMgr {

	private static Map<String, MessageRoll_mainFrm> MessageRoll_mainPool = new HashMap<String, MessageRoll_mainFrm>();

	public static MessageRoll_mainFrm get(String userID) {
		return MessageRoll_mainPool.get(userID);
	}

	public static void add(String userID, MessageRoll_mainFrm mainFrm) {
		MessageRoll_mainPool.put(userID, mainFrm);
	}

	public static Map<String, MessageRoll_mainFrm> getPool() {
		return MessageRoll_mainPool;
	}

	public static MessageRoll_mainFrm remove(String userID) {
		return 	MessageRoll_mainPool.remove(userID);	
	}
}