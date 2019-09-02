package vc.client.view.choosecourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

	/**
	 * Create the frame.
	 */
	public courseStudent(User user) {
		
		this.owner = user;
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(courseStudent.class.getResource("/image/logo.jpg")));
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u9009\u8BFE\u7CFB\u7EDF");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u767B\u9646\u8EAB\u4EFD\uFF1A");
		label.setBounds(33, 15, 95, 21);
		contentPane.add(label);
		
		//把姓名和ID覆盖掉
		JLabel label_studentidentity = new JLabel("\u5B66\u751F");
		label_studentidentity.setBounds(131, 15, 81, 21);
		contentPane.add(label_studentidentity);
		
		JLabel label_number = new JLabel("\u6570\u5B57");
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
		button_choosecourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		  //调用数据库来判断输入的课程ID是否正确，根据输入的正确与否来弹出不同的对话框
				courseSOK ok=new courseSOK();
				ok.setVisible(true);
				//	choosecourseNOT not=new choosecourseNOT();
				//   not.setVisible(true);
			}
		});
		button_choosecourse.setBounds(392, 80, 123, 29);
		contentPane.add(button_choosecourse);
		
		JButton button_quitcourse = new JButton("\u9000\u8BFE");
		button_quitcourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//调用数据库来判断输入的课程ID是否正确，根据输入的正确与否来弹出不同的对话框
				courseSOK ok=new courseSOK();
				ok.setVisible(true);
				//	choosecourseNOT not=new choosecourseNOT();
				//   not.setVisible(true);
			}
		});
		button_quitcourse.setBounds(392, 144, 123, 29);
		contentPane.add(button_quitcourse);
		
		JButton button_checkchoosedcourse = new JButton("\u67E5\u770B\u5DF2\u9009\u8BFE\u7A0B");
		button_checkchoosedcourse.setForeground(new Color(0, 0, 0));
		button_checkchoosedcourse.setBackground(new Color(216, 191, 216));
		button_checkchoosedcourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				courseSCheck check=new courseSCheck();
				check.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				check.setVisible(true);
			}
		});
		button_checkchoosedcourse.setBounds(250, 206, 163, 29);
		contentPane.add(button_checkchoosedcourse);
		
		JLabel label_3 = new JLabel("\u6240\u6709\u8BFE\u7A0B\uFF1A");
		label_3.setBounds(33, 270, 112, 21);
		contentPane.add(label_3);
		
		table = new JTable();
		table.setBounds(215, 296, 1, 1);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 261, 423, 112);
		contentPane.add(scrollPane);
		
		table_allstudentcourse = new JTable();
		table_allstudentcourse.setBackground(new Color(245, 245, 245));
		scrollPane.setViewportView(table_allstudentcourse);
		table_allstudentcourse.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table_allstudentcourse.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "\u4F53\u80B2", "\u9648\u5A07", "\u5468\u4E09\u4E0B\u5348\u4E09\u70B9"},
				{"2", "\u8F6F\u4EF6\u5B9E\u8DF5", "\u6C88\u50B2\u4E1C", "\u5468\u4E00\u4E0A\u5348\u516B\u70B9"},
				{"3", "\u8BA1\u7EC4\u5B9E\u9A8C", "\u4EFB\u56FD\u6797", "\u5468\u4E8C\u4E0B\u5348\u4E09\u70B9"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u4EFB\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65F6\u95F4"
			}
		));
		table_allstudentcourse.getColumnModel().getColumn(1).setPreferredWidth(90);
		table_allstudentcourse.getColumnModel().getColumn(2).setPreferredWidth(87);
		table_allstudentcourse.getColumnModel().getColumn(3).setPreferredWidth(124);
		table_allstudentcourse.setRowHeight(30);
		
		JLabel lblId_ID = new JLabel("ID\uFF1A");
		lblId_ID.setBounds(392, 15, 81, 21);
		contentPane.add(lblId_ID);
	}
}
