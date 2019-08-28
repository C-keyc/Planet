package seu.list.client.bz.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import seu.list.client.bz.ClientMainFrmMgr;
import seu.list.client.view.ChatFrm;
import seu.list.client.view.ChatFrmMgr;
import seu.list.client.view.ClientMainFrm;
import seu.list.common.IConstant;
import seu.list.common.Message;
import seu.list.common.MessageType;
import seu.list.common.QQLogger;
import seu.list.common.User;
import seu.list.common.UserStatus;

/**
 * 接受消息处理：根据服务器发送的消息包更新当前GUI
 * @author  Aodong Shen
 */
public class ClientThreadSrv extends Thread {

	private static final String SERVER_ADDRESS = IConstant.SERVER_ADDRESS;
	private static final int SERVER_PORT = IConstant.SERVER_PORT;
	/**
	 * @uml.property  name="socket"
	 */
	private Socket socket = null;
	private boolean isOffline;
	/**
	 * @uml.property  name="owner"
	 * @uml.associationEnd  
	 */
	private User owner;
	private String ownerNo;

	public ClientThreadSrv(String qqNo) throws UnknownHostException, IOException {
		
			this.setSocket(new Socket(SERVER_ADDRESS, SERVER_PORT));
			ClientThreadSrvMgr.add(qqNo, this);
			this.ownerNo = qqNo;
			isOffline = false;
			// this.start(); // 应在登录验证成功后启动		
	}

	@Override
	public void run() {
		while (!isOffline) {
			ObjectInputStream ois = null;
			Message msg = null;
			// 不停地读取从服务器端发来的消息
			try {
				ois = new ObjectInputStream(socket.getInputStream());
				msg = (Message) ois.readObject();
				process(msg);
			} catch (IOException e) {
				isOffline = true;
				ClientThreadSrvMgr.remove(this.ownerNo);
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				
			}
		}		
	}

	private void process(Message msg) throws Exception {
		String msgType = msg.getType();
		User sender = msg.getSender();
		User receiver = msg.getReceiver();
		if (msgType.equals(MessageType.DAT_ALL_FRIENDS)) {

			List<User> frnds = msg.getUserData();

			// 修改相应的好友列表
			ClientMainFrm qqMainFrm = ClientMainFrmMgr.get(receiver.getQqNo());
			// 更新好友列表
			qqMainFrm.setFriends(frnds);

		} else if (msgType.equals(MessageType.DAT_TEXT)) {// 聊天的内容的
			String tipStr = sender.getQqNo() + "-->" + receiver.getQqNo()
					+ "::" + msg.getContent();
			QQLogger.clientLogger().info(tipStr);
			// 把从服务器获得的消息显示到聊天界面
			String key = receiver.getQqNo() + ChatFrm.NAME_SPLITTER
					+ sender.getQqNo();
			ChatFrm cf = ChatFrmMgr.getInstance().get(key);
			cf.setOwner(receiver);
			cf.setFriend(sender);
			if (!cf.isVisible())
				cf.setVisible(true);
			cf.showMessage(msg);

		} else if (msgType.equals(MessageType.DAT_ACTION)) {// 抖动
			String tipStr = sender.getQqNo() + "-->" + receiver.getQqNo()
					+ "::" + msg.getContent();
			QQLogger.clientLogger().info(tipStr);
			// 把从服务器获得的消息显示到聊天界面
			String key = receiver.getQqNo() + ChatFrm.NAME_SPLITTER
					+ sender.getQqNo();
			ChatFrm cf = ChatFrmMgr.getInstance().get(key);
			cf.setOwner(receiver);
			cf.setFriend(sender);
			if (!cf.isVisible())
				cf.setVisible(true);
			cf.doShake();

		} else if (msgType.equals(MessageType.DAT_ONLINE_FRIENDS)) {

			String tipStr = receiver.getQqNo() + "好友有:" + msg.getContent();
			QQLogger.clientLogger().info(tipStr);
			// 修改相应的好友列表
			ClientMainFrm qqMainFrm = ClientMainFrmMgr.get(receiver.getQqNo());
			// 更新在线好友
			if (qqMainFrm != null) {
				qqMainFrm.updateFriend(msg);
			}
		} else if (msgType.equals(MessageType.DAT_LOGOUT)) {
			
			if (sender.getQqNo().equals(this.owner.getQqNo())) {// 强制离线
				isOffline = true;
				this.owner.setStatus(UserStatus.OFFLINE);
				//
				ClientMainFrm cmf = ClientMainFrmMgr.get(receiver.getQqNo());
				if (cmf != null) {
					cmf.updateFriend(msg);
				}
				// 从管理池中移除
				ClientThreadSrvMgr.remove(this.owner.getQqNo());
				// 释放Socket资源
				socket.close();
				
			} else {// 好友下线
				// 修改相应的好友列表
				ClientMainFrm cmf = ClientMainFrmMgr.get(receiver.getQqNo());
				// 更新在线好友
				if (cmf != null) {
					cmf.updateFriend(msg);
				}
			}
		} else if (msgType.equals(MessageType.DAT_LOGIN)) {
			// 修改相应的好友列表
			ClientMainFrm cmf = ClientMainFrmMgr.get(receiver.getQqNo());
			// 更新在线好友
			if (cmf != null)
				cmf.updateFriend(msg);
		}else if (msgType.equals(MessageType.DAT_ADD_FRIEND)) { // 添加好友
			ClientMainFrm cmf = ClientMainFrmMgr.get(receiver.getQqNo());
			// 更新在线好友
			if (cmf != null)
				cmf.addFriend(msg);
		}else if (msgType.equals(MessageType.DAT_DEL_FRIEND)) { // 删除好友
			ClientMainFrm cmf = ClientMainFrmMgr.get(receiver.getQqNo());
			// 更新在线好友
			if (cmf != null)
				cmf.delFriend(msg);
		}  else {
			throw new Exception("未知的消息类型！");
		}

	}

	/**
	 * @param socket
	 * @uml.property  name="socket"
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * @return
	 * @uml.property  name="socket"
	 */
	public Socket getSocket() {
		return socket;
	}

	public OutputStream getOutputStream() throws IOException {
		return socket.getOutputStream();
	}

	public InputStream getInputStream() throws IOException {
		return socket.getInputStream();
	}

	/**
	 * @param u
	 * @uml.property  name="owner"
	 */
	public void setOwner(User u) {
		this.owner = u;
	}

	public void dispose() throws IOException {
		isOffline = true;
		this.socket.close();		
	}
}
