package vc.client.view.choosecourse;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Course;
import vc.list.common.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;

public class courseTCheck extends JFrame {

	private JPanel contentPane;
	private JTable table_checkteachercourse;
	private JScrollPane scrollPane_checkteachercourse;
	private UserSrvImpl usrv = new UserSrvImpl();
	private static List<Course> ccsListt;
	private User owner;
	public static JFrame frame;
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
//		frame=new JFrame();
		setTitle("快乐星球虚拟校园查看我的授课课程");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 733, 477);
		setFont(new Font("仿宋", Font.PLAIN, 18));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		scrollPane_checkteachercourse = new JScrollPane();
		scrollPane_checkteachercourse.setBounds(15, 31, 681, 273);
		contentPane.add(scrollPane_checkteachercourse);
		
		table_checkteachercourse = new JTable();
		table_checkteachercourse.setFont(new Font("楷体", Font.PLAIN, 20));
		tabledata=setTabledata( ccsListt);
		scrollPane_checkteachercourse.setViewportView(table_checkteachercourse);
		table_checkteachercourse.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_checkteachercourse.setModel(new DefaultTableModel(
				tabledata,
			new String[] {
				"\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u4EFB\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65F6\u95F4"
			}
		));
//		table_checkteachercourse.getColumnModel().getColumn(1).setPreferredWidth(91);
//		table_checkteachercourse.getColumnModel().getColumn(2).setPreferredWidth(92);
//		table_checkteachercourse.getColumnModel().getColumn(3).setPreferredWidth(88);
		table_checkteachercourse.setRowHeight(30);
		
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
