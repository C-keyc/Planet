package vc.client.view.library;

import java.util.HashMap;
import java.util.Map;

public class LibraryWorkerAddMgr {
	private static Map<String, LibraryWorker_addFrm> WkManagePool = new HashMap<String, LibraryWorker_addFrm>();

	public static LibraryWorker_addFrm get(String userID) {
		return WkManagePool.get(userID);
	}

	
	public static void add(String userID, LibraryWorker_addFrm mainFrm) {
		WkManagePool.put(userID, mainFrm);
	}

	public static Map<String, LibraryWorker_addFrm> getPool() {
		return WkManagePool;
	}

	public static LibraryWorker_addFrm remove(String userID) {
		return 	WkManagePool.remove(userID);	
	}

}
