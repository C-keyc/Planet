package seu.list.common;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;

public interface IObjectPoolMgr<T> {
	
	void put(String key, T object);
	T get(String key) throws UnknownHostException, IOException;
	T remove(String key);
	Map<String,T> getPool();
	
}
