package vc.client.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Goods;
import vc.list.common.Message;
import vc.list.common.MessageType;
import vc.list.common.User;

public class ShopWorker_scanFrm extends JFrame {
	private JPanel contentPane;
	private JTextField textItemId;

	private UserSrvImpl usrv = new UserSrvImpl();
	private Goods gd = new Goods();
	private User owner;
	private JTextField GoodsNum;
	
	/**
	 * Launch the application.
	 */
	
	  public static void main(String[] args) { EventQueue.invokeLater(new
	  Runnable() { public void run() { try { 
		  User u = new User();
		  ShopWorker_scanFrm frame = new ShopWorker_scanFrm(u);
	  frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	  }
	 

	/**
	 * Create the frame.
	 */
	public ShopWorker_scanFrm(User user) {
		setResizable(false);
		this.owner=user;
		
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopWorker_searchFrm.class.getResource("/image/logo.jpg")));
		
		setBounds(100, 100, 390, 264);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemId = new JLabel("\u5546\u54C1\u7801\uFF1A");
		lblItemId.setBackground(new Color(255, 255, 240));
		lblItemId.setBounds(32, 32, 116, 48);
		lblItemId.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(lblItemId);
		
		textItemId = new JTextField();
		textItemId.setBackground(new Color(255, 255, 240));
		textItemId.setBounds(107, 32, 215, 46);
		contentPane.add(textItemId);
		textItemId.setColumns(10);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.setFont(new Font("宋体", Font.PLAIN, 20));
		btnAdd.setBounds(140, 150, 80, 44);
		contentPane.add(btnAdd);
		
		JLabel label = new JLabel("\u8D2D\u4E70\u6570\u91CF\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(32, 93, 116, 37);
		contentPane.add(label);
		
		GoodsNum = new JTextField();
		GoodsNum.setBounds(163, 95, 88, 41);
		contentPane.add(GoodsNum);
		GoodsNum.setColumns(10);
		

		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String num = GoodsNum.getText().trim();				
				String id = textItemId.getText().trim();
				if(num.length()<1|id.length()<1) {
					JOptionPane.showMessageDialog(null, "请将消费商品信息补充完整！", "消费", JOptionPane.WARNING_MESSAGE);
				}else {
                gd.setGoodsID(id);
                gd.setConsumerNum(Integer.parseInt(num));
                Message m = new Message();
                m.setSender(owner);
                m.setType(MessageType.CMD_SCAN_GOODS);
                m.setGd(gd);
                try {
					usrv.sendMessage(m);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                dispose();
			}}
			
		});
	}
}
