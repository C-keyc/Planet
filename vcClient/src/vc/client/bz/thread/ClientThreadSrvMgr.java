package vc.client.bz.thread;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;


//建立客户端的线程表，每个登陆用户有自己的线程，根据id来区分

public class ClientThreadSrvMgr {

	private static Map<String, ClientThreadSrv> clientThreadPool = new LinkedHashMap<String, ClientThreadSrv>();

	public static void add(String userID, ClientThreadSrv clientThreadSrv) {
		clientThreadPool.put(userID, clientThreadSrv);		
	}

	public static ClientThreadSrv remove(String userID) {
		return clientThreadPool.remove(userID);		
	}
	public static ClientThreadSrv get(String userID) throws UnknownHostException, IOException {
		ClientThreadSrv cts = clientThreadPool.get(userID);
		if (cts == null) cts = new ClientThreadSrv(userID);
		return cts;		
	}
	public static Map<String, ClientThreadSrv> getPool(){
		return clientThreadPool;
	}
}
