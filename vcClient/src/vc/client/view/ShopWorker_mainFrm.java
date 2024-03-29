package vc.client.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Message;
import vc.list.common.MessageType;
import vc.list.common.User;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ShopWorker_mainFrm extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6446703475391040662L;
	JFrame frame;
	private User owner;
	private UserSrvImpl usrv = new UserSrvImpl();

	/**
	 * Launch the application.
	 */
	
	  public static void main(String[] args) { EventQueue.invokeLater(new
	  Runnable() { public void run() { 
		  User u = new User();
		  try { ShopWorker_mainFrm window = new ShopWorker_mainFrm(u);
	  window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	  } }); }
	 

	/**
	 * Create the application.
	 */
	public ShopWorker_mainFrm(User user) {
		setResizable(false);
		this.owner = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ShopWorker_mainFrm.class.getResource("/image/logo.jpg")));
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u6765\u5230\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setBounds(170, 120, 460, 80);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 45));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnManage = new JButton("\u7BA1\u7406\u5546\u54C1");
		btnManage.setFont(new Font("����", Font.PLAIN, 26));
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				if(ShopWorker_manageMgr.get(owner.getUserID())!=null) {
					ShopWorker_manageMgr.get(owner.getUserID()).frame.setVisible(true);
				}else {
			ShopWorker_manageFrm wk_manage = new ShopWorker_manageFrm(owner);				
			wk_manage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			wk_manage.frame.setVisible(true);
				}
			}
		});
		btnManage.setBounds(140, 400, 160, 50);
		frame.getContentPane().add(btnManage);
		
		JButton deduct = new JButton("\u6263\u6B3E");
		deduct.setFont(new Font("����", Font.PLAIN, 26));
		deduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopWorker_deductFrm wk_deduct = new ShopWorker_deductFrm(owner);				
				wk_deduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				wk_deduct.setVisible(true);				
			}
		});
		
		deduct.setBounds(500, 400, 160, 50);
		frame.getContentPane().add(deduct);
		frame.setBounds(100, 100, 800, 600);

	}
}
