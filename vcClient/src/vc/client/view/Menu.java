package vc.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.client.view.library.LibraryReader_checkrecordFrm;
import vc.client.view.library.LibraryReader_mainFrm;


import vc.client.view.message.MessageRoll_mainFrm;
import vc.client.view.choosecourse.courseStudent;
import vc.client.view.choosecourse.courseTeacher;
import vc.client.view.library.LibraryReader_mainFrm;
import vc.client.view.library.LibraryWorker_manageFrm;
//github.com/C-keyc/Planet.git

import vc.list.common.User;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private User owner; // 该界面的用户
	private UserSrvImpl us=new UserSrvImpl(); // 用户服务对象
	
	

	/**
	 * Create the frame.
	 */
	public Menu(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/image/logo.jpg")));
		setResizable(false);
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
		
		JLabel lblWelcome = new JLabel("\u6B22\u8FCE\u60A8\uFF0C");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("宋体", Font.PLAIN, 16));
		lblWelcome.setBounds(30, 20, 70, 30);
		contentPane.add(lblWelcome);
		
		JLabel lblName = new JLabel(owner.getUname());
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("宋体", Font.PLAIN, 16));
		lblName.setBounds(100, 20, 100, 30);
		contentPane.add(lblName);
		
		JLabel lblIdentity = new JLabel("\u8EAB\u4EFD\uFF1A");
		lblIdentity.setForeground(Color.WHITE);
		lblIdentity.setFont(new Font("宋体", Font.PLAIN, 16));
		lblIdentity.setBounds(200, 20, 50, 30);
		contentPane.add(lblIdentity);
		
		JLabel lblIdentityXX = new JLabel(getIdentity(owner.getType()));
		lblIdentityXX.setForeground(Color.WHITE);
		lblIdentityXX.setFont(new Font("宋体", Font.PLAIN, 16));
		lblIdentityXX.setBounds(250, 20, 50, 30);
		contentPane.add(lblIdentityXX);
		
		
		JButton btnChangePassword = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btnChangePassword.setBounds(560, 25, 97, 23);
		contentPane.add(btnChangePassword);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Changepassword changepassword = new Changepassword(owner);
				changepassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				changepassword.setVisible(true);
			}
		});
		
		JButton btnExit = new JButton("\u9000\u51FA\u767B\u5F55");
		btnExit.setBounds(676, 25, 97, 23);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				us.logout(owner);
				dispose();
			}
		});
		JButton btnMessageRoll = new JButton("\u5B66\u7C4D\u7BA1\u7406");
		btnMessageRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMessageRoll.setBounds(56, 125, 90, 30);
		contentPane.add(btnMessageRoll);
		btnMessageRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageRoll_mainFrm messageRoll = new MessageRoll_mainFrm(owner);
				messageRoll.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

			}
		});
		
		
		JButton btnChooseCourse = new JButton("\u9009\u8BFE\u7CFB\u7EDF");
		btnChooseCourse.setBounds(615, 153, 90, 30);
		contentPane.add(btnChooseCourse);
		btnChooseCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(owner.getType()==1) {
					courseStudent courseS = new courseStudent(owner);
					//courseS.setVisible(true);
				}else {
					courseTeacher frame = new courseTeacher(owner);
					//frame.setVisible(true);
				}

			}
		});
		
		JButton btnLibrary = new JButton("\u56FE\u4E66\u9986");
		btnLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(owner.getType()==1||owner.getType()==2) {
						LibraryReader_checkrecordFrm windowc=new LibraryReader_checkrecordFrm(owner);
						windowc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				}else {
					LibraryWorker_manageFrm libraryWorker = new LibraryWorker_manageFrm(owner);
					libraryWorker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
				}
			}
		});
		btnLibrary.setBounds(116, 413, 90, 30);
		contentPane.add(btnLibrary);
		
		
		JButton btnShop = new JButton("\u5546\u5E97");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(owner.getType()==1|owner.getType()==2) {
					ShopConsumer_welcomeFrm Consumer = new ShopConsumer_welcomeFrm(owner);
					Consumer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Consumer.setVisible(true);
				}else {
					ShopWorker_mainFrm manager = new ShopWorker_mainFrm(owner);
					manager.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					manager.frame.setVisible(true);
				}

			}
		});
		btnShop.setBounds(555, 473, 90, 30);
		contentPane.add(btnShop);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setBackground(Color.LIGHT_GRAY);
		lblBackground.setIcon(new ImageIcon(Menu.class.getResource("/image/MuneBG.jpg")));
		lblBackground.setBounds(0, 0, 800, 600);
		contentPane.add(lblBackground);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 获取当前屏幕大小
		Dimension frameSize = this.getSize();// 获取当前窗口大小
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);// 保持窗口弹出位置居中
	}
	
	public String getIdentity(int type) {
		switch(type) {
		case 1:
			return "学生";
		case 2:
			return "教师";
		case 3:
			return "管理员";
		}
		return null;
	}
}
