package vc.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.User;

import java.awt.Color;
import java.awt.Dimension;

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
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1062638932603106181L;
	private JPanel contentPane;
	private JTextField textId;
	private JPasswordField passwordField;

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
		setResizable(false);
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
		
		JLabel lblId = new JLabel("");
		lblId.setIcon(new ImageIcon(Login.class.getResource("/image/ID.png")));
		lblId.setBounds(100, 100, 20, 20);
		lblId.setFont(new Font("幼圆", Font.BOLD, 16));
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setIcon(new ImageIcon(Login.class.getResource("/image/Password.png")));
		lblPassword.setBounds(100, 140, 20, 20);
		lblPassword.setFont(new Font("幼圆", Font.BOLD, 16));
		contentPane.add(lblPassword);
		
		textId = new JTextField();
		textId.setBounds(130, 100, 180, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JButton btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addActionListener(this);
		this.getRootPane().setDefaultButton(btnLogin);
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(130, 140, 180, 20);
		contentPane.add(passwordField);
		
		JLabel lblBackground = new JLabel("picture");
		lblBackground.setIcon(new ImageIcon(Login.class.getResource("/image/LoginBG.jpg")));
		lblBackground.setBounds(-189, 0, 642, 373);
		contentPane.add(lblBackground);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 获取当前屏幕大小
		Dimension frameSize = this.getSize();// 获取当前窗口大小
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);// 保持窗口弹出位置居中
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UserSrvImpl us = new UserSrvImpl();

		
		String UserID = textId.getText().trim();
		String UserPass =passwordField.getText().trim();
		User user = new User(UserID,UserPass);
		User retUser = null;
		try {
			retUser = us.login(user);
			if (retUser != null) {
				System.out.println(user.getUname() + ":" + "验证成功");

				Menu menu =new Menu(retUser);
				menu.setVisible(true);
				// 同时关闭掉登陆界面
				this.dispose();
			} else {				
				JOptionPane.showMessageDialog(this, "用户名或密码错误", "警告",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "网络连接异常，请检查相关配置！", "警告",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
