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

public class courseTADD extends JFrame {

	private JPanel contentPane;
	private JTextField textField_courseID;
	private JTextField textField_coursename;
	private JTextField textField_courseteacher;
	private JTextField textField_coursetime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseTADD frame = new courseTADD();
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
	public courseTADD() {
		setTitle("\u6DFB\u52A0\u6211\u7684\u6388\u8BFE\u8BFE\u7A0B");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("\u8BFE\u7A0BID");
		lblid.setBounds(52, 28, 81, 21);
		contentPane.add(lblid);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u540D\u79F0");
		label.setBounds(52, 80, 81, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4EFB\u8BFE\u6559\u5E08");
		label_1.setBounds(52, 128, 81, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u4E0A\u8BFE\u65F6\u95F4");
		label_2.setBounds(52, 183, 81, 21);
		contentPane.add(label_2);
		
		textField_courseID = new JTextField();
		textField_courseID.setBounds(208, 25, 96, 27);
		contentPane.add(textField_courseID);
		textField_courseID.setColumns(10);
		
		textField_coursename = new JTextField();
		textField_coursename.setBounds(208, 77, 96, 27);
		contentPane.add(textField_coursename);
		textField_coursename.setColumns(10);
		
		textField_courseteacher = new JTextField();
		textField_courseteacher.setBounds(208, 125, 96, 27);
		contentPane.add(textField_courseteacher);
		textField_courseteacher.setColumns(10);
		
		textField_coursetime = new JTextField();
		textField_coursetime.setBounds(208, 180, 96, 27);
		contentPane.add(textField_coursetime);
		textField_coursetime.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0\u8BFE\u7A0B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//与数据库连接，把添加的课程更新进去
				courseSOK ok=new courseSOK();
				ok.setVisible(true);
				dispose();
			}
		});
		button.setBounds(301, 286, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(439, 286, 123, 29);
		contentPane.add(button_1);
	}

}
