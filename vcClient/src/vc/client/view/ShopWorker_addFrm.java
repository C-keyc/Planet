package vc.client.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.GdlistMgr;
import vc.list.common.Goods;
import vc.list.common.Message;
import vc.list.common.MessageType;
import vc.list.common.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

public class ShopWorker_addFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textItemId;
	private JTextField textItemName;
	private JTextField textPrice;
    private List<Goods> gdlist;
	private static Map<String, Goods> GdlistPool_name = new HashMap<String, Goods>();
	/**
	 * Launch the application.
	 */
	private UserSrvImpl usrv = new UserSrvImpl();
	private User owner;
	private Goods gd=new Goods();
	private JLabel label;
	private JTextField InNum;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new User();
					List<Goods> gdlist = new ArrayList<Goods>();
					ShopWorker_addFrm frame = new ShopWorker_addFrm(u,gdlist);
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
	public ShopWorker_addFrm(User user,List<Goods> gdlist) {
		
		setResizable(false);
		this.owner = user;
		this.gdlist=gdlist;		
		addtoMap();
		addtoMap_name();
		
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopWorker_addFrm.class.getResource("/image/logo.jpg")));
		
		setBounds(100, 100, 500, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemId = new JLabel("\u5546\u54C1\u7801\uFF1A");
		lblItemId.setFont(new Font("宋体", Font.PLAIN, 20));
		lblItemId.setBounds(100, 50, 80, 40);
		contentPane.add(lblItemId);
		
		JLabel lblItemName = new JLabel("\u5546\u54C1\u540D\uFF1A");
		lblItemName.setFont(new Font("宋体", Font.PLAIN, 20));
		lblItemName.setBounds(100, 130, 80, 40);
		contentPane.add(lblItemName);
		
		JLabel lblPrice = new JLabel("\u4EF7\u683C\uFF1A");
		lblPrice.setFont(new Font("宋体", Font.PLAIN, 20));
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
		btnAdd.setFont(new Font("宋体", Font.PLAIN, 23));
		btnAdd.setBounds(200, 354, 80, 40);
		contentPane.add(btnAdd);
		
		label = new JLabel("\u8FDB\u8D27\u6570\u91CF\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(100, 288, 100, 40);
		contentPane.add(label);
		
		InNum = new JTextField();
		InNum.setColumns(10);
		InNum.setBackground(new Color(255, 255, 240));
		InNum.setBounds(200, 288, 160, 40);
		contentPane.add(InNum);
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String id = textItemId.getText().trim();
				String  name = textItemName.getText().trim();
				String price = textPrice.getText().trim();
				String repe = InNum.getText().trim();
				

				
								
				if(id.length()<1|name.length()<1|price.length()<1|repe.length()<1) {
					JOptionPane.showMessageDialog(null, "请将货物信息补充完整！", "进货", JOptionPane.WARNING_MESSAGE);
				}else if(Integer.parseInt(repe)<=0)
					JOptionPane.showMessageDialog(null, "请输入正确数量的货物！", "进货", JOptionPane.WARNING_MESSAGE);
				else if(GdlistMgr.get(id)!=null) {
					Goods gd1 = GdlistMgr.get(id);
					if(gd1.getGoodsName().equals(name)) {
						if(gd1.getGoodsPrice()==Double.parseDouble(price)) {
			                try {
			    				double p = Double.parseDouble(price);
			    				int r = Integer.parseInt(repe);
			                    gd.setGoodsID(id);
			                    gd.setGoodsName(name);
			                    gd.setGoodsPrice(p);
			                    gd.setRepertory(r);
			    				Message m = new Message();
			    				m.setSender(owner);
			    				m.setGd(gd);
			    				m.setType(MessageType.CMD_ADD_GOODS);
			                	m.setOpState(true); //true 表示已经有此货物
								usrv.sendMessage(m);
								dispose();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(null, "请保持货物价格一致！", "进货", JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "新增货物与库存货物编码重复！", "进货", JOptionPane.WARNING_MESSAGE);
					}
				}else if(GdlistPool_name.get(name)!=null) {
					JOptionPane.showMessageDialog(null, "请勿重复给库存货物编码！", "进货", JOptionPane.WARNING_MESSAGE);
				}
				else {		
                try {
    				double p = Double.parseDouble(price);
    				int r = Integer.parseInt(repe);
                    gd.setGoodsID(id);
                    gd.setGoodsName(name);
                    gd.setGoodsPrice(p);
                    gd.setRepertory(r);
    				Message m = new Message();
    				m.setSender(owner);
    				m.setGd(gd);
    				m.setType(MessageType.CMD_ADD_GOODS);
                	m.setOpState(false);//没有此货物
					usrv.sendMessage(m);
					dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}               
                dispose();	}
			}			
		});
	}
	public void addtoMap() {
		for(int i=0;i<gdlist.size();i++)
			GdlistMgr.add(gdlist.get(i).getGoodsID(), gdlist.get(i));
	}
	public void addtoMap_name() {
		for(int i=0;i<gdlist.size();i++)
			GdlistPool_name.put(gdlist.get(i).getGoodsName(), gdlist.get(i));
	}
}
