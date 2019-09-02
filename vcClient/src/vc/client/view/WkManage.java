package vc.client.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Goods;
import vc.list.common.Message;
import vc.list.common.User;

import javax.swing.JScrollPane;

public class WkManage extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8008253469114918090L;
	JFrame frame;
	private JTable table;

	private Goods gd;
	private UserSrvImpl usrv = new UserSrvImpl();
	private User owner;
	private List<Goods> gdlist;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { WkManage window = new WkManage();
	 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	 * } }); }
	 */

	/**
	 * Create the application.
	 */
	public WkManage(User user) {
		
		this.owner=user;
		
		WkManageMgr.add(user.getUserID(), this);  //放入这个gui的表集合里，相应消息时拿出来
		
		queryGoods();
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(WkManage.class.getResource("/image/logo.jpg")));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnManage = new JButton("\u67E5\u8BE2\u5546\u54C1");
		btnManage.setBounds(80, 400, 160, 50);
		btnManage.setFont(new Font("宋体", Font.PLAIN, 26));
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WkCheck wk_Check = new WkCheck(owner);
				wk_Check .setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnManage);
		
		JButton btnAdd = new JButton("\u589E\u52A0\u5546\u54C1");
		btnAdd.setBounds(320, 400, 160, 50);
		btnAdd.setFont(new Font("宋体", Font.PLAIN, 26));
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				WkCheck wk_Check = new WkCheck(owner);
				wk_Check.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				wk_Check .setVisible(true);
			}
			
		});
		
		JButton btnDelete = new JButton("\u5220\u9664\u5546\u54C1");
		btnDelete.setBounds(560, 400, 160, 50);
		btnDelete.setFont(new Font("宋体", Font.PLAIN, 26));
		frame.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 72, 640, 185);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 224));
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{gdlist.get(0).getGoodsID(), gdlist.get(0).getGoodsName(), gdlist.get(0).getGoodsPrice()},
	
			},
			new String[] {
				"\u5546\u54C1\u7801", "\u5546\u54C1", "\u4EF7\u683C"
			}
		));
		table.setRowHeight(30);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(),(100)));
	}
	
	
	public void refresh(List<Goods> gdlist) {
		
	}
	
	public void queryGoods() {
		
		Message msg = new Message();
		msg.setType("CMD_QUERY_GOODS");
		msg.setSender(owner);
		
		
		try {
			usrv.sendMessage(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Goods> getGdlist() {
		return gdlist;
	}

	public void setGdlist(List<Goods> gdlist) {
		this.gdlist = gdlist;
	}
	
	
	
}
