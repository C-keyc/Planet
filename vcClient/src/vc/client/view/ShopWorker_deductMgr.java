package vc.client.view;

import java.util.HashMap;
import java.util.Map;

public class ShopWorker_deductMgr {

	private static Map<String, ShopWorker_deductFrm> WkDeductPool = new HashMap<String, ShopWorker_deductFrm>();

	public static ShopWorker_deductFrm get(String userID) {
		return WkDeductPool.get(userID);
	}

	
	public static void add(String userID, ShopWorker_deductFrm mainFrm) {
		if (WkDeductPool.get(userID)!=null) {
			
			System.out.println("已经存在一个窗口");
			WkDeductPool.remove(userID);
		}
		WkDeductPool.put(userID, mainFrm);
	}

	public static Map<String, ShopWorker_deductFrm> getPool() {
		return WkDeductPool;
	}

	public static ShopWorker_deductFrm remove(String userID) {
		return 	WkDeductPool.remove(userID);	
	}
}
