package vc.client.view.library;

import java.util.HashMap;
import java.util.Map;

public class LibraryReaderReservationMgr {
	private static Map<String, LibraryReader_reservationFrm> WkManagePool = new HashMap<String, LibraryReader_reservationFrm>();

	public static LibraryReader_reservationFrm get(String userID) {
		return WkManagePool.get(userID);
	}

	public static void add(String userID, LibraryReader_reservationFrm mainFrm) {
		WkManagePool.put(userID, mainFrm);
	}

	public static Map<String,LibraryReader_reservationFrm> getPool() {
		return WkManagePool;
	}

	public static LibraryReader_reservationFrm remove(String userID) {
		return 	WkManagePool.remove(userID);	
	}
}
