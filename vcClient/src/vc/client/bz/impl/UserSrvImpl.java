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
import vc.list.common.Student;
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
	
	public void getAllStudents(User sender) throws IOException {
		Message m = new Message();
		m.setSender(sender);
		m.setType(MessageType.CMD_GETALLSTUDENT);
		this.sendMessage(m); 
	}
	public void deleteStudent(User sender,Student st) throws IOException {
		Message m = new Message();
		m.setSender(sender);
		m.setStudent(st);
		m.setType(MessageType.CMD_DELETE_STUDENT);
		this.sendMessage(m); 
	}
	public void queryStudentID(User sender,Student st) throws IOException {
		Message m = new Message();
		m.setSender(sender);
		m.setType(MessageType.CMD_QUERY_STUDENTID);
		m.setStudent(st);
		this.sendMessage(m); 
	}
	public void queryStudentName(User sender,Student st) throws IOException {
		Message m = new Message();
		m.setSender(sender);
		m.setType(MessageType.CMD_QUERY_STUDENTNAME);
		m.setStudent(st);
		this.sendMessage(m); 
	}
	public void queryStudentNum(User sender,Student st) throws IOException {
		Message m = new Message();
		m.setSender(sender);
		m.setType(MessageType.CMD_QUERY_STUDENTNUM);
		m.setStudent(st);
		this.sendMessage(m); 
	}
	public void queryStudentDepartment(User sender,Student st) throws IOException {
		Message m = new Message();
		m.setSender(sender);
		m.setType(MessageType.CMD_QUERY_STUDENTDEPARTMENT);
		m.setStudent(st);
		this.sendMessage(m); 
	}
	public void queryStudentMajor(User sender,Student st) throws IOException {
		Message m = new Message();
		m.setSender(sender);
		m.setType(MessageType.CMD_QUERY_STUDENTMAJOR);
		m.setStudent(st);
		this.sendMessage(m); 
	}
	public void queryStudentGrade(User sender,Student st) throws IOException {
		Message m = new Message();
		m.setSender(sender);
		m.setType(MessageType.CMD_QUERY_STUDENTGRADE);
		m.setStudent(st);
		this.sendMessage(m); 
	}
	public void insertStudent(User sender,Student st) throws IOException {
		Message m = new Message();
		m.setSender(sender);
		m.setType(MessageType.CMD_INSERT_STUDENT);
		m.setStudent(st);
		this.sendMessage(m); 
	}
	public void updateStudent(User sender,String str,String stID,int type) throws IOException {
		Message m = new Message();
		m.setSender(sender);
		Student st=new Student();
		st.setStudentID(stID);
		switch(type){
		case 0:
			st.setStudentName(str);
			m.setType(MessageType.CMD_UPDATE_STUDENTNAME);break;
		case 2:
			st.setStudentNum(str);
			m.setType(MessageType.CMD_UPDATE_STUDENTNUM);break;
		case 3:
			st.setStudentGrade(str);
			m.setType(MessageType.CMD_UPDATE_STUDENTGRADE);break;
		case 4:
			st.setStudentDepartment(str);
			m.setType(MessageType.CMD_UPDATE_STUDENTDEPARTMENT);break;
		case 5:
			st.setStudentMajor(str);
			m.setType(MessageType.CMD_UPDATE_STUDENTMAJOR);break;
		case 6:
			st.setStudentClass(str);
			m.setType(MessageType.CMD_UPDATE_STUDENTCLASS);break;
		case 7:
			st.setStudentLength(str);
			m.setType(MessageType.CMD_UPDATE_STUDENTLENGTH);break;
		case 8:
			st.setStudentRe(str);
			m.setType(MessageType.CMD_UPDATE_STUDENTRE);break;
		case 9:
			st.setStudentinSchool(str);
			m.setType(MessageType.CMD_UPDATE_STUDENTINSCHOOL);break;
		}
		
		m.setStudent(st);
		this.sendMessage(m); 
	}
	
}
