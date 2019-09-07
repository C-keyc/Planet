package vc.client.view.choosecourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Course;
import vc.list.common.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JScrollPane;

public class courseTCheck extends JFrame {

	private JPanel contentPane;
	private JTable table_checkteachercourse;
	private JScrollPane scrollPane_checkteachercourse;
	private UserSrvImpl usrv = new UserSrvImpl();
	private static List<Course> ccsListt;
	private User owner;
	public static JFrame frame;
	private JButton button;
	private Object[][] tabledata;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					courseTCheck frame = new courseTCheck();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public courseTCheck(User user) {
		this.owner=user;
		try {
			courseTCheckMgr.add(owner.getUserID(), this);
			usrv.CourseTeacherShow(user,ccsListt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Object[][] setTabledata(List<Course> csList){
		csList=ccsListt;
		int csNum = csList.size();
		if(csNum>0) {
		Object[][] data = new Object[csNum][4];
		for(int i = 0;i<csNum;i++)
			for(int j = 0;j<4;j++)
			{
				switch(j) {
				case 0:
					data[i][j]=csList.get(i).getCourseID();break;
				case 1:
					data[i][j]=csList.get(i).getCourseName();break;
				case 2:
					data[i][j]=csList.get(i).getCourseTeacher();break;
				case 3:
					data[i][j]=csList.get(i).getCourseTime();break;
			}
			}
		return data;
		}
		else {
			return null;
		}
	}
	
	public void initialize() {
		frame=new JFrame();
		frame.setTitle("快乐星球虚拟校园查看我的授课课程");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 733, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane_checkteachercourse = new JScrollPane();
		scrollPane_checkteachercourse.setBounds(15, 31, 681, 273);
		contentPane.add(scrollPane_checkteachercourse);
		
		table_checkteachercourse = new JTable();
		tabledata=setTabledata( ccsListt);
		scrollPane_checkteachercourse.setViewportView(table_checkteachercourse);
		table_checkteachercourse.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_checkteachercourse.setModel(new DefaultTableModel(
			//new Object[][] {
				/*{cslist.get(0).getCourseID(), cslist.get(0).getCourseName(), cslist.get(0).getCourseTeacher(),cslist.get(0).getCourseTime()},
				{cslist.get(1).getCourseID(), cslist.get(1).getCourseName(), cslist.get(1).getCourseTeacher(),cslist.get(1).getCourseTime()},
				{cslist.get(2).getCourseID(), cslist.get(2).getCourseName(), cslist.get(2).getCourseTeacher(),cslist.get(2).getCourseTime()},
				{cslist.get(3).getCourseID(), cslist.get(3).getCourseName(), cslist.get(3).getCourseTeacher(),cslist.get(3).getCourseTime()},
				{cslist.get(4).getCourseID(), cslist.get(4).getCourseName(), cslist.get(4).getCourseTeacher(),cslist.get(4).getCourseTime()},
				{cslist.get(5).getCourseID(), cslist.get(5).getCourseName(), cslist.get(5).getCourseTeacher(),cslist.get(5).getCourseTime()},
				{cslist.get(6).getCourseID(), cslist.get(6).getCourseName(), cslist.get(6).getCourseTeacher(),cslist.get(6).getCourseTime()},
				{cslist.get(7).getCourseID(), cslist.get(7).getCourseName(), cslist.get(7).getCourseTeacher(),cslist.get(7).getCourseTime()},
				{cslist.get(8).getCourseID(), cslist.get(8).getCourseName(), cslist.get(8).getCourseTeacher(),cslist.get(8).getCourseTime()},
			*/
			//},
				tabledata,
			new String[] {
				"\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u4EFB\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65F6\u95F4"
			}
		));
		table_checkteachercourse.getColumnModel().getColumn(1).setPreferredWidth(91);
		table_checkteachercourse.getColumnModel().getColumn(2).setPreferredWidth(92);
		table_checkteachercourse.getColumnModel().getColumn(3).setPreferredWidth(88);
		table_checkteachercourse.setRowHeight(20);
		
		JButton button_quit = new JButton("\u9000\u51FA");
		button_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_quit.setBounds(543, 361, 123, 29);
		contentPane.add(button_quit);
	}


	public void passcslist(List<Course> cslist) {
		ccsListt=cslist;
		
	}
}
