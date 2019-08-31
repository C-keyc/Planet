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

public class courseTDELETE extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseTDELETE frame = new courseTDELETE();
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
	public courseTDELETE() {
		setTitle("\u53D6\u6D88\u6211\u7684\u6388\u8BFE\u8BFE\u7A0B");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("\u8BFE\u7A0BID");
		lblid.setBounds(38, 53, 81, 21);
		contentPane.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(121, 50, 96, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u53D6\u6D88\u6388\u8BFE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 取消的课程ID与数据库连接,进行更新
				//如果课程ID有误，则报错，not
				courseSOK ok=new courseSOK();
				ok.setVisible(true);
				dispose();
			}
		});
		button.setBounds(141, 187, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(278, 187, 123, 29);
		contentPane.add(button_1);
	}
}
