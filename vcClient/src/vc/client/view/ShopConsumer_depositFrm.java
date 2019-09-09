package vc.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Message;
import vc.list.common.MessageType;
import vc.list.common.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ShopConsumer_depositFrm extends JFrame {
	private JTextField depositmoney;


	/**
	 * Launch the application.
	 */
	
	private User owner;
	private UserSrvImpl usrv = new UserSrvImpl();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new User();
					ShopConsumer_depositFrm frame = new ShopConsumer_depositFrm(u);
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
	public ShopConsumer_depositFrm(User user) {
		setResizable(false);
		this.owner = user;
		
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setLayout(null);
		
		JLabel title = new JLabel("\u6821\u56ED\u5361\u5145\u503C");
		title.setForeground(new Color(250, 128, 114));
		title.setBackground(new Color(250, 128, 114));
		title.setFont(new Font("楷体", Font.PLAIN, 33));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(20, 30, 326, 45);
		getContentPane().add(title);
		
		JLabel name1 = new JLabel("姓  名：");
		name1.setFont(new Font("楷体", Font.BOLD, 18));
		name1.setBounds(10, 80, 85, 30);
		getContentPane().add(name1);
		
		JLabel ecard = new JLabel("一卡通：");
		ecard.setFont(new Font("楷体", Font.BOLD, 18));
		ecard.setBounds(10, 115, 85, 30);
		getContentPane().add(ecard);
		
		
		  JLabel count = new JLabel("账户余额："); count.setFont(new Font("楷体", Font.BOLD,
		  18)); count.setBounds(10, 150, 113, 30); getContentPane().add(count);
		 
		
		JLabel demon = new JLabel("充值金额：");
		demon.setFont(new Font("楷体", Font.BOLD, 18));
		demon.setBounds(10, 185, 113, 30);
		getContentPane().add(demon);
		
		depositmoney = new JTextField();
		depositmoney.setBounds(150, 185, 113, 30);
		getContentPane().add(depositmoney);
		depositmoney.setColumns(10);
		
		JLabel name = new JLabel(owner.getUname());
		name.setBounds(150, 80, 113, 30);
		getContentPane().add(name);
		
		JLabel eID = new JLabel(owner.getUserID());
		eID.setBounds(150, 115, 113, 30);
		getContentPane().add(eID);
		
		
		  JLabel remaining = new JLabel(""+owner.getAccount());
		  remaining.setBounds(150, 150, 113, 30); getContentPane().add(remaining);
		 
		
		JButton Deps = new JButton("\u5145\u503C");
		Deps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String add = depositmoney.getText().trim();
				if(add.length()<1)
					JOptionPane.showMessageDialog(null, "请输入充值金额", "充值",JOptionPane.ERROR_MESSAGE);
				else {
				double Add = Double.parseDouble(add);
				if(Add<=0)
					JOptionPane.showMessageDialog(null, "请输入合法充值金额", "充值",JOptionPane.ERROR_MESSAGE);
				else {
				double account = Add + owner.getAccount();
				owner.setAccount(account);
				
				remaining.setText(""+account);
				
				Message m = new Message();
				m.setType(MessageType.CMD_DEPOSIT);
				m.setSender(owner);
				try {
					usrv.sendMessage(m);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}    }
				}
			}
		});
		
		Deps.setBackground(new Color(176, 196, 222));
		Deps.setForeground(new Color(0, 0, 128));
		Deps.setFont(new Font("宋体", Font.PLAIN, 28));
		Deps.setBounds(127, 243, 105, 45);
		getContentPane().add(Deps);
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopConsumer_depositFrm.class.getResource("/image/logo.jpg")));
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 342);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 获取当前屏幕大小
		Dimension frameSize = this.getSize();// 获取当前窗口大小
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);// 保持窗口弹出位置居中
	}
}
