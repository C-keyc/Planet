package vc.server.bz;

import java.util.LinkedHashMap;
import java.util.Map;

import vc.server.bz.ServerClientThread;

public class ServerClientThreadMgr {
	private  static  Map<String, ServerClientThread>  clientThreadPool = new LinkedHashMap<String, ServerClientThread>();

	public synchronized static void add(String userID, ServerClientThread clientThreadSrv) {
		clientThreadPool.put(userID, clientThreadSrv);		
	}

	public synchronized static ServerClientThread remove(String userID) {
		return clientThreadPool.remove(userID);		
	}
	public synchronized static ServerClientThread get(String userID) {
		ServerClientThread cts = clientThreadPool.get(userID);		
		return cts;		
	}
	public synchronized static Map<String, ServerClientThread> getPool(){
		return clientThreadPool;
	}
}
