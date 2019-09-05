package vc.client.view.library;

import java.util.HashMap;
import java.util.Map;

public class LibraryWorkerMgr {

	private static Map<String, LibraryWorker_manageFrm> WkManagePool = new HashMap<String, LibraryWorker_manageFrm>();

	public static LibraryWorker_manageFrm get(String userID) {
		return WkManagePool.get(userID);
	}

	public static void add(String userID, LibraryWorker_manageFrm mainFrm) {
		WkManagePool.put(userID, mainFrm);
	}

	public static Map<String, LibraryWorker_manageFrm> getPool() {
		return WkManagePool;
	}

	public static LibraryWorker_manageFrm remove(String userID) {
		return 	WkManagePool.remove(userID);	
	}
}
