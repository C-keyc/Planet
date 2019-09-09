package vc.client.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import vc.list.common.MessageType;
import vc.list.common.User;

import javax.swing.JScrollPane;

public class ShopWorker_manageFrm extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8008253469114918090L;
	JFrame frame;
	private JTable table;

	private Goods gd;
	private UserSrvImpl usrv = new UserSrvImpl();
	private User owner;
	private List<Goods> gdlist=null;
	private Object[][] data;
	/**
	 * Launch the application.
	 */
	
	  public static void main(String[] args) { 
		  EventQueue.invokeLater(new
	  Runnable() { public void run() { 
		  try { 
			  User u = new User();
			  ShopWorker_manageFrm window = new ShopWorker_manageFrm(u);
	  window.frame.setVisible(true);
	  } catch (Exception e) { e.printStackTrace(); }
	  } }); }
	 

	/**
	 * Create the application.
	 */
	public ShopWorker_manageFrm(User user) {
		setResizable(false);
		this.owner=user;		
		ShopWorker_manageMgr.add(user.getUserID(), this);  //放入这个gui的表集合里，相应消息时拿出来
		initialize();
		queryGoods();

	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
	
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ShopWorker_manageFrm.class.getResource("/image/logo.jpg")));
		frame.setBounds(100, 100, 800, 600);		
		
		JButton btnManage = new JButton("\u67E5\u8BE2\u5546\u54C1");
		btnManage.setBounds(87, 400, 160, 50);
		btnManage.setFont(new Font("宋体", Font.PLAIN, 26));
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopWorker_searchFrm wk_Check = new ShopWorker_searchFrm(owner);
				wk_Check .setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnManage);
		
		JButton btnAdd = new JButton("\u589E\u52A0\u5546\u54C1");
		btnAdd.setBounds(322, 400, 160, 50);
		btnAdd.setFont(new Font("宋体", Font.PLAIN, 26));
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ShopWorker_addFrm wk_Add = new ShopWorker_addFrm(owner,gdlist);
				wk_Add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				wk_Add.setVisible(true);
			}
			
		});
		
		JButton btnDelete = new JButton("\u5220\u9664\u5546\u54C1");
		btnDelete.setBounds(560, 400, 160, 50);
		btnDelete.setFont(new Font("宋体", Font.PLAIN, 26));
		frame.getContentPane().add(btnDelete);
		
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int row = table.getSelectedRow();
			
				if (row != -1) {
					String id = data[row][0].toString();	
					Goods gd = new Goods();
					gd.setGoodsID(id);
					Message m = new Message();
					m.setSender(owner);
					m.setGd(gd);
					m.setType(MessageType.CMD_DELETE_GOODS);
					try {
						usrv.sendMessage(m);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "请选择一行数据", "删除结果", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 72, 640, 185);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 224));
		scrollPane.setViewportView(table);
		
		
		//初始化列表里的二维数组
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"\u5546\u54C1\u7801", "\u5546\u54C1", "\u4EF7\u683C", "\u5E93\u5B58"
			}
		)	);
		table.setRowHeight(30);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(),(30)));
		
	}
	
	public Object[][] getTableData(List<Goods> gdlist){
		int GdNum = gdlist.size();
		Object[][] data= new Object[GdNum][4];
		for(int i =0;i<GdNum;i++) 
		{
			for(int j=0;j<4;j++ ) 
			{
				switch(j)
				{
					case 0:
						data[i][j]=gdlist.get(i).getGoodsID();
						break;
					case 1:
						data[i][j]=gdlist.get(i).getGoodsName();
						break;
					case 2:
						data[i][j]=gdlist.get(i).getGoodsPrice();
						break;
					case 3:
						data[i][j]=gdlist.get(i).getRepertory();
						break;
				}
			}
		}
		return data;
		}
	
	public void refresh() {
		data = this.getTableData(gdlist);
		table.setModel(new DefaultTableModel(
				data,
				new String[] {
						"\u5546\u54C1\u7801", "\u5546\u54C1", "\u4EF7\u683C", "\u5E93\u5B58"
				}
			));
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
