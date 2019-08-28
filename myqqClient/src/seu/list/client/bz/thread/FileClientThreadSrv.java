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
		// this.start(); // 应在登录验证成功后启动
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
			// 不停地读取从服务器端发来的消息
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
//		if (type.equals(MessageType.RST_FAILURE)) { // 拒收
//			QQLogger.clientLogger().info("对方拒收或不在线！");
//			//
//			
//		}else if (type.equals(MessageType.RST_SUCCESS)) { // 同意
//			QQLogger.clientLogger().info("对方同意接收！");
//			
//		}else if (type.equals(MessageType.FILE_DATA)) { // 数据流
//			QQLogger.clientLogger().info("开始接收数据！");
//			
//		}else if (type.equals(MessageType.FILE_RECE)) {
//			
//		}else if (type.equals(MessageType.FILE_SEND)) { // 好友文件发送通知
//			
//		}else {
//			throw new Exception("未知的文件服务消息！");
//		}
		cf.showFileWidget(msg);
	}	
}
