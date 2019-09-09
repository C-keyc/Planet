package vc.client.view.choosecourse;

import java.util.HashMap;
import java.util.Map;


public class courseStudentMgr {

	private static Map<String, courseStudent> courseStudentPool = new HashMap<String, courseStudent>();

	public static courseStudent get(String userID) {
		return courseStudentPool.get(userID);
	}

	
	public static void add(String userID, courseStudent mainFrm) {
		courseStudentPool.put(userID, mainFrm);
	}

	public static Map<String, courseStudent> getPool() {
		return courseStudentPool;
	}

	public static courseStudent remove(String userID) {
		return 	courseStudentPool.remove(userID);	
	}
	
}
