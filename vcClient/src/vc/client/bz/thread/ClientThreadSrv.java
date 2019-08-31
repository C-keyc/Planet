package vc.client.bz.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import vc.client.bz.thread.ClientThreadSrvMgr;
import vc.list.common.MessageType;
import vc.list.common.User;
import vc.client.view.WkCheckRpd;
import vc.client.view.*;
import vc.client.view.WkManageMgr;
import vc.list.common.*;
import vc.list.common.Message;

public class ClientThreadSrv extends Thread {

	private Socket socket = null;
	private boolean isOffline;
	
	private User owner;
	private String ownerID;
	
	public ClientThreadSrv(String userID) throws IOException {
		InetAddress addr = InetAddress.getLocalHost();
	
		this.ownerID = userID;
		socket = new Socket(addr.getHostAddress(),5678);
		ClientThreadSrvMgr.add(userID, this); //把属于这个用户的线程添加到 线程表里
		isOffline = false;
	}
	
	public void run() {
		while (!isOffline) {
			ObjectInputStream ois = null;
			Message msg = null;
			// 不停地读取从服务器端发来的消息
			try {
				ois = new ObjectInputStream(socket.getInputStream());  // 属于本用户的socket
				msg = (Message) ois.readObject();
				process(msg);
			} catch (IOException e) {
				isOffline = true;
				ClientThreadSrvMgr.remove(this.ownerID);
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
	
	public void process(Message msg) {
		//处理服务端传来的消息
		String msgType = msg.getType();
		User sender = msg.getSender();
		
		if (msgType.equals(MessageType.CMD_CHECK_GOODS)) {
			
			Goods gd = msg.getGd();
			WkCheckRpd CheckRpd=new WkCheckRpd(gd);
			CheckRpd.setVisible(true);
			System.out.println("从服务端得到的信息:"+gd.getGoodsName()+gd.getGoodsPrice());
		
		}else if(msgType.equals(MessageType.CMD_QUERY_GOODS)) {
			WkManage wk = WkManageMgr.get(sender.getUserID());
			
			wk.setGdlist(msg.getGdlist());
			
		}
		else {
			
		}
	}
	
	
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
	
	public void setOwner(User u) {
		this.owner = u;
	}

	public void dispose() throws IOException {
		isOffline = true;
		this.socket.close();		
	}
}
