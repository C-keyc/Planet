package seu.list.client.bz.impl;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import seu.list.client.bz.IClientSrv;
import seu.list.client.bz.IFileClientSrv;
import seu.list.client.bz.IUserSrv;
import seu.list.client.bz.thread.ClientThreadSrv;
import seu.list.client.bz.thread.ClientThreadSrvMgr;
import seu.list.client.bz.thread.FileClientThreadSrv;
import seu.list.client.bz.thread.FileClientThreadSrvMgr;
import seu.list.common.Group;
import seu.list.common.Message;
import seu.list.common.MessageType;
import seu.list.common.User;

/**
 * 提供用户指令服务：向服务器发送消息包：指令和数据
 * @author  Aodong Shen
 */
public class IUserSrvImpl implements IUserSrv {

	/**
	 * @uml.property  name="ics"
	 * @uml.associationEnd  
	 */
	private IClientSrv ics = new IClientSrvImpl();
	private IFileClientSrv ifcs = new IFileClientSrvImpl();

	@Override
	public User login(User user) throws IOException, ClassNotFoundException {
		Message msg = new Message();
		msg.setSender(user);
		msg.setType(MessageType.CMD_LOGIN);
		User u = null;
		//

		ics.send(msg);
		msg = ics.receive(user.getQqNo());
		if (msg.getType().equals(MessageType.RST_SUCCESS)) {
			// 启动对应的线程
			ClientThreadSrv cts = ClientThreadSrvMgr.get(user.getQqNo());
			cts.start();
			u = msg.getReceiver();
			cts.setOwner(u);
			// 启动文件服务线程
			FileClientThreadSrv fcts = FileClientThreadSrvMgr.getInstance().get(user.getQqNo());
			fcts.start();
			fcts.setOwner(u);
			
			msg.setSender(u);
			msg.setReceiver(null);
			ifcs.send(msg);
			
		}else if(msg.getType().equals(MessageType.RST_FAILURE)) {
			ClientThreadSrv cts = ClientThreadSrvMgr.remove(user.getQqNo());
			cts.dispose();
		}

		return u;
	}

	/**
	 * 返回所有好友列表
	 * @throws IOException 
	 */
	@Override
	public void quyFriend(User user) throws IOException {
		// 调用Client service类，发送登录请求
		// IClientSrv ics = new IClientSrvImpl();
		Message msg = new Message();
		msg.setSender(user);
		msg.setReceiver(user);
		msg.setType(MessageType.CMD_ALL_FRIENDS);
		//
		sendMessage(msg);
	}

	public void sendMessage(Message msg) throws IOException {	
			ics.send(msg);	
	}

	@Override
	public boolean logout(User user) throws IOException {
		Message msg = new Message();
		msg.setSender(user);
		msg.setType(MessageType.CMD_LOGOUT);
		sendMessage(msg);
		sendFileMessage(msg);
		return true;
	}

	@Override
	public User register(User user) throws IOException, ClassNotFoundException {
		Message msg = new Message();
		msg.setSender(user);
		msg.setType(MessageType.CMD_REGISTER);
		User u = null;
		//
		ics.send(msg);
		msg = ics.receive(user.getQqNo());
		if (msg.getType().equals(MessageType.RST_SUCCESS)) {					
			u = msg.getReceiver();			
		}
		//
		ClientThreadSrv cts = ClientThreadSrvMgr.remove(user.getQqNo());
		cts.dispose();
		
		return u;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFriend(User user, String friendNo) throws IOException {
		Message msg = new Message();
		msg.setSender(user);
		msg.setContent(friendNo);
		msg.setType(MessageType.CMD_ADD_FRIEND);
		sendMessage(msg);
	}

	@Override
	public void delFriend(User user, String friendNo) throws IOException {
		Message msg = new Message();
		msg.setSender(user);
		msg.setContent(friendNo);
		msg.setType(MessageType.CMD_DEL_FRIEND);
		sendMessage(msg);
	}

	@Override
	public void updFriend(User user, User friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quyFriend(User user, String friendNo) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public Group addGroup(User user, String grpName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group delGroup(User user, String grpName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group updGroup(User user, Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> quyGroup(User user, String grpName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void chat(User sender, User reciever, String content) throws IOException {

		Message m = new Message();
		m.setType(MessageType.DAT_TEXT);
		m.setSender(sender);
		m.setReceiver(reciever);
		m.setContent(content);
		this.sendMessage(m);
	}

	@Override
	public User isFriend(User user, String friendNo) {
		
		return null;
	}

	@Override
	public void sendFile(User sender, String receiverNo, File file) throws UnknownHostException, IOException {
		this.ifcs.send(sender.getQqNo(), receiverNo, file);		
	}

	@Override
	public void receiveFile(User receiver, String senderNo, File file, long length) throws UnknownHostException, IOException {
		this.ifcs.receive(receiver.getQqNo(), senderNo, file, length);		
	}

	@Override
	public void sendFileMessage(Message msg) throws IOException {
		ifcs.send(msg);		
	}

	@Override
	public void sendFile(User owner, User friend, File file) throws IOException {
		Message m = new Message();
		m.setType(MessageType.FILE_SEND);
		m.setSender(owner);
		m.setReceiver(friend);
		m.setData(file);
		this.ifcs.send(m);			
	}

	@Override
	public void sendShake(User owner, User friend) throws IOException{
		Message m = new Message();
		m.setType(MessageType.DAT_ACTION);
		m.setSender(owner);
		m.setReceiver(friend);
		//m.setContent(content);
		this.sendMessage(m);	
	}

}
