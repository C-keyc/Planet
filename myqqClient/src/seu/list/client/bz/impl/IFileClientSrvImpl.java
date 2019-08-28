package seu.list.client.bz.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;

import seu.list.client.bz.IFileClientSrv;
import seu.list.client.bz.thread.FileClientThreadSrv;
import seu.list.client.bz.thread.FileClientThreadSrvMgr;
import seu.list.client.view.ChatFrm;
import seu.list.client.view.ChatFrmMgr;
import seu.list.common.Message;

public class IFileClientSrvImpl implements IFileClientSrv {

	@Override
	public void send(Message msg) throws IOException {
		FileClientThreadSrv cts = FileClientThreadSrvMgr.getInstance().get(
				msg.getSender().getQqNo());
		ObjectOutputStream oos = new ObjectOutputStream(cts.getOutputStream());
		oos.writeObject(msg);
		oos.flush();

	}

	@Override
	public Message receive(String qqNo) throws ClassNotFoundException,
			IOException {
		FileClientThreadSrv cts = FileClientThreadSrvMgr.getInstance()
				.get(qqNo);
		ObjectInputStream ois = new ObjectInputStream(cts.getInputStream());
		return (Message) ois.readObject();
	}

	@Override
	public void send(String senderNo, String receiverNo, File file) throws UnknownHostException,
			IOException {
		FileClientThreadSrv fcts = FileClientThreadSrvMgr.getInstance().get(
				senderNo);
		DataOutputStream dos = new DataOutputStream(fcts.getOutputStream());
		DataInputStream data = new DataInputStream(new FileInputStream(file));
		long length = file.length();
		ChatFrm chatFrm = ChatFrmMgr.getInstance().get(senderNo + ChatFrm.NAME_SPLITTER + receiverNo);
		for(int i = 0; i < length; i++) {
			dos.writeByte(data.readByte());			
			chatFrm.showProgress(i * 100.0/ length );
		}
		dos.flush();
		// 给视图消息已经发送完成
		chatFrm.showProgress(file);		
	}

	@Override
	public void receive(String receiverNo, String senderNo, File file, long length) throws UnknownHostException, IOException {
		FileClientThreadSrv fcts = FileClientThreadSrvMgr.getInstance().get(receiverNo);
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		DataInputStream data = new DataInputStream(fcts.getInputStream());	
		ChatFrm chatFrm = ChatFrmMgr.getInstance().get(receiverNo + ChatFrm.NAME_SPLITTER + senderNo);
		for(int i = 0; i < length; i++) {			
			dos.writeByte(data.readByte());
			chatFrm.showProgress(i * 100.0/ length );
		}
		dos.flush();
		// 给视图消息已经接收完成
		chatFrm.showProgress(file);
	}
}
