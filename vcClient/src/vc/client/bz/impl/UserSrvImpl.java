package vc.client.bz.impl;

//�����ṩ���û��ķ��񣬸�����˷�����Ϣ

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
		msg.setSender(user);//����Ϣ����µ�¼�û�
		msg.setType(MessageType.CMD_LOGIN);
		User u = null;
		

		csi.send(msg);  //csi �����Ȳ����û����̣߳�Ȼ������Ϣ
		msg=csi.receive(user.getUserID()); //���յ�½������Ϣ
		
		
		if (msg.getType().equals(MessageType.RST_SUCCESS)) {
			// �����û�idȥ�̱߳���������Ӧ���߳�
			ClientThreadSrv cts = ClientThreadSrvMgr.get(user.getUserID());
			cts.start(); //�ڴ��߳���Ӧ�����˵���Ϣ
			u = msg.getReceiver();
			cts.setOwner(u);
		}else if(msg.getType().equals(MessageType.RST_FAILURE)) {//��½ʧ�ܣ��������̱߳����޳�
			ClientThreadSrv cts = ClientThreadSrvMgr.remove(user.getUserID());
			cts.dispose();
		}
		
		return u;
	}
	
	
	public void sendMessage(Message msg) throws IOException {	
		csi.send(msg);	
}
	
	public void ShopCheck(User sender ,Goods gd) throws IOException { //���ܺ����Ĳ�����user ��Ҫ���͵���Ϣ

		
		Message m = new Message();
		m.setSender(sender);
		m.setType(MessageType.CMD_CHECK_GOODS);
		m.setGd(gd);  //������Ϣ
		this.sendMessage(m); // ���÷��ͷ���������Ϣ���ͼ���

	}
}
