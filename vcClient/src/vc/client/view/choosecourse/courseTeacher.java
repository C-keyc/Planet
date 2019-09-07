package vc.client.view.choosecourse;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


import vc.list.common.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class courseTeacher extends JFrame {

	private JPanel contentPane;
	private  User owner;
	public static JFrame frame;

	
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

	/**
	 * Create the frame.
	 */



	public courseTeacher(User user) {
		
		this.owner = user;
		setTitle("\u6B22\u8FCE\u6765\u5230\u9009\u8BFE\u7CFB\u7EDF");
		setBounds(100, 100, 699, 485);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_identity = new JLabel("\u767B\u9646\u8EAB\u4EFD\uFF1A");
		label_identity.setBounds(93, 52, 99, 21);
		contentPane.add(label_identity);
		
		JLabel lblId_ID = new JLabel("ID\uFF1A");
		lblId_ID.setBounds(462, 52, 81, 21);
		contentPane.add(lblId_ID);
		
		JLabel label_teacherIdentity = new JLabel("\u6559\u5E08");
		label_teacherIdentity.setBounds(190, 52, 81, 21);
		contentPane.add(label_teacherIdentity);
		
		JLabel label_IDnumber = new JLabel(owner.getUserID());
		label_IDnumber.setBounds(553, 52, 81, 21);
		contentPane.add(label_IDnumber);
		
		JButton button_addcourse = new JButton("\u6DFB\u52A0\u8BFE\u7A0B");
		button_addcourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseTADD add=new courseTADD(owner);
				add.setVisible(true);
				add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button_addcourse.setBounds(281, 145, 123, 29);
		contentPane.add(button_addcourse);
		
		JButton btnNewButton_deletecourse = new JButton("\u53D6\u6D88\u8BFE\u7A0B");
		btnNewButton_deletecourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseTDELETE delete=new courseTDELETE(owner);
				delete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				delete.setVisible(true);
			}
		});
		btnNewButton_deletecourse.setBounds(281, 227, 123, 29);
		contentPane.add(btnNewButton_deletecourse);
		
		JButton btnNewButton_checkteachercourse = new JButton("\u67E5\u770B\u6211\u7684\u8BFE\u7A0B");
		btnNewButton_checkteachercourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseTCheck check=new courseTCheck(owner);
				check.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				check.setVisible(true);
			}
		});
		btnNewButton_checkteachercourse.setBounds(238, 333, 225, 29);
		contentPane.add(btnNewButton_checkteachercourse);
	}
}
