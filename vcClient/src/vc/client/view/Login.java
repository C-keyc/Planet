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
import javax.swing.ImageIcon;

public class Login extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1062638932603106181L;
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textPassword;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/image/logo.jpg")));
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblId.setBounds(62, 100, 70, 20);
		lblId.setFont(new Font("幼圆", Font.BOLD, 16));
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("\u5BC6\u7801\uFF1A");
		lblPassword.setBounds(77, 139, 60, 20);
		lblPassword.setFont(new Font("幼圆", Font.BOLD, 16));
		contentPane.add(lblPassword);
		
		textId = new JTextField();
		textId.setBounds(130, 100, 180, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(130, 140, 180, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JButton btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addActionListener(this);
		
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
		btnLogin.setBounds(130, 180, 180, 20);
		btnLogin.setFont(new Font("黑体", Font.PLAIN, 15));
		contentPane.add(btnLogin);
		
		JButton btnForget = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		btnForget.setFont(new Font("黑体", Font.PLAIN, 12));
		btnForget.setBounds(289, 230, 87, 23);
		btnForget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnForget);
		
		JLabel lblBackground = new JLabel("picture");
		lblBackground.setIcon(new ImageIcon(Login.class.getResource("/image/LoginBG.jpg")));
		lblBackground.setBounds(-189, 0, 642, 373);
		contentPane.add(lblBackground);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UserSrvImpl us = new UserSrvImpl();

		
		String UserID = textId.getText().trim();
		String UserPass =textPassword.getText().trim();
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
