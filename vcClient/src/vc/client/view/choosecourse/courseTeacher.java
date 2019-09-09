package vc.client.view.choosecourse;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Course;
import vc.list.common.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;



public class courseTeacher extends JFrame {

	private JPanel contentPane;
	private  User owner;
	public  JFrame frame;

	private Course course=new Course();
	private UserSrvImpl usrv = new UserSrvImpl();
	private  List<Course> ccsList;
	private JTable table_allstudentcourse;
	boolean tableEditable = false;
	private Object[][] tabledata;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					User u = new User();
					courseTeacher frame = new courseTeacher(u);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public void passcslist(List <Course> ccsslist)
	{
	  ccsList=ccsslist;	
	}
	
	public Object[][] setTabledata(List<Course> csList){
		csList=ccsList;
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
	public courseTeacher(User user) {
		
		this.owner = user;
		courseTeacherMgr.add(user.getUserID(), this);  //放入这个gui的表集合里，相应消息时拿出来
		try {
			usrv.CourseAllShow(user,ccsList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//initialize();
	}
	
	public void initialize() {
		setTitle("\u6B22\u8FCE\u6765\u5230\u8BFE\u7A0B\u7BA1\u7406\u7CFB\u7EDF");
		setBounds(100, 100, 699, 485);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 245, 238));
		JLabel label_identity = new JLabel("\u767B\u9646\u8EAB\u4EFD\uFF1A");
		label_identity.setFont(new Font("仿宋", Font.PLAIN, 22));
		label_identity.setBounds(79, 52, 131, 21);
		contentPane.add(label_identity);
		setFont(new Font("仿宋", Font.PLAIN, 18));
		JLabel lblId_ID = new JLabel("ID\uFF1A");
		lblId_ID.setFont(new Font("仿宋", Font.PLAIN, 22));
		lblId_ID.setBounds(462, 52, 81, 21);
		contentPane.add(lblId_ID);
		
		JLabel label_teacherIdentity = new JLabel("\u6559\u5E08");
		label_teacherIdentity.setFont(new Font("仿宋", Font.PLAIN, 20));
		label_teacherIdentity.setBounds(225, 52, 81, 21);
		contentPane.add(label_teacherIdentity);
		
		JLabel label_IDnumber = new JLabel(owner.getUserID());
		label_IDnumber.setFont(new Font("仿宋", Font.PLAIN, 20));
		label_IDnumber.setBounds(553, 52, 95, 21);
		contentPane.add(label_IDnumber);
		
		JButton button_addcourse = new JButton("\u6DFB\u52A0\u8BFE\u7A0B");
		button_addcourse.setFont(new Font("仿宋", Font.PLAIN, 20));
		button_addcourse.setForeground(SystemColor.desktop);
		button_addcourse.setBackground(UIManager.getColor("Button.darkShadow"));
		button_addcourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseTADD add=new courseTADD(owner);
				add.setVisible(true);
				add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button_addcourse.setBounds(66, 113, 225, 29);
		contentPane.add(button_addcourse);
		
		JButton btnNewButton_deletecourse = new JButton("\u53D6\u6D88\u8BFE\u7A0B");
		btnNewButton_deletecourse.setFont(new Font("仿宋", Font.PLAIN, 20));
		btnNewButton_deletecourse.setForeground(new Color(0, 0, 0));
		btnNewButton_deletecourse.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNewButton_deletecourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseTDELETE delete=new courseTDELETE(owner);
				delete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				delete.setVisible(true);
			}
		});
		btnNewButton_deletecourse.setBounds(405, 113, 225, 29);
		contentPane.add(btnNewButton_deletecourse);
		
		JButton btnNewButton_checkteachercourse = new JButton("\u67E5\u770B\u6211\u7684\u8BFE\u7A0B");
		btnNewButton_checkteachercourse.setFont(new Font("仿宋", Font.PLAIN, 20));
		btnNewButton_checkteachercourse.setForeground(new Color(0, 0, 0));
		btnNewButton_checkteachercourse.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNewButton_checkteachercourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseTCheck check=new courseTCheck(owner);
				check.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				check.setVisible(true);
			}
		});
		btnNewButton_checkteachercourse.setBounds(66, 180, 225, 29);
		contentPane.add(btnNewButton_checkteachercourse);
		
		JButton button = new JButton("\u9000\u51FA");
		button.setFont(new Font("楷体", Font.PLAIN, 20));
		button.setForeground(new Color(0, 0, 0));
		button.setBackground(UIManager.getColor("Button.darkShadow"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(405, 180, 225, 29);
		contentPane.add(button);
		
		JScrollPane scrollPane_allstudentcourse = new JScrollPane();
		scrollPane_allstudentcourse.setBounds(66, 245, 569, 169);
		contentPane.add(scrollPane_allstudentcourse);
		table_allstudentcourse = new JTable();
		table_allstudentcourse.setFont(new Font("楷体", Font.PLAIN, 20));
		table_allstudentcourse.setBackground(new Color(245, 245, 245));
		scrollPane_allstudentcourse.setViewportView(table_allstudentcourse);
		tabledata=setTabledata(ccsList);
		table_allstudentcourse.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table_allstudentcourse.setModel(new DefaultTableModel(
				tabledata,
			new String[] {
				"\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u4EFB\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65F6\u95F4"
			}
		));
		table_allstudentcourse.setRowHeight(30);
		
		repaint();
	}
	
	public List<Course> getCslist() {
		return ccsList;
	}

	public void setCslist(List<Course> cslist) {
		this.ccsList = cslist;
	}
}
