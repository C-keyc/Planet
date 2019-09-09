package vc.client.view.choosecourse;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Course;
import vc.list.common.Message;
import vc.list.common.User;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class courseStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField_choosecourseID;
	private JTextField textField_quitcourseID;
	private JTable table_allstudentcourse;
	private User owner;
	public static JFrame frame;
	private Course course=new Course();
	private UserSrvImpl usrv = new UserSrvImpl();
	private static List<Course> ccsList;
	
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
					courseStudent frame = new courseStudent(u);
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static  void passcslist(List <Course> ccsslist)
	{
	  ccsList=ccsslist;	
	}
	
	public courseStudent(User user) {
		this.owner=user;
		courseStudentMgr.add(user.getUserID(), this);  //放入这个gui的表集合里，相应消息时拿出来
		try {
			usrv.CourseAllShow(user,ccsList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		initialize();
	}


	public Object[][] setTabledata(List<Course> csList){
		csList=ccsList;
		int csNum = csList.size();
		if(csNum>0) {
		Object[][] data = new Object[csNum][4];
		for(int i = 0;i<csNum;i++)
			for(int j = 0;j<10;j++)
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
	
private void initialize() {
	setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5B66\u751F\u9009\u8BFE\u7CFB\u7EDF");
	getContentPane().setLayout(null);
	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);;
	setBounds(100, 100, 770, 566);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 245, 238));
    contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
    setContentPane(contentPane);
	contentPane.setLayout(null);
	setVisible(true);
	JLabel label_identity = new JLabel("\u767B\u9646\u8EAB\u4EFD\uFF1A");
	label_identity.setFont(new Font("楷体", Font.PLAIN, 20));
	label_identity.setBounds(33, 15, 112, 21);
	contentPane.add(label_identity);
	
	
	JLabel label_studentidentity = new JLabel("\u5B66\u751F");
	label_studentidentity.setFont(new Font("楷体", Font.PLAIN, 20));
	label_studentidentity.setBounds(168, 15, 81, 21);
	contentPane.add(label_studentidentity);
	
	JLabel label_number = new JLabel(owner.getUserID());
	label_number.setFont(new Font("楷体", Font.PLAIN, 20));
	label_number.setBounds(518, 15, 149, 21);
	contentPane.add(label_number);
	
	JLabel lblid_choosecourseID = new JLabel("\u9009\u8BFEID\uFF1A");
	lblid_choosecourseID.setFont(new Font("楷体", Font.PLAIN, 20));
	lblid_choosecourseID.setBounds(121, 84, 81, 21);
	contentPane.add(lblid_choosecourseID);
	
	JLabel lblid_quitcourseID = new JLabel("\u9000\u8BFEID\uFF1A");
	lblid_quitcourseID.setFont(new Font("楷体", Font.PLAIN, 20));
	lblid_quitcourseID.setBounds(121, 148, 81, 21);
	contentPane.add(lblid_quitcourseID);
	
	textField_choosecourseID = new JTextField();
	textField_choosecourseID.setBounds(262, 81, 149, 27);
	contentPane.add(textField_choosecourseID);
	textField_choosecourseID.setColumns(10);
	
	textField_quitcourseID = new JTextField();
	textField_quitcourseID.setBounds(262, 145, 149, 27);
	contentPane.add(textField_quitcourseID);
	textField_quitcourseID.setColumns(10);
	
	JButton button_choosecourse = new JButton("\u9009\u8BFE");
	button_choosecourse.setFont(new Font("楷体", Font.PLAIN, 20));
	button_choosecourse.setBounds(501, 80, 123, 29);
	button_choosecourse.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String choosecourseID=textField_choosecourseID.getText().trim();
			course.setCourseID(choosecourseID);
			int typee=0;
			try {
				usrv.CourseCheck(owner, course,typee);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	});
	contentPane.add(button_choosecourse);
	
	JButton button_quitcourse = new JButton("\u9000\u8BFE");
	button_quitcourse.setFont(new Font("楷体", Font.PLAIN, 20));
	button_quitcourse.setBounds(501, 144, 123, 29);
	button_quitcourse.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String quitcourseID = textField_quitcourseID .getText().trim();
			course.setCourseID(quitcourseID);
			int typee=1;
			try {
				usrv.CourseCheck(owner,course,typee);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	});
	contentPane.add(button_quitcourse);
	
	JButton button_checkchoosedcourse = new JButton("\u67E5\u770B\u5DF2\u9009\u8BFE\u7A0B");
	button_checkchoosedcourse.setBounds(188, 204, 342, 29);
	button_checkchoosedcourse.setFont(new Font("楷体", Font.PLAIN, 20));
	button_checkchoosedcourse.setForeground(new Color(0, 0, 0));
	button_checkchoosedcourse.setBackground(UIManager.getColor("Button.background"));
	button_checkchoosedcourse.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			courseSCheck check=new courseSCheck(owner);
			check.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);;
			check.setVisible(true);
		}
	});
	contentPane.add(button_checkchoosedcourse);
	
	JLabel label_3 = new JLabel("\u6240\u6709\u8BFE\u7A0B\uFF1A");
	label_3.setFont(new Font("楷体", Font.PLAIN, 20));
	label_3.setBounds(15, 270, 112, 21);
	contentPane.add(label_3);
	
	
	JScrollPane scrollPane_allstudentcourse = new JScrollPane();
	scrollPane_allstudentcourse.setBounds(124, 261, 569, 169);
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
	
	JLabel lblId_ID = new JLabel("ID\uFF1A");
	lblId_ID.setFont(new Font("楷体", Font.PLAIN, 20));
	lblId_ID.setBounds(422, 15, 81, 21);
	contentPane.add(lblId_ID);
	
	JButton button = new JButton("\u9000\u51FA");
	button.setFont(new Font("楷体", Font.PLAIN, 19));
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	button.setBounds(562, 466, 123, 29);
	contentPane.add(button);
}



public void queryCourse() {
	
	Message msg = new Message();
	msg.setType("CMD_QUERY_COURSEID");
	msg.setSender(owner);
	
	
	try {
		usrv.sendMessage(msg);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public List<Course> getCslist() {
	return ccsList;
}

public void setCslist(List<Course> cslist) {
	this.ccsList = cslist;
}
}