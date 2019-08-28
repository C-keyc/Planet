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
 * ������Ϣ�������ݷ��������͵���Ϣ�����µ�ǰGUI
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
			// this.start(); // Ӧ�ڵ�¼��֤�ɹ�������		
	}

	@Override
	public void run() {
		while (!isOffline) {
			ObjectInputStream ois = null;
			Message msg = null;
			// ��ͣ�ض�ȡ�ӷ������˷�������Ϣ
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

			// �޸���Ӧ�ĺ����б�
			ClientMainFrm qqMainFrm = ClientMainFrmMgr.get(receiver.getQqNo());
			// ���º����б�
			qqMainFrm.setFriends(frnds);

		} else if (msgType.equals(MessageType.DAT_TEXT)) {// ��������ݵ�
			String tipStr = sender.getQqNo() + "-->" + receiver.getQqNo()
					+ "::" + msg.getContent();
			QQLogger.clientLogger().info(tipStr);
			// �Ѵӷ�������õ���Ϣ��ʾ���������
			String key = receiver.getQqNo() + ChatFrm.NAME_SPLITTER
					+ sender.getQqNo();
			ChatFrm cf = ChatFrmMgr.getInstance().get(key);
			cf.setOwner(receiver);
			cf.setFriend(sender);
			if (!cf.isVisible())
				cf.setVisible(true);
			cf.showMessage(msg);

		} else if (msgType.equals(MessageType.DAT_ACTION)) {// ����
			String tipStr = sender.getQqNo() + "-->" + receiver.getQqNo()
					+ "::" + msg.getContent();
			QQLogger.clientLogger().info(tipStr);
			// �Ѵӷ�������õ���Ϣ��ʾ���������
			String key = receiver.getQqNo() + ChatFrm.NAME_SPLITTER
					+ sender.getQqNo();
			ChatFrm cf = ChatFrmMgr.getInstance().get(key);
			cf.setOwner(receiver);
			cf.setFriend(sender);
			if (!cf.isVisible())
				cf.setVisible(true);
			cf.doShake();

		} else if (msgType.equals(MessageType.DAT_ONLINE_FRIENDS)) {

			String tipStr = receiver.getQqNo() + "������:" + msg.getContent();
			QQLogger.clientLogger().info(tipStr);
			// �޸���Ӧ�ĺ����б�
			ClientMainFrm qqMainFrm = ClientMainFrmMgr.get(receiver.getQqNo());
			// �������ߺ���
			if (qqMainFrm != null) {
				qqMainFrm.updateFriend(msg);
			}
		} else if (msgType.equals(MessageType.DAT_LOGOUT)) {
			
			if (sender.getQqNo().equals(this.owner.getQqNo())) {// ǿ������
				isOffline = true;
				this.owner.setStatus(UserStatus.OFFLINE);
				//
				ClientMainFrm cmf = ClientMainFrmMgr.get(receiver.getQqNo());
				if (cmf != null) {
					cmf.updateFriend(msg);
				}
				// �ӹ�������Ƴ�
				ClientThreadSrvMgr.remove(this.owner.getQqNo());
				// �ͷ�Socket��Դ
				socket.close();
				
			} else {// ��������
				// �޸���Ӧ�ĺ����б�
				ClientMainFrm cmf = ClientMainFrmMgr.get(receiver.getQqNo());
				// �������ߺ���
				if (cmf != null) {
					cmf.updateFriend(msg);
				}
			}
		} else if (msgType.equals(MessageType.DAT_LOGIN)) {
			// �޸���Ӧ�ĺ����б�
			ClientMainFrm cmf = ClientMainFrmMgr.get(receiver.getQqNo());
			// �������ߺ���
			if (cmf != null)
				cmf.updateFriend(msg);
		}else if (msgType.equals(MessageType.DAT_ADD_FRIEND)) { // ��Ӻ���
			ClientMainFrm cmf = ClientMainFrmMgr.get(receiver.getQqNo());
			// �������ߺ���
			if (cmf != null)
				cmf.addFriend(msg);
		}else if (msgType.equals(MessageType.DAT_DEL_FRIEND)) { // ɾ������
			ClientMainFrm cmf = ClientMainFrmMgr.get(receiver.getQqNo());
			// �������ߺ���
			if (cmf != null)
				cmf.delFriend(msg);
		}  else {
			throw new Exception("δ֪����Ϣ���ͣ�");
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
