package vc.client.view.library;

import java.util.HashMap;
import java.util.Map;


public class LibraryReaderMgr {
	private static Map<String, LibraryReader_checkrecordFrm> WkManagePool = new HashMap<String, LibraryReader_checkrecordFrm>();

	public static LibraryReader_checkrecordFrm get(String userID) {
		return WkManagePool.get(userID);
	}

	public static void add(String userID, LibraryReader_checkrecordFrm mainFrm) {
		WkManagePool.put(userID, mainFrm);
	}

	public static Map<String, LibraryReader_checkrecordFrm> getPool() {
		return WkManagePool;
	}

	public static LibraryReader_checkrecordFrm remove(String userID) {
		return 	WkManagePool.remove(userID);	
	}

}
