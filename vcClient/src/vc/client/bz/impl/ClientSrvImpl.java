package vc.client.bz.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vc.client.bz.thread.ClientThreadSrv;
import vc.client.bz.thread.ClientThreadSrvMgr;
import vc.list.common.Message;
import vc.list.common.User;


//  ʵ�ַ�����Ϣ�ķ����������û���id�����/�����̣߳�����oos
public class ClientSrvImpl {

	public ClientSrvImpl() {
		// TODO Auto-generated constructor stub
	}

	public void send(Message msg) throws IOException {

		ObjectOutputStream oos = getOutput(msg.getSender());
		oos.writeObject(msg);
		oos.flush();

	}

	private ObjectOutputStream getOutput(User user) throws IOException {
		ClientThreadSrv cts = ClientThreadSrvMgr.get(user.getUserID());
		ObjectOutputStream oos = new ObjectOutputStream(cts.getOutputStream());
		return oos;
	}

	/**
	 * �÷������ڵ�¼ʱ����ʹ��;��֤�ɹ������̸߳����������
	 */

	public Message receive(String userid) throws ClassNotFoundException,
			IOException {
		ObjectInputStream ois = getInput(userid);
		return (Message) ois.readObject();
	}

	private ObjectInputStream getInput(String userid) throws IOException {
		ClientThreadSrv cts = ClientThreadSrvMgr.get(userid);
		ObjectInputStream ois = new ObjectInputStream(cts.getInputStream());
		return ois;
	}
}
