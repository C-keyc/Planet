package vc.client.view.choosecourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Course;
import vc.list.common.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class courseTDELETE extends JFrame {

	private JPanel contentPane;
	private JTextField textField_courseID;
	private Course course=new Course();
	private UserSrvImpl usrv = new UserSrvImpl();
	private User owner;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new User();
					courseTDELETE frame = new courseTDELETE(u);
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
	
public courseTDELETE(User user) {
		
		this.owner=user;
		
		initialize();
		
	}

	
private void initialize() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u53D6\u6D88\u6211\u7684\u6388\u8BFE\u8BFE\u7A0B");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid_courseID = new JLabel("\u8BFE\u7A0BID");
		lblid_courseID.setBounds(38, 53, 81, 21);
		contentPane.add(lblid_courseID);
		
		textField_courseID = new JTextField();
		textField_courseID.setBounds(121, 50, 229, 27);
		contentPane.add(textField_courseID);
		textField_courseID.setColumns(10);
		
		JButton button_deletecourse = new JButton("\u53D6\u6D88\u6388\u8BFE");
		button_deletecourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String  deletecourseID = textField_courseID .getText().trim();
				course.setCourseID(deletecourseID);
				int typee=2;
				try {
					usrv.CourseCheck(owner, course,typee);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_deletecourse.setBounds(141, 187, 123, 29);
		contentPane.add(button_deletecourse);
		
		JButton button_quit = new JButton("\u9000\u51FA");
		button_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_quit.setBounds(278, 187, 123, 29);
		contentPane.add(button_quit);
	}
}
