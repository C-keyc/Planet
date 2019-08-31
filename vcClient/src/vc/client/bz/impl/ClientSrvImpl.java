package vc.client.bz.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vc.client.bz.thread.ClientThreadSrv;
import vc.client.bz.thread.ClientThreadSrvMgr;
import vc.list.common.Message;
import vc.list.common.User;


//  实现发送消息的方法，根据用户的id获得她/他的线程，返回oos
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
	 * 该方法仅在登录时可以使用;验证成功后交由线程负责接收数据
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
