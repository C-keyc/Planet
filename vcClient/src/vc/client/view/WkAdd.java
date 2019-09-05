package vc.client.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Goods;
import vc.list.common.Message;
import vc.list.common.MessageType;
import vc.list.common.User;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class WkAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textItemId;
	private JTextField textItemName;
	private JTextField textPrice;

	/**
	 * Launch the application.
	 */
	private UserSrvImpl usrv = new UserSrvImpl();
	private User owner;
	private Goods gd=new Goods();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new User();
					WkAdd frame = new WkAdd(u);
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
	public WkAdd(User user) {
		setResizable(false);
		this.owner = user;
		
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		setIconImage(Toolkit.getDefaultToolkit().getImage(WkAdd.class.getResource("/image/logo.jpg")));
		
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemId = new JLabel("\u5546\u54C1\u7801\uFF1A");
		lblItemId.setFont(new Font("����", Font.PLAIN, 20));
		lblItemId.setBounds(100, 50, 80, 40);
		contentPane.add(lblItemId);
		
		JLabel lblItemName = new JLabel("\u5546\u54C1\u540D\uFF1A");
		lblItemName.setFont(new Font("����", Font.PLAIN, 20));
		lblItemName.setBounds(100, 130, 80, 40);
		contentPane.add(lblItemName);
		
		JLabel lblPrice = new JLabel("\u4EF7\u683C\uFF1A");
		lblPrice.setFont(new Font("����", Font.PLAIN, 20));
		lblPrice.setBounds(100, 210, 80, 40);
		contentPane.add(lblPrice);
		
		textItemId = new JTextField();
		textItemId.setBackground(new Color(255, 255, 240));
		textItemId.setBounds(200, 50, 160, 40);
		contentPane.add(textItemId);
		textItemId.setColumns(10);
		
		textItemName = new JTextField();
		textItemName.setColumns(10);
		textItemName.setBackground(new Color(255, 255, 240));
		textItemName.setBounds(200, 130, 160, 40);
		contentPane.add(textItemName);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBackground(new Color(255, 255, 240));
		textPrice.setBounds(200, 210, 160, 40);
		contentPane.add(textPrice);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.setFont(new Font("����", Font.PLAIN, 23));
		btnAdd.setBounds(200, 296, 80, 40);
		contentPane.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String id = textItemId.getText().trim();
				String  name = textItemName.getText().trim();
				String price = textPrice.getText().trim();
				double p = Double.parseDouble(price);
				
                gd.setGoodsID(id);
                gd.setGoodsName(name);
                gd.setGoodsPrice(p);
                try {
					Message m = new Message();
					m.setSender(owner);
					m.setGd(gd);
					m.setType(MessageType.CMD_ADD_GOODS);
					usrv.sendMessage(m);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                dispose();
			}
			
		});
	}
}
