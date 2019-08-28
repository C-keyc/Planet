package seu.list.client.bz.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import seu.list.client.view.ChatFrm;
import seu.list.client.view.ChatFrmMgr;
import seu.list.common.IConstant;
import seu.list.common.Message;
import seu.list.common.User;

public class FileClientThreadSrv  extends Thread {
	private static final String SERVER_ADDRESS = IConstant.FILE_SERVER_ADDRESS;
	private static final int SERVER_PORT = IConstant.FILE_SERVER_PORT;
	private Socket socket = null;
	private boolean isOffline;
	private User owner;
	private String ownerNo;

	public FileClientThreadSrv(String qqNo) throws UnknownHostException,
			IOException {

		this.setSocket(new Socket(SERVER_ADDRESS, SERVER_PORT));
		FileClientThreadSrvMgr.getInstance().put(qqNo, this);
		this.ownerNo = qqNo;
		isOffline = false;
		// this.start(); // Ӧ�ڵ�¼��֤�ɹ�������
	}

	private void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Socket getSocket() {
		return socket;
	}

	public OutputStream getOutputStream() throws IOException {
		return socket.getOutputStream();
	}

	public InputStream getInputStream() throws IOException {
		return socket.getInputStream();
	}
	public void setOwner(User u) {
		this.owner = u;
	}
	public User getOwner() {
		return this.owner;
	}
	public void dispose() throws IOException {
		isOffline = true;
		this.socket.close();		
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
			} catch(SocketException e) {
				isOffline = true;
				ClientThreadSrvMgr.remove(this.ownerNo);
				e.printStackTrace();
				break;
			}catch (IOException e) {
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
//		String type = msg.getType();
		String cfKey = msg.getReceiver().getQqNo() + ChatFrm.NAME_SPLITTER + msg.getSender().getQqNo();
		ChatFrm cf = ChatFrmMgr.getInstance().get(cfKey);
		cf.setOwner(msg.getReceiver());
		cf.setFriend(msg.getSender());
//		if (type.equals(MessageType.RST_FAILURE)) { // ����
//			QQLogger.clientLogger().info("�Է����ջ����ߣ�");
//			//
//			
//		}else if (type.equals(MessageType.RST_SUCCESS)) { // ͬ��
//			QQLogger.clientLogger().info("�Է�ͬ����գ�");
//			
//		}else if (type.equals(MessageType.FILE_DATA)) { // ������
//			QQLogger.clientLogger().info("��ʼ�������ݣ�");
//			
//		}else if (type.equals(MessageType.FILE_RECE)) {
//			
//		}else if (type.equals(MessageType.FILE_SEND)) { // �����ļ�����֪ͨ
//			
//		}else {
//			throw new Exception("δ֪���ļ�������Ϣ��");
//		}
		cf.showFileWidget(msg);
	}	
}
