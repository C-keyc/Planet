package vc.server.bz;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

import vc.list.common.*;
import vc.server.dao.GoodsDao_Imp;


/**
 *  服务器端消息处理线程
 * @author Aodong Shen
 *
 */
public class ServerClientThread extends Thread {

	private Socket client;

	private User owner;
	private boolean isClosed;
	private GoodsDao_Imp gdao = new GoodsDao_Imp();

	public ServerClientThread(Socket s, User user) {
		this.client = s;  //接收消息时获得的发送消息的客户端
		this.owner = user;
		this.isClosed = false;		
	}

	@Override
	public void run() {

		while (!isClosed) {
			// 这里该线程就可以接收客户端的信息
			try {

				ObjectInputStream ois = new ObjectInputStream(
						client.getInputStream());
				Message msg = (Message) ois.readObject();
				User sender = msg.getSender();

         		String type = msg.getType();
         		
         		
         		

				// 对从客户端取得的消息进行类型判断，让后做相应的处理
				if (type.equals(MessageType.CMD_CHECK_GOODS)) { 
					// ---从数据库查询商品
					Goods gd = msg.getGd();
					System.out.println("已经接收到客户端的查询申请"+gd.getGoodsID());
			
					gd = gdao.QueryID(gd.getGoodsID());
					
					// ---创建消息
					Message m = new Message();
					m.setSender(sender);
					m.setGd(gd);
					m.setReceiver(sender);
					m.setType(MessageType.CMD_CHECK_GOODS);
					// --发送至查询用户
					ObjectOutputStream oos = new ObjectOutputStream(getClient()
							.getOutputStream());
					oos.writeObject(m);
					oos.flush();

				} else if(type.equals(MessageType.CMD_QUERY_GOODS)){
					
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					
					
					m.setGdlist(gdao.getAllGoods());
					
					this.SendToClient(m);
				}
				else {					
					throw new Exception("未知的消息類型！");
				}
			} catch (SocketException se) {				
				this.isClosed = true;
				//QQLogger.serverLogger().info(this.owner.getQqNo() + " 线程被结束!" + se);				
			} catch (EOFException e) {
				this.isClosed = true;				
				//QQLogger.serverLogger().info(this.owner.getQqNo() + " 线程被结束!" + e);				
			}
			catch (Exception e) {
				e.printStackTrace();
				//QQLogger.serverLogger().info(this.owner.getQqNo() + " 线程被结束!" + e);
			}
		}		
	}

	private Socket getClient() {
		return client;
	}

	private void SendToClient(Message m) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(getClient()
					.getOutputStream());
			oos.writeObject(m);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void close() {

		// 强制客户端退出
		//QQLogger.serverLogger().info("关闭与客户端线程" + owner.getQqNo());
		// 更新服务器
		//owner.setStatus(UserStatus.OFFLINE);
		//iud.updUser(owner);
	
		// 销毁线程		
		isClosed = true;	
		// 中断线程：线程阻塞时	[对IO无效]
		//this.interrupt();
	}

}
