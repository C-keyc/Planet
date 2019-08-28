package seu.list.client.bz.thread;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import seu.list.common.IObjectPoolMgr;

public class FileClientThreadSrvMgr implements IObjectPoolMgr<FileClientThreadSrv> {

	private Map<String, FileClientThreadSrv> pool = new HashMap<String, FileClientThreadSrv>();	
	private static FileClientThreadSrvMgr fctsMgr = new FileClientThreadSrvMgr();
	private FileClientThreadSrvMgr() {
		
	}
	public static FileClientThreadSrvMgr getInstance() {
		return fctsMgr;
	}
	@Override
	public void put(String key, FileClientThreadSrv object) {
		pool.put(key, object);		
	}

	@Override
	public FileClientThreadSrv get(String key) throws UnknownHostException, IOException {
		FileClientThreadSrv fcts = pool.get(key);
		if (fcts == null) {
			fcts = new FileClientThreadSrv(key);			
		}
		return fcts;
	}

	@Override
	public FileClientThreadSrv remove(String key) {
		return pool.remove(key);
	}

	@Override
	public Map<String, FileClientThreadSrv> getPool() {		
		return pool;
	}

	

}
