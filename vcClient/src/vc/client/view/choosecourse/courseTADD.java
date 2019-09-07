package vc.client.view.choosecourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.client.view.WkManageMgr;
import vc.list.common.Course;
import vc.list.common.Message;
import vc.list.common.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class courseTADD extends JFrame {

	private JPanel contentPane;
	private JTextField textField_courseID;
	private JTextField textField_coursename;
	private JTextField textField_courseteacher;
	private JTextField textField_coursetime;
	private  User owner;
	private UserSrvImpl usrv = new UserSrvImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new User();
					courseTADD frame = new courseTADD(u);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
public courseTADD(User user) {
		
		this.owner=user;
		
		initialize();
		
	}

	private void initialize() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u6DFB\u52A0\u6211\u7684\u6388\u8BFE\u8BFE\u7A0B");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid_courseID = new JLabel("\u8BFE\u7A0BID");
		lblid_courseID.setBounds(52, 28, 81, 21);
		contentPane.add(lblid_courseID);
		
		JLabel label_coursename = new JLabel("\u8BFE\u7A0B\u540D\u79F0");
		label_coursename.setBounds(52, 80, 81, 21);
		contentPane.add(label_coursename);
		
		JLabel label_courseteacher = new JLabel("\u4EFB\u8BFE\u6559\u5E08");
		label_courseteacher.setBounds(52, 128, 81, 21);
		contentPane.add(label_courseteacher);
		
		JLabel label_coursetime = new JLabel("\u4E0A\u8BFE\u65F6\u95F4");
		label_coursetime.setBounds(52, 183, 81, 21);
		contentPane.add(label_coursetime);
		
		textField_courseID = new JTextField();
		textField_courseID.setBounds(208, 25, 296, 27);
		contentPane.add(textField_courseID);
		textField_courseID.setColumns(10);
		
		textField_coursename = new JTextField();
		textField_coursename.setBounds(208, 77, 296, 27);
		contentPane.add(textField_coursename);
		textField_coursename.setColumns(10);
		
		textField_courseteacher = new JTextField();
		textField_courseteacher.setBounds(208, 125, 296, 27);
		contentPane.add(textField_courseteacher);
		textField_courseteacher.setColumns(10);
		
		textField_coursetime = new JTextField();
		textField_coursetime.setBounds(208, 180, 296, 27);
		contentPane.add(textField_coursetime);
		textField_coursetime.setColumns(10);
		
		JButton button_addcourse = new JButton("\u6DFB\u52A0\u8BFE\u7A0B");
		button_addcourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course mycourse = new Course();
				mycourse.setCourseID(textField_courseID.getText());
				mycourse.setCourseName(textField_coursename.getText());
				mycourse.setCourseTeacher(textField_courseteacher.getText());
				mycourse.setCourseTime(textField_coursetime.getText());
				Message msg = new Message();
				msg.setCourse(mycourse);
				try {
					usrv.CourseADD(owner, mycourse);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//JOptionPane.showMessageDialog(contentPane, "添加成功.", "添加结果",JOptionPane.PLAIN_MESSAGE); 
			}
		});
		button_addcourse.setBounds(301, 286, 123, 29);
		contentPane.add(button_addcourse);
		
		JButton button_quit = new JButton("\u9000\u51FA");
		button_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_quit.setBounds(439, 286, 123, 29);
		contentPane.add(button_quit);
	}

}
