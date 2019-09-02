package vc.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.User;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private User owner; // 该界面的用户
	private UserSrvImpl us; // 用户服务对象
	
	

	/**
	 * Create the frame.
	 */
	public Menu(User user) {
		
		this.owner = user;
		
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u60A8\uFF0C");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(27, 22, 67, 23);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF08\u5F85\u8FD4\u56DE\uFF09");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(83, 23, 152, 23);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button.setBounds(560, 25, 97, 23);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u9000\u51FA\u767B\u5F55");
		btnNewButton.setBounds(676, 25, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5B66\u7C4D\u7BA1\u7406");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(1, 100, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u9009\u8BFE\u7CFB\u7EDF");
		btnNewButton_2.setBounds(1, 158, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u56FE\u4E66\u9986");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryReader_mainFrm
			}
		});
		btnNewButton_3.setBounds(1, 217, 97, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5546\u5E97");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WkManage wk_manage = new WkManage(owner);
				wk_manage.frame.setVisible(true);

			}
		});
		btnNewButton_4.setBounds(2, 276, 97, 23);
		contentPane.add(btnNewButton_4);
	}

}
