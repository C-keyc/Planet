package vc.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1062638932603106181L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(60, 100, 60, 20);
		label.setFont(new Font("黑体", Font.PLAIN, 14));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(60, 140, 60, 20);
		label_1.setFont(new Font("黑体", Font.PLAIN, 14));
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(130, 100, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 140, 180, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(this);
		
		/*
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSrvImpl us = new UserSrvImpl();

				
				String UserID = textField.getText().trim();
				String UserPass =textField_1.getText().trim();
				User user = new User(UserID,UserPass);
				User retUser = null;
				try {
					retUser = us.login(user);
					if (retUser != null) {
						System.out.println(user.getUname() + ":" + "验证成功");

						Menu menu =new Menu();
						menu.setVisible(true);
						// 同时关闭掉登陆界面
						this.setVisible(false);
					} else {				
						
						System.out.println("用户名或密码错误");
					}
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					//JOptionPane.showMessageDialog(this, "网络连接异常，请检查相关配置！", "警告",
							//JOptionPane.WARNING_MESSAGE);
				}
			}


		});
		*/
		button.setBounds(130, 180, 180, 20);
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u5FD8\u8BB0\u5BC6\u7801\uFF1F");
		btnNewButton.setBounds(266, 230, 110, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("picture");
		lblNewLabel.setBounds(0, 0, 400, 90);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UserSrvImpl us = new UserSrvImpl();

		
		String UserID = textField.getText().trim();
		String UserPass =textField_1.getText().trim();
		User user = new User(UserID,UserPass);
		User retUser = null;
		try {
			retUser = us.login(user);
			if (retUser != null) {
				System.out.println(user.getUname() + ":" + "验证成功");

				Menu menu =new Menu(retUser);
				menu.setVisible(true);
				// 同时关闭掉登陆界面
				this.dispose();;
			} else {				
				
				System.out.println("用户名或密码错误,请重新登录");
			}
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			//JOptionPane.showMessageDialog(this, "网络连接异常，请检查相关配置！", "警告",
					//JOptionPane.WARNING_MESSAGE);
		}
	}
}
