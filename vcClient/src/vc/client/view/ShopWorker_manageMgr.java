package vc.client.view;

import java.util.HashMap;
import java.util.Map;

import vc.client.view.ShopWorker_manageFrm;

public class ShopWorker_manageMgr {

	private static Map<String, ShopWorker_manageFrm> WkManagePool = new HashMap<String, ShopWorker_manageFrm>();

	public static ShopWorker_manageFrm get(String userID) {
		return WkManagePool.get(userID);
	}

	public static void add(String userID, ShopWorker_manageFrm mainFrm) {
		if (WkManagePool.get(userID)!=null) {
			
			System.out.println("已经存在一个窗口");
			WkManagePool.remove(userID);
		}
		WkManagePool.put(userID, mainFrm);
	}

	public static Map<String, ShopWorker_manageFrm> getPool() {
		return WkManagePool;
	}

	public static ShopWorker_manageFrm remove(String userID) {
		return 	WkManagePool.remove(userID);	
	}
}
