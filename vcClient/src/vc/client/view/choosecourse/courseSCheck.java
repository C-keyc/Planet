package vc.client.view.choosecourse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Course;
import vc.list.common.Goods;
import vc.list.common.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;


public class courseSCheck extends JFrame {

	private JPanel contentPane;
	private JTable table_checkstudentcourse;
	private JScrollPane scrollPane_checkstudentcourse;
	private UserSrvImpl usrv = new UserSrvImpl();
	private static List<Course> ccsListt;
	private User owner;
	public static JFrame frame;
	private JButton button;
	private Object[][] tabledata;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new User();
					courseSCheck frame = new courseSCheck(u);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public courseSCheck(User user) {
		this.owner=user;
		try {
			courseSCheckMgr.add(owner.getUserID(), this);
			usrv.CourseStudentShow(user,ccsListt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//initialize();
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
		frame.setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u67E5\u770B\u6211\u7684\u8BFE\u8868");
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);;
		frame.setBounds(100, 100, 727, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		frame.setVisible(true);
		contentPane.setLayout(null);
		scrollPane_checkstudentcourse = new JScrollPane();
		scrollPane_checkstudentcourse.setBounds(22, 89, 668, 176);
		contentPane.add(scrollPane_checkstudentcourse);
		
		table_checkstudentcourse = new JTable();
		scrollPane_checkstudentcourse.setViewportView(table_checkstudentcourse);
		table_checkstudentcourse.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table_checkstudentcourse.setBackground(Color.WHITE);
		table_checkstudentcourse.setFont(new Font("·ÂËÎ", Font.PLAIN, 18));
		table_checkstudentcourse.setForeground(Color.BLACK);
		tabledata=setTabledata( ccsListt);
		table_checkstudentcourse.setRowHeight(30);
		table_checkstudentcourse.setModel(new DefaultTableModel(
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
		
		button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setBounds(521, 351, 123, 29);
		contentPane.add(button);
		table_checkstudentcourse.getColumnModel().getColumn(1).setPreferredWidth(84);
		table_checkstudentcourse.getColumnModel().getColumn(2).setPreferredWidth(87);
		table_checkstudentcourse.getColumnModel().getColumn(3).setPreferredWidth(89);
	}

	public void passcslist(List<Course> cslist) {
		ccsListt=cslist;
	}
}
