package vc.list.common;

import java.util.HashMap;
import java.util.Map;


public class GdlistMgr {

	private static Map<String, Goods> GdlistPool = new HashMap<String, Goods>();

	
	public static Goods get(String userID) {
		return GdlistPool.get(userID);
	}

	public static void add(String userID, Goods mainFrm) {
		GdlistPool.put(userID, mainFrm);
	}

	public static Map<String, Goods> getPool() {
		return GdlistPool;
	}

	public static Goods remove(String userID) {
		return 	GdlistPool.remove(userID);	
	}	
	
}
