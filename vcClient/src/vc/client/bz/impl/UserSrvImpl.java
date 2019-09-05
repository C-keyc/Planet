package vc.client.bz.impl;

//用来提供对用户的服务，给服务端发送消息

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vc.client.bz.thread.ClientThreadSrvMgr;
import vc.client.bz.thread.ClientThreadSrv;
import vc.list.common.Book;
import vc.list.common.Goods;
import vc.list.common.Message;
import vc.list.common.MessageType;
import vc.list.common.Seat;
import vc.list.common.Student;
import vc.list.common.User;

public class UserSrvImpl {
	
	private ClientSrvImpl csi = new ClientSrvImpl();


	public User login(User user) throws IOException, ClassNotFoundException {
	
		Message msg = new Message();
		msg.setSender(user);//在消息里更新登录用户
		msg.setType(MessageType.CMD_LOGIN);
		User u = null;
		

		csi.send(msg);  //csi 里首先查找用户的线程，然后发送信息
		msg=csi.receive(user.getUserID()); //接收登陆反馈信息
		
		
		if (msg.getType().equals(MessageType.RST_SUCCESS)) {
			// 根据用户id去线程表里启动对应的线程
			ClientThreadSrv cts = ClientThreadSrvMgr.get(user.getUserID());
			cts.start(); //在此线程里应答服务端的消息
			u = msg.getReceiver();
			cts.setOwner(u);
		}else if(msg.getType().equals(MessageType.RST_FAILURE)) {//登陆失败，把他从线程表里剔除
			ClientThreadSrv cts = ClientThreadSrvMgr.remove(user.getUserID());
			cts.dispose();
		}
		
		return u;
	}
	
	
	public void sendMessage(Message msg) throws IOException {	
		csi.send(msg);	
	}
	
	public void ShopCheck(User sender ,Goods gd) throws IOException { //功能函数的参数用user 和要发送的信息

		
		Message m = new Message();
		m.setSender(sender);
		m.setType(MessageType.CMD_CHECK_GOODS);
		m.setGd(gd);  //更新消息
		this.sendMessage(m); // 调用发送方法，把消息发送即可

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
	public void queryBookName(User owner ,String str) {
		Message msg = new Message();
		msg.setType("CMD_QUERY_BOOKNAME");
		msg.setSender(owner);
		Book bk = new Book();
		bk.setBookName(str);
		msg.setBk(bk);
		System.out.println("LibraryReader_searchresultFrm:�ͻ��˷�����Ϣ�ɹ���\"CMD_QUERY_BOOKNAME\"");
		try {
			sendMessage(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void queryBookID(User owner ,String str) {

		Message msg = new Message();
		msg.setType("CMD_QUERY_BOOKID");
		msg.setSender(owner);
		Book bk = new Book();
		bk.setBookID(str);
		msg.setBk(bk);
		
		System.out.println("LibraryReader_searchresultFrm:�ͻ��˷�����Ϣ�ɹ���\"CMD_QUERY_BOOKID\"");
		try {
			sendMessage(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}


	public void queryBookWriter(User owner, String str) {
		Message msg = new Message();
		msg.setType("CMD_QUERY_BOOKWRITER");
		msg.setSender(owner);
		Book bk = new Book();
		bk.setBookWriter(str);
		msg.setBk(bk);
		
		System.out.println("LibraryReader_searchresultFrm:�ͻ��˷�����Ϣ�ɹ���\"CMD_QUERY_BOOKID\"");
		try {
			sendMessage(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	public void querySeat(User owner, Seat t) {
		Message msg = new Message();
		msg.setType("CMD_QUERY_SEAT");
		msg.setSender(owner);
		msg.setSeat(t);
		
		try {
			sendMessage(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void checkAllBook(User owner) {
		Message msg = new Message();
		msg.setType("CMD_CHECK_ALLBOOK");
		msg.setSender(owner);
		try {
			sendMessage(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}


	public void addBook(User owner,Book bk) {
		Message msg = new Message();
		msg.setType("CMD_ADD_BOOK");
		msg.setSender(owner);
		msg.setBk(bk);
		try {
			sendMessage(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}


	public void deleteBook(User owner,String id) {
		Message msg = new Message();
		msg.setType("CMD_DELETE_BOOK");
		msg.setSender(owner);
		Book bk = new Book(id);
		msg.setBk(bk);
		try {
			sendMessage(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
