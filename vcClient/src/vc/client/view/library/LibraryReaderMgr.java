package vc.client.view.library;

import java.util.HashMap;
import java.util.Map;


public class LibraryReaderMgr {
	private static Map<String, LibraryReader_mainFrm> WkManagePool = new HashMap<String, LibraryReader_mainFrm>();

	public static LibraryReader_mainFrm get(String userID) {
		return WkManagePool.get(userID);
	}

	public static void add(String userID, LibraryReader_mainFrm mainFrm) {
		WkManagePool.put(userID, mainFrm);
	}

	public static Map<String, LibraryReader_mainFrm> getPool() {
		return WkManagePool;
	}

	public static LibraryReader_mainFrm remove(String userID) {
		return 	WkManagePool.remove(userID);	
	}

}
