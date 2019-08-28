package seu.list.client.bz;

import java.util.HashMap;
import java.util.Map;

import seu.list.client.view.ClientMainFrm;

public class ClientMainFrmMgr {
	private static Map<String, ClientMainFrm> ClientMainFrmPool = new HashMap<String, ClientMainFrm>();

	public static ClientMainFrm get(String qqNo) {
		return ClientMainFrmPool.get(qqNo);
	}

	public static void add(String qqNo, ClientMainFrm mainFrm) {
		ClientMainFrmPool.put(qqNo, mainFrm);
	}

	public static Map<String, ClientMainFrm> getPool() {
		return ClientMainFrmPool;
	}

	public static ClientMainFrm remove(String ownerNo) {
		return 	ClientMainFrmPool.remove(ownerNo);	
	}
}
