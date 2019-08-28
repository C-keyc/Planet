package seu.list.client.view;

import java.util.LinkedHashMap;
import java.util.Map;

import seu.list.common.IObjectPoolMgr;

/**
 * @author  john
 */
public class ChatFrmMgr implements IObjectPoolMgr<ChatFrm>{

	/**
	 * @uml.property  name="pool"
	 */
	private Map<String, ChatFrm> pool = new LinkedHashMap<String, ChatFrm>();
	/**
	 * @uml.property  name="chatFrmMgr"
	 * @uml.associationEnd  
	 */
	private static ChatFrmMgr chatFrmMgr = new ChatFrmMgr();
	private ChatFrmMgr() {
		
	}
	public static ChatFrmMgr getInstance() {
		return chatFrmMgr;
	}
	@Override
	public void put(String key, ChatFrm value) {
		pool.put(key, value);	
	}

	@Override
	public ChatFrm get(String key) {
		ChatFrm cf = pool.get(key);
		if (cf == null) {
			String[] nos = key.split(ChatFrm.NAME_SPLITTER);
			cf = new ChatFrm(nos[0], nos[1]);
			put(key, cf);
		}
		return cf;
	}

	@Override
	public ChatFrm remove(String key) {
		return pool.remove(key);
	}

	/**
	 * @return
	 * @uml.property  name="pool"
	 */
	@Override
	public Map<String, ChatFrm> getPool() {
		return pool;
	}



}
