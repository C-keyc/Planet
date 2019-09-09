package vc.client.view.choosecourse;

import java.util.HashMap;
import java.util.Map;

public class courseTCheckMgr {
	private static Map<String, courseTCheck> courseTCheckPool = new HashMap<String, courseTCheck>();

	public static courseTCheck get(String userID) {
		return courseTCheckPool.get(userID);
	}

	public static void add(String userID, courseTCheck mainFrm) {
		courseTCheckPool.put(userID, mainFrm);
	}

	
	public static Map<String, courseTCheck> getPool() {
		return courseTCheckPool;
	}

	public static courseTCheck remove(String userID) {
		return 	courseTCheckPool.remove(userID);	
	}
}
