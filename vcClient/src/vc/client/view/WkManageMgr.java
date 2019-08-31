package vc.client.view;

import java.util.HashMap;
import java.util.Map;

import vc.client.view.WkManage;

public class WkManageMgr {

	private static Map<String, WkManage> WkManagePool = new HashMap<String, WkManage>();

	public static WkManage get(String userID) {
		return WkManagePool.get(userID);
	}

	public static void add(String userID, WkManage mainFrm) {
		WkManagePool.put(userID, mainFrm);
	}

	public static Map<String, WkManage> getPool() {
		return WkManagePool;
	}

	public static WkManage remove(String userID) {
		return 	WkManagePool.remove(userID);	
	}
}
