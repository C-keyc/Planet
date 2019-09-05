package vc.client.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Goods;
import vc.list.common.User;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class WkCheck extends JFrame {

	private JPanel contentPane;
	private JTextField textItemId;

	private UserSrvImpl usrv = new UserSrvImpl();
	private Goods gd = new Goods();
	private User owner;
	
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { WkCheck frame = new WkCheck();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public WkCheck(User user) {
		setResizable(false);
		this.owner=user;
		
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		setIconImage(Toolkit.getDefaultToolkit().getImage(WkCheck.class.getResource("/image/logo.jpg")));
		
		setBounds(100, 100, 390, 264);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemId = new JLabel("\u5546\u54C1\u7801\uFF1A");
		lblItemId.setBackground(new Color(255, 255, 240));
		lblItemId.setBounds(32, 32, 116, 48);
		lblItemId.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		contentPane.add(lblItemId);
		
		textItemId = new JTextField();
		textItemId.setBackground(new Color(255, 255, 240));
		textItemId.setBounds(107, 32, 215, 46);
		contentPane.add(textItemId);
		textItemId.setColumns(10);
		
		JButton btnCheck = new JButton("\u67E5\u8BE2");
		btnCheck.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		btnCheck.setBounds(140, 150, 80, 44);
		contentPane.add(btnCheck);
		

		
		btnCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String id = textItemId.getText().trim();
                gd.setGoodsID(id);
                try {
					usrv.ShopCheck(owner, gd);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                dispose();
			}
			
		});
	}
}
