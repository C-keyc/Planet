package seu.list.client.bz.thread;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClientThreadSrvMgr {

	private static Map<String, ClientThreadSrv> clientThreadPool = new LinkedHashMap<String, ClientThreadSrv>();

	public static void add(String qqNo, ClientThreadSrv clientThreadSrv) {
		clientThreadPool.put(qqNo, clientThreadSrv);		
	}

	public static ClientThreadSrv remove(String qqNo) {
		return clientThreadPool.remove(qqNo);		
	}
	public static ClientThreadSrv get(String qqNo) throws UnknownHostException, IOException {
		ClientThreadSrv cts = clientThreadPool.get(qqNo);
		if (cts == null) cts = new ClientThreadSrv(qqNo);
		return cts;		
	}
	public static Map<String, ClientThreadSrv> getPool(){
		return clientThreadPool;
	}
}
