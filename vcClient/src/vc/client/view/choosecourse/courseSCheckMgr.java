package vc.client.view.choosecourse;

import java.util.HashMap;
import java.util.Map;

public class courseSCheckMgr {
	private static Map<String, courseSCheck> courseSCheckPool = new HashMap<String, courseSCheck>();

	public static courseSCheck get(String userID) {
		return courseSCheckPool.get(userID);
	}

	
	public static void add(String userID, courseSCheck mainFrm) {
		courseSCheckPool.put(userID, mainFrm);
	}

	public static Map<String, courseSCheck> getPool() {
		return courseSCheckPool;
	}

	public static courseSCheck remove(String userID) {
		return 	courseSCheckPool.remove(userID);	
	}
	
}
