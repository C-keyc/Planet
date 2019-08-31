package vc.server.bz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import vc.list.common.Course;
import vc.list.common.Message;
import vc.list.common.MessageType;
import vc.list.common.User;
import vc.server.dao.UserDao_Imp;





public class IServerSrvImpl implements IServerSrv {

	
	private ServerSocket serverSocket;
	private boolean closed;
	private UserDao_Imp udi;
	
	
	public IServerSrvImpl() {
		// ��8888�˿ڼ���
		System.out.println("���Ƿ�����,��" + 5678 + "����");
		serverSocket = null;
		udi = new UserDao_Imp();
		try {
			serverSocket = new ServerSocket(5678);
			closed = false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {

			while (!closed && !serverSocket.isClosed())// ѭ������
			{
				Socket s = serverSocket.accept();

				System.out.println("�����ӵ��ͻ��ˣ�"+s.getInetAddress());
				ObjectInputStream ois = new ObjectInputStream(
						s.getInputStream());
				Message msg = (Message) ois.readObject();
				
				String msgType = msg.getType();
				User u = msg.getSender();
				System.out.println("�ͻ��˷�����Ϣ:"+u.getUname()+"�����½:");
				
			
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());


				if (msgType.equals(MessageType.CMD_LOGIN)) {// ���ݿ����֤��½
					User user = udi.Login(u);
					
					if (user == null) {
						//QQLogger.serverLogger().info(u.getQqNo() + "��֤ʧ�ܣ�");
						msg.setReceiver(u);
						msg.setType(MessageType.RST_FAILURE);
						oos.writeObject(msg);
						oos.flush();
						// �ر�����
					} else {
						System.out.println(u.getUname() + "��֤�ɹ���");
						// ���·�����״̬
						//user.setStatus(UserStatus.ONLINE);
						//iud.updUser(user);

						// ����һ���ɹ���½����Ϣ��
						msg.setType(MessageType.RST_SUCCESS);
						msg.setSender(user);
						msg.setReceiver(user);
						oos.writeObject(msg);
						oos.flush();
						
						
						// ����͵���һ���̡߳��ø��߳���ÿͻ��˱���ͨѶ
						ServerClientThread scct = new ServerClientThread(s,
								user);
						//ServerClientThreadMgr.add(user.getQqNo(), scct);
						// ������ÿͻ���ͨ�ŵ��߳�
						scct.start();												
					}
				}else {
					throw new Exception("δ֪����Ϣ���ͻ�����Socket");
				}
				
			}
		} catch (SocketException se) {
			if (serverSocket.isClosed()) {
				//QQLogger.serverLogger().info("������Socket�ѹرգ�");
			} else {
				se.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

		new Thread(this).start();
	}

	@Override
	public void close() {
	
	try{
		// TODO Auto-generated method stub

		closed = true;
		serverSocket.close();
		System.out.println("�������رգ�");
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		return closed;
	}

}
