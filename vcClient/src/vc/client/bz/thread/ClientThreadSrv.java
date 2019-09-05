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

import vc.client.bz.thread.ClientThreadSrvMgr;
import vc.list.common.MessageType;
import vc.list.common.User;
import vc.client.view.WkCheckRpd;
import vc.client.view.*;
import vc.client.view.WkManageMgr;
import vc.client.view.library.*;
import vc.client.view.message.*;
import vc.list.common.*;
import vc.list.common.Message;

public class ClientThreadSrv extends Thread {

	private Socket socket = null;
	private boolean isOffline;
	
	private User owner;
	private String ownerID;
	
	public ClientThreadSrv(String userID) throws IOException {
		InetAddress addr = InetAddress.getLocalHost();
	
		this.ownerID = userID;
		socket = new Socket(addr.getHostAddress(),5678);
		ClientThreadSrvMgr.add(userID, this); //把属于这个用户的线程添加到 线程表里
		isOffline = false;
	}
	
	public void run() {
		while (!isOffline) {
			ObjectInputStream ois = null;
			Message msg = null;
			// 不停地读取从服务器端发来的消息
			try {
				ois = new ObjectInputStream(socket.getInputStream());  // 属于本用户的socket
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
		//处理服务端传来的消息
		String msgType = msg.getType();
		User sender = msg.getSender();
		
		if (msgType.equals(MessageType.CMD_CHECK_GOODS)) {
			
			Goods gd = msg.getGd();
			WkCheckRpd CheckRpd=new WkCheckRpd(gd);
			CheckRpd.setVisible(true);
			System.out.println("从服务端得到的信息:"+gd.getGoodsName()+gd.getGoodsPrice());
		
		}else if(msgType.equals(MessageType.CMD_QUERY_GOODS)) {
			WkManage wk = WkManageMgr.get(sender.getUserID());			
			wk.setGdlist(msg.getGdlist());			
		}else if(msgType.equals(MessageType.CMD_CHECK_ACCOUNT)){
			ShopComsumer_checkremainingFrm consumerCheck= new ShopComsumer_checkremainingFrm(sender);
			consumerCheck.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			consumerCheck.setVisible(true);
		}else if(msgType.equals(MessageType.CMD_ADD_GOODS)) {
			WkManage wk = WkManageMgr.get(sender.getUserID());
			wk.setGdlist(msg.getGdlist());
			wk.refresh();
		}else if(msgType.equals(MessageType.CMD_DEPOSIT)) {
			if(msg.isOpState())
				JOptionPane.showMessageDialog(null, "充值成功", "充值",JOptionPane.PLAIN_MESSAGE);  
			else
				JOptionPane.showMessageDialog(null, "充值失败", "充值",JOptionPane.ERROR_MESSAGE);
		}else if(msgType.equals(MessageType.CMD_DELETE_GOODS)) {
			if(msg.isOpState()) {
				WkManage wk = WkManageMgr.get(sender.getUserID());
				wk.setGdlist(msg.getGdlist());
				wk.refresh();
				JOptionPane.showMessageDialog(null, "删除成功", "删除商品",JOptionPane.PLAIN_MESSAGE);  
			}
			else
				JOptionPane.showMessageDialog(null, "删除失败", "删除商品",JOptionPane.ERROR_MESSAGE);
		} else if (msgType.equals(MessageType.DAT_LOGOUT)) {
			
				isOffline = true;					
				// 从管理池中移除
				ClientThreadSrvMgr.remove(this.owner.getUserID());
				// 释放Socket资源
				socket.close();
		}
		else if(msgType.equals(MessageType.CMD_CHECK_BOOK)){
			LibraryReader_checkrecordFrm lbr = LibraryReaderMgr.get(sender.getUserID());			
			lbr.setBkrlist(msg.getBkrlist());			
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
			if(msg.getCMDsuc())
				JOptionPane.showMessageDialog(MR_mF.getPanel(), "添加成功", "", JOptionPane.INFORMATION_MESSAGE);
			else 
				JOptionPane.showMessageDialog(MR_mF.getPanel(), "添加失败", "", JOptionPane.WARNING_MESSAGE);
			MR_mF.setStList(msg.getStudentList());
			MR_mF.initialize();
			if(!MR_mF.isVisible())
				MR_mF.setVisible(true);
		}
		else if(msgType.equals(MessageType.CMD_DELETE_STUDENT)) {
			MessageRoll_mainFrm MR_mF = MessageRoll_mainMgr.get(sender.getUserID());
			if(msg.getCMDsuc())
				JOptionPane.showMessageDialog(MR_mF.getPanel(), "删除成功", "", JOptionPane.INFORMATION_MESSAGE);
			else 
				JOptionPane.showMessageDialog(MR_mF.getPanel(), "删除失败", "", JOptionPane.WARNING_MESSAGE);
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
				JOptionPane.showMessageDialog(MR_mF.getPanel(), "修改失败", "", JOptionPane.WARNING_MESSAGE);
			/*MR_mF.setStList(msg.getStudentList());*/
				MR_mF.initialize();
					if(!MR_mF.isVisible())
				MR_mF.setVisible(true);}
			
		}else if(msgType.equals(MessageType.CMD_CHECK_BOOK)){
			LibraryReader_checkrecordFrm lbr = LibraryReaderMgr.get(sender.getUserID());
			lbr.setBkrlist(msg.getBkrlist());
			
		}else if(msgType.equals(MessageType.CMD_QUERY_BOOKID)) {
			
			Book bk = msg.getBk();

			LibraryReader_searchresultFrm windowsr = new LibraryReader_searchresultFrm(owner,bk);
			windowsr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			windowsr.setVisible(true);

		}else if(msgType.equals(MessageType.CMD_QUERY_BOOKNAME)) {
			
			Book bk = msg.getBk();
			
			LibraryReader_searchresultFrm windowsr = new LibraryReader_searchresultFrm(owner,bk);
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
		}else if(msgType.equals(MessageType.CMD_NOTFIND_BOOK)) {
			LibraryReader_searchNotresultFrm libraryReader_searchNotresultFrm = new LibraryReader_searchNotresultFrm(owner);
			libraryReader_searchNotresultFrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			libraryReader_searchNotresultFrm.setVisible(true);
		}else if(msgType.equals(MessageType.CMD_QUERY_SEAT)) {
			LibraryReader_reservationFrm libraryReader_reservationFrm = LibraryReaderReservationMgr.get(sender.getUserID());
			String num = msg.getSeat().getSeatNum();
			libraryReader_reservationFrm.setNum(num);
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
