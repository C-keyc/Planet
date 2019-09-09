package vc.client.view.choosecourse;

import java.util.HashMap;
import java.util.Map;

public class courseTeacherMgr {
	private static Map<String, courseTeacher> courseTeacherPool = new HashMap<String, courseTeacher>();

	public static courseTeacher get(String userID) {
		return courseTeacherPool.get(userID);
	}

	public static void add(String userID, courseTeacher mainFrm) {
		courseTeacherPool.put(userID, mainFrm);
	}

	public static Map<String, courseTeacher> getPool() {
		return courseTeacherPool;
	}

	public static courseTeacher remove(String userID) {
		return 	courseTeacherPool.remove(userID);	
	}
}
