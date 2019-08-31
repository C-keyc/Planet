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
		// 在8888端口监听
		System.out.println("我是服务器,在" + 5678 + "监听");
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

			while (!closed && !serverSocket.isClosed())// 循环监听
			{
				Socket s = serverSocket.accept();

				System.out.println("已连接到客户端："+s.getInetAddress());
				ObjectInputStream ois = new ObjectInputStream(
						s.getInputStream());
				Message msg = (Message) ois.readObject();
				
				String msgType = msg.getType();
				User u = msg.getSender();
				System.out.println("客户端发来消息:"+u.getUname()+"请求登陆:");
				
			
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());


				if (msgType.equals(MessageType.CMD_LOGIN)) {// 数据库的验证登陆
					User user = udi.Login(u);
					
					if (user == null) {
						//QQLogger.serverLogger().info(u.getQqNo() + "验证失败！");
						msg.setReceiver(u);
						msg.setType(MessageType.RST_FAILURE);
						oos.writeObject(msg);
						oos.flush();
						// 关闭连接
					} else {
						System.out.println(u.getUname() + "验证成功！");
						// 更新服务器状态
						//user.setStatus(UserStatus.ONLINE);
						//iud.updUser(user);

						// 返回一个成功登陆的信息包
						msg.setType(MessageType.RST_SUCCESS);
						msg.setSender(user);
						msg.setReceiver(user);
						oos.writeObject(msg);
						oos.flush();
						
						
						// 这里就单开一个线程。让该线程与该客户端保持通讯
						ServerClientThread scct = new ServerClientThread(s,
								user);
						//ServerClientThreadMgr.add(user.getQqNo(), scct);
						// 启动与该客户端通信的线程
						scct.start();												
					}
				}else {
					throw new Exception("未知的信息类型或错误的Socket");
				}
				
			}
		} catch (SocketException se) {
			if (serverSocket.isClosed()) {
				//QQLogger.serverLogger().info("服务器Socket已关闭！");
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
		System.out.println("服务器关闭！");
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
