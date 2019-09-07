package vc.server.bz;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

import vc.list.common.*;
import vc.server.dao.BookDao_Imp;
import vc.server.dao.CourseDao_lmp;
import vc.server.dao.GoodsDao_Imp;
import vc.server.dao.StudentDao_Imp;
import vc.server.dao.UserDao_Imp;


/**
 *  服务器端消息处理线程
 * 
 *
 */
public class ServerClientThread extends Thread {

	private Socket client;

	private User owner;
	private boolean isClosed;
	private GoodsDao_Imp gdao = new GoodsDao_Imp();
	private StudentDao_Imp stdao =new StudentDao_Imp();
	private BookDao_Imp bdao = new BookDao_Imp();
	private UserDao_Imp udi=new UserDao_Imp();
	private CourseDao_lmp cdao = new CourseDao_lmp();
	
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
					Goods gd = msg.getGd();			
					gd = gdao.QueryID(gd.getGoodsID());					
					Message m = new Message();
					m.setSender(sender);
					m.setGd(gd);
					m.setReceiver(sender);
					m.setType(MessageType.CMD_CHECK_GOODS);
					// --发送至查询用户
                    this.SendToClient(m);

				} else if(type.equals(MessageType.CMD_QUERY_GOODS)){
					
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);									
					m.setGdlist(gdao.getAllGoods());					
					this.SendToClient(m);
				}else if(type.equals(MessageType.CMD_CHECK_ACCOUNT)) {
					msg.setSender(udi.Login(sender));
					this.SendToClient(msg);
				}else if(type.equals(MessageType.CMD_ADD_GOODS)) {
					Goods gd = msg.getGd();					
					if(gdao.InsertGoods(gd))
						msg.setGdlist(gdao.getAllGoods());
					else 
						System.out.println("插入数据失败");
					this.SendToClient(msg);	
				}else if(type.equals(MessageType.CMD_DEPOSIT)) {
					boolean result = udi.UpdateAccount(sender);
					msg.setOpState(result);
					this.SendToClient(msg);
				}else if(type.equals(MessageType.CMD_DELETE_GOODS)) {
					Goods gd = msg.getGd();
					if(gdao.DeleteGoods(gd)) {
						msg.setGdlist(gdao.getAllGoods());
						msg.setOpState(true);
					}else 
						System.out.println("插入数据失败");
					this.SendToClient(msg);
				}else if(type.equals(MessageType.CMD_DELETE_GOODS)) {
					isClosed = true;
					ServerClientThreadMgr.remove(this.owner.getUserID());
					break;
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
					List<BookRecord> bkrlist = bdao.getAllBook(sender.getUserID());
					m.setBkrlist(bkrlist);
					this.SendToClient(m);
					
				}else if(type.equals(MessageType.CMD_QUERY_BOOKID)) {
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					Book bk = msg.getBk();
					bk = bdao.QueryBookID(bk.getBookID());
					if(bk!=null) {
						m.setBk(bk);
						this.SendToClient(m);
					}else {
						m.setType("CMD_NOTFIND_BOOK");
						this.SendToClient(m);
					}
								
				}else if(type.equals(MessageType.CMD_QUERY_BOOKNAME)) {
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					Book bk = msg.getBk();
					bk = bdao.QueryBookName(bk.getBookName());
					if(bk!=null) {
					m.setBk(bk);
					this.SendToClient(m);
					}else {
						m.setType("CMD_NOTFIND_BOOK");
						this.SendToClient(m);
					}
				}else if(type.equals(MessageType.CMD_QUERY_BOOKWRITER)) {
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					Book bk = msg.getBk();
					List<Book> queryBookWriter = bdao.QueryBookWriter(bk.getBookWriter());
					if(queryBookWriter!=null)
					{m.setBklist(queryBookWriter);
					this.SendToClient(m);}
					else {
						m.setType("CMD_NOTFIND_BOOK");
						this.SendToClient(m);
					}

				}else if(type.equals(MessageType.CMD_CHECK_ALLBOOK))
				{
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					List<Book> queryallBook = bdao.CheckAllBook();
					m.setBklist(queryallBook);
					this.SendToClient(m);
				}else if(type.equals(MessageType.CMD_ADD_BOOK)) {
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					Book bk= msg.getBk();
					bdao.AddBook(bk);
					this.SendToClient(m);
				}else if(type.equals(MessageType.CMD_DELETE_BOOK)) {
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					Book bk= msg.getBk();
					bdao.DeleteBook(bk);
					this.SendToClient(m);
				}else if(type.equals(MessageType.CMD_QUERY_SEAT)){
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					Seat seat = msg.getSeat();
					Seat s= bdao.QuerySeat(seat);
					m.setSeat(s);
					this.SendToClient(m);
				}
				
				else if(type.equals(MessageType.CMD_QUERY_COURSEID))
				{
					Course course = msg.getCourse();
					System.out.println("已经接收到客户端的查询申请"+course.getCourseID());

					course = cdao.QueryID(course.getCourseID());
					String courseid=course.getCourseID();
					User userr=msg.getSender();
					CourseOwner courseowner=new CourseOwner();
					courseowner.setCourseID(courseid);
					courseowner.setOwnerID(userr.getUserID());
					int typee=msg.getTypee();
					// ---创建消息
					Message m = new Message();
					m.setSender(sender);
					m.setCourse(course);
					m.setReceiver(sender);
					m.setCourseowner(courseowner);
					m.setTypee(typee);
					m.setType(MessageType.CMD_QUERY_COURSEID);
					// --发送至查询用户
					ObjectOutputStream oos = new ObjectOutputStream(getClient()
							.getOutputStream());
					oos.writeObject(m);
					oos.flush();
				} 
				
				else if(type.equals(MessageType.CMD_ADD_COURSE))
				{
					Course course = msg.getCourse();
					System.out.println("已经接收到客户端的添加课程申请，添加的课程ID为："+course.getCourseID());

					if(cdao.InsertCourse(course)){
					
					// ---创建消息
					Message m = new Message();
					m.setSender(sender);
					m.setCourse(course);
					m.setReceiver(sender);
					m.setType(MessageType.CMD_ADD_COURSE);
					// --发送至查询用户
					ObjectOutputStream oos = new ObjectOutputStream(getClient()
							.getOutputStream());
					oos.writeObject(m);
					oos.flush();
					}
					else
					{
						System.out.println("添加课程失败"+course.getCourseID());
					}
				}
				
				else if(type.equals(MessageType.CMD_DELETE_COURSE))
				{
					Course course = msg.getCourse();
					System.out.println("已经接收到客户端的删除课程申请，删除的课程ID为："+course.getCourseID());

					if(cdao.DeleteCourse(course)){
					
					// ---创建消息
					Message m = new Message();
					m.setSender(sender);
					m.setCourse(course);
					m.setReceiver(sender);
					m.setType(MessageType.CMD_DELETE_COURSE);
					// --发送至查询用户
					ObjectOutputStream oos = new ObjectOutputStream(getClient()
							.getOutputStream());
					oos.writeObject(m);
					oos.flush();
					}
					else
					{
						System.out.println("删除课程失败"+course.getCourseID());
					}
				}
				
				else if(type.equals(MessageType.CMD_CHOOSE_COURSE))
				{
					CourseOwner courseowner = msg.getCourseowner();
					System.out.println("已经接收到客户端的选择课程申请，选择的课程ID为："+courseowner.getCourseID());

					if(cdao.ChooseCourse(courseowner)){
					
					// ---创建消息
					Message mm = new Message();
					mm.setSender(sender);
					mm.setCourseowner(courseowner);
					mm.setReceiver(sender);
					mm.setType(MessageType.CMD_CHOOSE_COURSE);
					// --发送至查询用户
					ObjectOutputStream oos = new ObjectOutputStream(getClient()
							.getOutputStream());
					oos.writeObject(mm);
					oos.flush();
					}
					else
					{
						System.out.println("选择课程失败"+courseowner.getCourseID());
					}
				}
				
				else if(type.equals(MessageType.CMD_SHOW_COURSE))
				{
					System.out.println("已经接收到客户端的显示课程申请");
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					m.setCslist(cdao.getAllCourse());
					this.SendToClient(m);
				}
			
				else if(type.equals(MessageType.CMD_SHOWSTUDENT_COURSE))
				{
					System.out.println("已经接收到客户端的显示课程申请");
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					String id=sender.getUserID();
					m.setCslist(cdao.getStudentCourse(id));
					this.SendToClient(m);
				}
				
				else if(type.equals(MessageType.CMD_SHOWTEACHER_COURSE))
				{
					System.out.println("已经接收到客户端的显示课程申请");
					Message m = new Message();
					m.setSender(sender);
					m.setType(type);
					String name=sender.getUname();
					m.setCslist(cdao.getTeacherCourse(name));
					this.SendToClient(m);
				}
				
				else if(type.equals(MessageType.CMD_QUIT_COURSE))
				{
					CourseOwner courseowner = msg.getCourseowner();
					System.out.println("已经接收到客户端的选退课程申请，选择的课程ID为："+courseowner.getCourseID());

					if(cdao.QuitCourse(courseowner)){
					
					// ---创建消息
					Message mm = new Message();
					mm.setSender(sender);
					mm.setCourseowner(courseowner);
					mm.setReceiver(sender);
					mm.setType(MessageType.CMD_QUIT_COURSE);
					// --发送至查询用户
					ObjectOutputStream oos = new ObjectOutputStream(getClient()
							.getOutputStream());
					oos.writeObject(mm);
					oos.flush();
					} 
					else
					{
						System.out.println("选退课程失败"+courseowner.getCourseID());
					}
				}
				
				
				else {
					throw new Exception("未知相应类型！");
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
