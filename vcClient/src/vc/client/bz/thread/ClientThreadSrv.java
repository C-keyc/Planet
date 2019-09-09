package vc.client.bz.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vc.client.bz.impl.UserSrvImpl;
import vc.client.bz.thread.ClientThreadSrvMgr;
import vc.list.common.MessageType;
import vc.list.common.User;
import vc.client.view.*;
import vc.client.view.choosecourse.courseNOT;
import vc.client.view.choosecourse.courseOK;
import vc.client.view.choosecourse.courseSCheck;
import vc.client.view.choosecourse.courseSCheckMgr;
import vc.client.view.choosecourse.courseStudent;
import vc.client.view.choosecourse.courseStudentMgr;
import vc.client.view.choosecourse.courseTCheck;
import vc.client.view.choosecourse.courseTCheckMgr;
import vc.client.view.library.*;
import vc.client.view.message.*;
import vc.list.common.*;
import vc.list.common.Message;

public class ClientThreadSrv extends Thread {

	private Socket socket = null;
	private boolean isOffline;
	
	private User owner;
	private String ownerID;
	private Course course;
	private UserSrvImpl usrv = new UserSrvImpl();
	
	public ClientThreadSrv(String userID) throws IOException {
		InetAddress addr = InetAddress.getLocalHost();
	
		this.ownerID = userID;
		socket = new Socket(addr.getHostAddress(),5678);
		ClientThreadSrvMgr.add(userID, this); //����������û����߳���ӵ� �̱߳���
		isOffline = false;
	}
	
	public void run() {
		while (!isOffline) {
			ObjectInputStream ois = null;
			Message msg = null;
			// ��ͣ�ض�ȡ�ӷ������˷�������Ϣ
			try {
				ois = new ObjectInputStream(socket.getInputStream());  // ���ڱ��û���socket
				msg = (Message) ois.readObject();
				process(msg);
			} catch (IOException e) {
				isOffline = true;
				ClientThreadSrvMgr.remove(this.ownerID);
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				
			}
		}	
	}
	
	public void process(Message msg) throws IOException {
		//�������˴�������Ϣ
		String msgType = msg.getType();
		User sender = msg.getSender();
		

		
		if (msgType.equals(MessageType.CMD_CHECK_GOODS)) {
			if(msg.isOpState()) {
			ShopWorker_searchresultFrm CheckRpd=new ShopWorker_searchresultFrm(msg.getGd());
			CheckRpd.setVisible(true);}
			else
				JOptionPane.showMessageDialog(null, "�Ҳ�������", "��ѯ",JOptionPane.ERROR_MESSAGE);
		
		}else if(msgType.equals(MessageType.CMD_QUERY_GOODS)) {
			ShopWorker_manageFrm wk = ShopWorker_manageMgr.get(sender.getUserID());			
			wk.setGdlist(msg.getGdlist());
			wk.refresh();
		}else if(msgType.equals(MessageType.CMD_CHECK_ACCOUNT)){
			ShopConsumer_checkremainingFrm consumerCheck= new ShopConsumer_checkremainingFrm(sender);
			consumerCheck.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			consumerCheck.setVisible(true);
		}else if(msgType.equals(MessageType.CMD_ADD_GOODS)) {
			/*
			 * ShopWorker_manageFrm wk = ShopWorker_manageMgr.get(sender.getUserID());
			 * if(msg.isIDsuc()==false) { JOptionPane.showMessageDialog(null, "��Ʒ�����ظ�", "",
			 * JOptionPane.WARNING_MESSAGE); } else if(msg.getCMDsuc()==false) {
			 * JOptionPane.showMessageDialog(null, "���ʧ��", "", JOptionPane.WARNING_MESSAGE);
			 * }else { wk.setGdlist(msg.getGdlist()); wk.refresh();}
			 */
			ShopWorker_manageFrm wk = ShopWorker_manageMgr.get(sender.getUserID());
			wk.setGdlist(msg.getGdlist());
			wk.refresh();
		}else if(msgType.equals(MessageType.CMD_DEPOSIT)) {
			if(msg.isOpState())
				JOptionPane.showMessageDialog(null, "��ֵ�ɹ�", "��ֵ",JOptionPane.PLAIN_MESSAGE);  
			else
				JOptionPane.showMessageDialog(null, "��ֵʧ��", "��ֵ",JOptionPane.ERROR_MESSAGE);
		}else if(msgType.equals(MessageType.CMD_DELETE_GOODS)) {
			if(msg.isOpState()) {
				ShopWorker_manageFrm wk = ShopWorker_manageMgr.get(sender.getUserID());
				wk.setGdlist(msg.getGdlist());
				wk.refresh();
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "ɾ����Ʒ",JOptionPane.PLAIN_MESSAGE);  
			}
			else
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "ɾ����Ʒ",JOptionPane.ERROR_MESSAGE);
		}else if(msgType.equals(MessageType.CMD_SCAN_GOODS)) {
            Goods gd = msg.getGd();
			ShopWorker_deductFrm deduct = ShopWorker_deductMgr.get(sender.getUserID());
			deduct.addGdlist(gd);
			deduct.refresh();
		} else if(msgType.equals(MessageType.CMD_DEDUCT)) {
			if(msg.getCMDsuc()) {
			if(msg.isOpState()) {
				ShopWorker_deductFrm deduct = ShopWorker_deductMgr.get(sender.getUserID());
				deduct.setRemain(msg.getConsumer().getAccount());
				JOptionPane.showMessageDialog(null, "���ѳɹ�", "����",JOptionPane.PLAIN_MESSAGE);
				deduct.clear();
				ShopWorker_manageFrm wk = ShopWorker_manageMgr.get(sender.getUserID());
				if(wk!=null) {
				wk.setGdlist(msg.getGdlist());//
				wk.refresh();}
			}else {JOptionPane.showMessageDialog(null, "�˻����㣬���ȳ�ֵ��", "����",JOptionPane.ERROR_MESSAGE);}}
			else
				JOptionPane.showMessageDialog(null, "�����������", "����",JOptionPane.ERROR_MESSAGE);
            
		}else if (msgType.equals(MessageType.CMD_LOGOUT)) {			
				isOffline = true;					
				ClientThreadSrvMgr.remove(this.owner.getUserID());
				socket.close();
		}
		
		
		else  if(msgType.equals(MessageType.CMD_QUERY_COURSEID)){
			Course course=msg.getCourse();
			owner=msg.getSender();
			int typee=msg.getTypee();
			CourseOwner courseowner =msg.getCourseowner();
			if (course!=null) {
				System.out.println("�γ�ID������ȷ");
				if(typee==0)
				{
				try {
					usrv.CourseChoose(owner, courseowner);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				   }
				}
				if(typee==1)
				{
					try {
						usrv.QuitChoose(owner, courseowner);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					   }
				}
				if(typee==2)
				{
					try {
						usrv.CourseDelete(owner, course);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					   }
				}
			}
			else
			{
				System.out.println("�γ�ID�������");
				courseNOT not=new courseNOT();
				not.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				not.setVisible(true);
			}
		}
			
			else  if(msgType.equals(MessageType.CMD_CHOOSE_COURSE)){
				
					courseOK ok=new courseOK();
					ok.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					ok.setVisible(true);
		}
		
		else  if(msgType.equals(MessageType.CMD_ADD_COURSE))
		{
			Course course=msg.getCourse();
			if (course!=null) {
				System.out.println("�γ���ӳɹ�");
				courseOK ok=new courseOK();
				ok.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ok.setVisible(true);
			} else {		
				System.out.println("�γ����ʧ��");
                 courseNOT not=new courseNOT();
                 not.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				  not.setVisible(true);
			}
		}
		
		else  if(msgType.equals(MessageType.CMD_QUIT_COURSE))
		{

				System.out.println("�γ�ѡ�˳ɹ�");
				courseOK ok=new courseOK();
				ok.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ok.setVisible(true);
	}
		
		else  if(msgType.equals(MessageType.CMD_DELETE_COURSE))
		{

				System.out.println("�γ�ɾ���ɹ�");
				courseOK ok=new courseOK();
				ok.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ok.setVisible(true);
	}
		
//		else  if(msgType.equals(MessageType.CMD_SHOW_COURSE))
//		{
//          List<Course> cslist=msg.getCslist();
//          courseStudent student = courseStudentMgr.get(sender.getUserID());
//	     student.passcslist(cslist);
//	     student.refresh();
//	     //student.initialize();
//	     //student.repaint();
//	}
		
		else  if(msgType.equals(MessageType.CMD_SHOW_COURSE))
		{
          List<Course> cslist=msg.getCslist();
	     courseStudent.passcslist(cslist);
	}
		
		else  if(msgType.equals(MessageType.CMD_SHOWSTUDENT_COURSE))
		{
          List<Course> cslist=msg.getCslist();
          courseSCheck check = courseSCheckMgr.get(sender.getUserID());
          check.passcslist(cslist);
	     
	     check.initialize();
	}
		else  if(msgType.equals(MessageType.CMD_SHOWTEACHER_COURSE))
		{
          List<Course> cslist=msg.getCslist();
          courseTCheck check = courseTCheckMgr.get(sender.getUserID());
          check.passcslist(cslist);
	     
	     check.initialize();
	}
		
		else if(msgType.equals(MessageType.CMD_CHECK_BOOK)){
			LibraryReader_checkrecordFrm lbr = LibraryReaderMgr.get(sender.getUserID());
			lbr.setBkrlist(msg.getBkrlist());
			lbr.initialize();
			if(!lbr.isVisible())
				lbr.setVisible(true);
		}		
		else if(msgType.equals(MessageType.CMD_GETALLSTUDENT)) {
			MessageRoll_mainFrm MR_mF = MessageRoll_mainMgr.get(sender.getUserID());
			MR_mF.setStList(msg.getStudentList());
			MR_mF.initialize();
			if(!MR_mF.isVisible())
				MR_mF.setVisible(true);			
		}
		else if(msgType.equals(MessageType.CMD_QUERY_STUDENTID)||
				msgType.equals(MessageType.CMD_QUERY_STUDENTNAME)||
				msgType.equals(MessageType.CMD_QUERY_STUDENTNUM)||
				msgType.equals(MessageType.CMD_QUERY_STUDENTDEPARTMENT)||
				msgType.equals(MessageType.CMD_QUERY_STUDENTMAJOR)||
				msgType.equals(MessageType.CMD_QUERY_STUDENTGRADE)) {
			MessageRoll_mainFrm MR_mF = MessageRoll_mainMgr.get(sender.getUserID());
			MR_mF.setStList(msg.getStudentList());
			MR_mF.initialize();
			if(!MR_mF.isVisible())
				MR_mF.setVisible(true);
		}
		else if(msgType.equals(MessageType.CMD_INSERT_STUDENT)) {
			MessageRoll_mainFrm MR_mF = MessageRoll_mainMgr.get(sender.getUserID());
			if(msg.isIDsuc()==false)
				{JOptionPane.showMessageDialog(MR_mF.getPanel(), "һ��ͨ���ظ�", "", JOptionPane.WARNING_MESSAGE);}
				//JOptionPane.showMessageDialog(MR_mF.getPanel(), "��ӳɹ�", "", JOptionPane.INFORMATION_MESSAGE);
			else if(msg.getCMDsuc()==false)
				{JOptionPane.showMessageDialog(MR_mF.getPanel(), "���ʧ��", "", JOptionPane.WARNING_MESSAGE);}
			else {
			MR_mF.setStList(msg.getStudentList());
			MR_mF.initialize();
			if(!MR_mF.isVisible())
				MR_mF.setVisible(true);}
			/*
			 * MessageRoll_mainFrm MR_mF = MessageRoll_mainMgr.get(sender.getUserID());
			 * if(msg.getCMDsuc()) JOptionPane.showMessageDialog(MR_mF.getPanel(), "��ӳɹ�",
			 * "", JOptionPane.INFORMATION_MESSAGE); else
			 * JOptionPane.showMessageDialog(MR_mF.getPanel(), "���ʧ��", "",
			 * JOptionPane.WARNING_MESSAGE); MR_mF.setStList(msg.getStudentList());
			 * MR_mF.initialize(); if(!MR_mF.isVisible()) MR_mF.setVisible(true);
			 */
		}
		else if(msgType.equals(MessageType.CMD_DELETE_STUDENT)) {
			MessageRoll_mainFrm MR_mF = MessageRoll_mainMgr.get(sender.getUserID());
			if(msg.getCMDsuc())
				JOptionPane.showMessageDialog(MR_mF.getPanel(), "ɾ���ɹ�", "", JOptionPane.INFORMATION_MESSAGE);
			else 
				JOptionPane.showMessageDialog(MR_mF.getPanel(), "ɾ��ʧ��", "", JOptionPane.WARNING_MESSAGE);
			MR_mF.setStList(msg.getStudentList());
			MR_mF.initialize();
			if(!MR_mF.isVisible())
				MR_mF.setVisible(true);
		}
		else if(msgType.equals(MessageType.CMD_UPDATE_STUDENTNAME)||
				msgType.equals(MessageType.CMD_UPDATE_STUDENTNUM)||
				msgType.equals(MessageType.CMD_UPDATE_STUDENTGRADE)||
				msgType.equals(MessageType.CMD_UPDATE_STUDENTDEPARTMENT)||
				msgType.equals(MessageType.CMD_UPDATE_STUDENTMAJOR)||
				msgType.equals(MessageType.CMD_UPDATE_STUDENTCLASS)||
				msgType.equals(MessageType.CMD_UPDATE_STUDENTLENGTH)||
				msgType.equals(MessageType.CMD_UPDATE_STUDENTRE)||
				msgType.equals(MessageType.CMD_UPDATE_STUDENTINSCHOOL)) {
			MessageRoll_mainFrm MR_mF = MessageRoll_mainMgr.get(sender.getUserID());
			if(!msg.getCMDsuc()) {
				JOptionPane.showMessageDialog(MR_mF.getPanel(), "�޸�ʧ��", "", JOptionPane.WARNING_MESSAGE);
			/*MR_mF.setStList(msg.getStudentList());*/
				MR_mF.initialize();
					if(!MR_mF.isVisible())
				MR_mF.setVisible(true);}
			
		}else if(msgType.equals(MessageType.CMD_QUERY_BOOKID)) {
			
			Book bk = msg.getBk();

			LibraryReader_searchresultFrm windowsr = new LibraryReader_searchresultFrm(owner,bk);
			windowsr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			windowsr.setVisible(true);

		}else if(msgType.equals(MessageType.CMD_QUERY_BOOKNAME)) {
			
			List<Book> bklist = msg.getBklist();
			
			LibraryReader_searchbywriterFrm windowsr = new LibraryReader_searchbywriterFrm(owner,bklist);
			windowsr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			windowsr.setVisible(true);
			
		}else if(msgType.equals(MessageType.CMD_QUERY_BOOKWRITER)) {
			List<Book> bklist = msg.getBklist();
			LibraryReader_searchbywriterFrm windowsr = new LibraryReader_searchbywriterFrm(owner,bklist);
			windowsr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			windowsr.setVisible(true);
		}else if(msgType.equals(MessageType.CMD_CHECK_ALLBOOK)) {
			LibraryWorker_manageFrm libraryWorker_manageFrm = LibraryWorkerMgr.get(sender.getUserID());
			libraryWorker_manageFrm.setBklist(msg.getBklist());
			libraryWorker_manageFrm.initialize();
			libraryWorker_manageFrm.setVisible(true);
		}else if(msgType.equals(MessageType.CMD_NOTFIND_BOOK)) {
			LibraryReader_checkrecordFrm lbr = LibraryReaderMgr.get(sender.getUserID());
			JOptionPane.showMessageDialog(lbr, "��Ǹ��δ�ҵ��������", "", JOptionPane.WARNING_MESSAGE);
		}else if(msgType.equals(MessageType.CMD_QUERY_SEAT)) {
			LibraryReader_reservationFrm libraryReader_reservationFrm = LibraryReaderReservationMgr.get(sender.getUserID());
			String num = msg.getSeat().getSeatNum();
			libraryReader_reservationFrm.setNum(num);
			libraryReader_reservationFrm.updatetext();
		}else if(msgType.equals(MessageType.CMD_ADD_BOOK)) {
			LibraryWorker_addFrm libraryWorker_addFrm = LibraryWorkerAddMgr.get(sender.getUserID());
			if(msg.isIDsuc()==false) {
				JOptionPane.showMessageDialog(libraryWorker_addFrm, "�鼮����ظ�", "", JOptionPane.WARNING_MESSAGE);
			}
			else if(msg.getCMDsuc()==false) {
				JOptionPane.showMessageDialog(libraryWorker_addFrm, "���ʧ��", "", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(libraryWorker_addFrm, "��ӳɹ�", "", JOptionPane.INFORMATION_MESSAGE);
				
				LibraryWorker_manageFrm libraryWorker_manageFrm = LibraryWorkerMgr.get(sender.getUserID());
				libraryWorker_manageFrm.setBklist(msg.getBklist());
				libraryWorker_manageFrm.refresh();
				
			}
					
		}else if(msgType.equals(MessageType.CMD_CHANGE_PASSWORD)) {
			
			JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "", JOptionPane.INFORMATION_MESSAGE);
		}else if(msgType.equals(MessageType.CMD_CHANGE_PASSWORDFAILED)) {
			JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�", "", JOptionPane.WARNING_MESSAGE);
		}
		
		else {
			
		}
	}
	
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * @return
	 * @uml.property  name="socket"
	 */
	public Socket getSocket() {
		return socket;
	}
	
	
	public OutputStream getOutputStream() throws IOException {
		return socket.getOutputStream();
	}

	public InputStream getInputStream() throws IOException {
		return socket.getInputStream();
	}
	
	public void setOwner(User u) {
		this.owner = u;
	}

	public void dispose() throws IOException {
		isOffline = true;
		this.socket.close();		
	}
}
