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
import vc.server.dao.StudentDao_Imp;


/**
 *  ����������Ϣ�����߳�
 * @author Aodong Shen
 *
 */
public class ServerClientThread extends Thread {

	private Socket client;

	private User owner;
	private boolean isClosed;
	private GoodsDao_Imp gdao = new GoodsDao_Imp();
	private StudentDao_Imp stdao =new StudentDao_Imp();

	public ServerClientThread(Socket s, User user) {
		this.client = s;  //������Ϣʱ��õķ�����Ϣ�Ŀͻ���
		this.owner = user;
		this.isClosed = false;		
	}

	@Override
	public void run() {

		while (!isClosed) {
			// ������߳̾Ϳ��Խ��տͻ��˵���Ϣ
			try {

				ObjectInputStream ois = new ObjectInputStream(
						client.getInputStream());
				Message msg = (Message) ois.readObject();
				User sender = msg.getSender();

         		String type = msg.getType();
         		
         		
         		

				// �Դӿͻ���ȡ�õ���Ϣ���������жϣ��ú�����Ӧ�Ĵ���
				if (type.equals(MessageType.CMD_CHECK_GOODS)) { 
					// ---�����ݿ��ѯ��Ʒ
					Goods gd = msg.getGd();
					System.out.println("�Ѿ����յ��ͻ��˵Ĳ�ѯ����"+gd.getGoodsID());
			
					gd = gdao.QueryID(gd.getGoodsID());
					
					// ---������Ϣ
					Message m = new Message();
					m.setSender(sender);
					m.setGd(gd);
					m.setReceiver(sender);
					m.setType(MessageType.CMD_CHECK_GOODS);
					// --��������ѯ�û�
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
				
				else if(type.equals(MessageType.CMD_QUERY_STUDENTNAME)){
					
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setStudentList(stdao.QueryName(msg.getStudent().getStudentName()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_QUERY_STUDENTID)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setStudentList(stdao.QueryID(msg.getStudent().getStudentID()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_QUERY_STUDENTNUM)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setStudentList(stdao.QueryNum(msg.getStudent().getStudentNum()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_QUERY_STUDENTDEPARTMENT)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setStudentList(stdao.QueryDepartment(msg.getStudent().getStudentDepartment()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_QUERY_STUDENTMAJOR)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setStudentList(stdao.QueryMajor(msg.getStudent().getStudentMajor()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_QUERY_STUDENTGRADE)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setStudentList(stdao.QueryGrade(msg.getStudent().getStudentGrade()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_GETALLSTUDENT)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setStudentList(stdao.getAllStudents());
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_INSERT_STUDENT)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCMDsuc(stdao.InsertStudent(msg.getStudent()));
					m.setStudentList(stdao.getAllStudents());
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_DELETE_STUDENT)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCMDsuc(stdao.DeleteStudent(msg.getStudent()));
					m.setStudentList(stdao.getAllStudents());
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_UPDATE_STUDENTNAME)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCMDsuc(stdao.UpdateStudentName(msg.getStudent()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_UPDATE_STUDENTNUM)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCMDsuc(stdao.UpdateStudentNum(msg.getStudent()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_UPDATE_STUDENTGRADE)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCMDsuc(stdao.UpdateStudentGrade(msg.getStudent()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_UPDATE_STUDENTDEPARTMENT)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCMDsuc(stdao.UpdateStudentDepartment(msg.getStudent()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_UPDATE_STUDENTMAJOR)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCMDsuc(stdao.UpdateStudentMajor(msg.getStudent()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_UPDATE_STUDENTCLASS)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCMDsuc(stdao.UpdateStudentClass(msg.getStudent()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_UPDATE_STUDENTLENGTH)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCMDsuc(stdao.UpdateStudentLength(msg.getStudent()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_UPDATE_STUDENTRE)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCMDsuc(stdao.UpdateStudentRe(msg.getStudent()));
					this.SendToClient(m);
				}
				else if(type.equals(MessageType.CMD_UPDATE_STUDENTINSCHOOL)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCMDsuc(stdao.UpdateStudentinSchool(msg.getStudent()));
					this.SendToClient(m);
				}
				
				else if(type.equals(MessageType.CMD_CHECK_BOOK)){					
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					
					//m.setBklist(brdao.get);
					
					this.SendToClient(m);
				}else {
					throw new Exception("δ֪��Ӧ���ͣ�");
				}
			} catch (SocketException se) {				
				this.isClosed = true;
				//QQLogger.serverLogger().info(this.owner.getQqNo() + " �̱߳�����!" + se);				
			} catch (EOFException e) {
				this.isClosed = true;				
				//QQLogger.serverLogger().info(this.owner.getQqNo() + " �̱߳�����!" + e);				
			}
			catch (Exception e) {
				e.printStackTrace();
				//QQLogger.serverLogger().info(this.owner.getQqNo() + " �̱߳�����!" + e);
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

		// ǿ�ƿͻ����˳�
		//QQLogger.serverLogger().info("�ر���ͻ����߳�" + owner.getQqNo());
		// ���·�����
		//owner.setStatus(UserStatus.OFFLINE);
		//iud.updUser(owner);
	
		// �����߳�		
		isClosed = true;	
		// �ж��̣߳��߳�����ʱ	[��IO��Ч]
		//this.interrupt();
	}

}
