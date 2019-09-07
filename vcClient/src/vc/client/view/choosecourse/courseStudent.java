package vc.client.view.choosecourse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
import java.awt.Toolkit;

public class courseStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField_choosecourseID;
	private JTextField textField_quitcourseID;
	private JTable table;
	private JTable table_allstudentcourse;
	private User owner;
	public static JFrame frame;
	private Course course=new Course();
	private UserSrvImpl usrv = new UserSrvImpl();
	private static List<Course> ccsList;
	
	private JTable tblMessage;
	boolean tableEditable = false;
	private Object[][] tabledata=null;
	private DefaultTableModel tablemodel;
	
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
		 //放入这个gui的表集合里，相应消息时拿出来
		courseStudentMgr.add(user.getUserID(), this); 
		initialize();
		
		try {
			usrv.CourseAllShow(user,ccsList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//queryCourse();
		

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
	
public void initialize() {
	frame=new JFrame();
	setIconImage(Toolkit.getDefaultToolkit().getImage(courseStudent.class.getResource("/image/logo.jpg")));
	frame.setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5B66\u751F\u9009\u8BFE\u7CFB\u7EDF");
	frame.getContentPane().setLayout(null);
	frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);;
	frame.setBounds(100, 100, 716, 501);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 245, 238));
    contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
    frame.setContentPane(contentPane);
	contentPane.setLayout(null);
	frame.setVisible(true);
	JLabel label_identity = new JLabel("\u767B\u9646\u8EAB\u4EFD\uFF1A");
	label_identity.setBounds(33, 15, 95, 21);
	contentPane.add(label_identity);
	
	
	JLabel label_studentidentity = new JLabel("\u5B66\u751F");
	label_studentidentity.setBounds(131, 15, 81, 21);
	contentPane.add(label_studentidentity);
	
	JLabel label_number = new JLabel(owner.getUserID());
	label_number.setBounds(501, 15, 81, 21);
	contentPane.add(label_number);
	
	JLabel lblid_choosecourseID = new JLabel("\u9009\u8BFEID\uFF1A");
	lblid_choosecourseID.setBounds(35, 84, 81, 21);
	contentPane.add(lblid_choosecourseID);
	
	JLabel lblid_quitcourseID = new JLabel("\u9000\u8BFEID\uFF1A");
	lblid_quitcourseID.setBounds(35, 148, 81, 21);
	contentPane.add(lblid_quitcourseID);
	
	textField_choosecourseID = new JTextField();
	textField_choosecourseID.setBounds(127, 81, 96, 27);
	contentPane.add(textField_choosecourseID);
	textField_choosecourseID.setColumns(10);
	
	textField_quitcourseID = new JTextField();
	textField_quitcourseID.setBounds(131, 145, 96, 27);
	contentPane.add(textField_quitcourseID);
	textField_quitcourseID.setColumns(10);
	
	JButton button_choosecourse = new JButton("\u9009\u8BFE");
	button_choosecourse.setBounds(392, 80, 123, 29);
	button_choosecourse.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String choosecourseID=textField_choosecourseID.getText().trim();
			course.setCourseID(choosecourseID);
			int typee=0;
			try {
				usrv.CourseCheck(owner, course,typee);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	contentPane.add(button_choosecourse);
	
	JButton button_quitcourse = new JButton("\u9000\u8BFE");
	button_quitcourse.setBounds(392, 144, 123, 29);
	button_quitcourse.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String quitcourseID = textField_quitcourseID .getText().trim();
			course.setCourseID(quitcourseID);
			int typee=1;
			try {
				usrv.CourseCheck(owner, course,typee);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	contentPane.add(button_quitcourse);
	
	JButton button_checkchoosedcourse = new JButton("\u67E5\u770B\u5DF2\u9009\u8BFE\u7A0B");
	button_checkchoosedcourse.setBounds(33, 210, 163, 29);
	button_checkchoosedcourse.setForeground(new Color(0, 0, 0));
	button_checkchoosedcourse.setBackground(new Color(216, 191, 216));
	button_checkchoosedcourse.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			courseSCheck check=new courseSCheck(owner);
			check.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);;
			check.setVisible(true);
		}
	});
	contentPane.add(button_checkchoosedcourse);
	
	JLabel label_3 = new JLabel("\u6240\u6709\u8BFE\u7A0B\uFF1A");
	label_3.setBounds(33, 270, 112, 21);
	contentPane.add(label_3);
	
	table = new JTable();
	table.setBounds(215, 296, 1, 1);
	contentPane.add(table);
	
	JScrollPane scrollPane_allstudentcourse = new JScrollPane();
	scrollPane_allstudentcourse.setBounds(144, 261, 520, 169);
	contentPane.add(scrollPane_allstudentcourse);
	
	table_allstudentcourse = new JTable();
	table_allstudentcourse.setBackground(new Color(245, 245, 245));
	scrollPane_allstudentcourse.setViewportView(table_allstudentcourse);
	//tabledata=setTabledata( ccsList);
	table_allstudentcourse.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	
	table_allstudentcourse.setModel(new DefaultTableModel(
			tabledata,
		new String[] {
			"\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u4EFB\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65F6\u95F4"
		}
	));
	
	//table_allstudentcourse.getColumnModel().getColumn(1).setPreferredWidth(90);
	//table_allstudentcourse.getColumnModel().getColumn(2).setPreferredWidth(87);
	//table_allstudentcourse.getColumnModel().getColumn(3).setPreferredWidth(124);
	table_allstudentcourse.setRowHeight(30);
	
	JLabel lblId_ID = new JLabel("ID\uFF1A");
	lblId_ID.setBounds(392, 15, 81, 21);
	contentPane.add(lblId_ID);
	repaint();
	validate();
}

public void  refresh() {
	table_allstudentcourse.setModel(new DefaultTableModel(
			tabledata,
		new String[] {
			"\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u4EFB\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65F6\u95F4"
		}
	));
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