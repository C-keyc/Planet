package vc.client.bz.impl;

//用来提供对用户的服务，给服务端发送消息

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vc.client.bz.thread.ClientThreadSrvMgr;
import vc.client.bz.thread.ClientThreadSrv;
import vc.list.common.Goods;
import vc.list.common.Message;
import vc.list.common.MessageType;
import vc.list.common.User;

public class UserSrvImpl {
	
	private ClientSrvImpl csi = new ClientSrvImpl();


	public User login(User user) throws IOException, ClassNotFoundException {
	
		Message msg = new Message();
		msg.setSender(user);//在消息里更新登录用户
		msg.setType(MessageType.CMD_LOGIN);
		User u = null;
		

		csi.send(msg);  //csi 里首先查找用户的线程，然后发送信息
		msg=csi.receive(user.getUserID()); //接收登陆反馈信息
		
		
		if (msg.getType().equals(MessageType.RST_SUCCESS)) {
			// 根据用户id去线程表里启动对应的线程
			ClientThreadSrv cts = ClientThreadSrvMgr.get(user.getUserID());
			cts.start(); //在此线程里应答服务端的消息
			u = msg.getReceiver();
			cts.setOwner(u);
		}else if(msg.getType().equals(MessageType.RST_FAILURE)) {//登陆失败，把他从线程表里剔除
			ClientThreadSrv cts = ClientThreadSrvMgr.remove(user.getUserID());
			cts.dispose();
		}
		
		return u;
	}
	
	
	public void sendMessage(Message msg) throws IOException {	
		csi.send(msg);	
}
	
	public void ShopCheck(User sender ,Goods gd) throws IOException { //功能函数的参数用user 和要发送的信息

		
		Message m = new Message();
		m.setSender(sender);
		m.setType(MessageType.CMD_CHECK_GOODS);
		m.setGd(gd);  //更新消息
		this.sendMessage(m); // 调用发送方法，把消息发送即可

	}
}
