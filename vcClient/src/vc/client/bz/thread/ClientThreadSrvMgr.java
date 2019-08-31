package vc.client.bz.thread;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;


//�����ͻ��˵��̱߳�ÿ����½�û����Լ����̣߳�����id������

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
