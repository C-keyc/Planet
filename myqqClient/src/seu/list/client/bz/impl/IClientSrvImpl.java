package seu.list.client.bz.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import seu.list.client.bz.IClientSrv;
import seu.list.client.bz.thread.ClientThreadSrv;
import seu.list.client.bz.thread.ClientThreadSrvMgr;
import seu.list.common.Message;
import seu.list.common.User;

public class IClientSrvImpl implements IClientSrv {

	public IClientSrvImpl() {

	}

	@Override
	public void send(Message msg) throws IOException {

		ObjectOutputStream oos = getOutput(msg.getSender());
		oos.writeObject(msg);
		oos.flush();

	}

	private ObjectOutputStream getOutput(User user) throws IOException {
		ClientThreadSrv cts = ClientThreadSrvMgr.get(user.getQqNo());
		ObjectOutputStream oos = new ObjectOutputStream(cts.getOutputStream());
		return oos;
	}

	/**
	 * 该方法仅在登录时可以使用;验证成功后交由线程负责接收数据
	 */
	@Override
	public Message receive(String qqNo) throws ClassNotFoundException,
			IOException {
		ObjectInputStream ois = getInput(qqNo);
		return (Message) ois.readObject();
	}

	private ObjectInputStream getInput(String qqNo) throws IOException {
		ClientThreadSrv cts = ClientThreadSrvMgr.get(qqNo);
		ObjectInputStream ois = new ObjectInputStream(cts.getInputStream());
		return ois;
	}

}
