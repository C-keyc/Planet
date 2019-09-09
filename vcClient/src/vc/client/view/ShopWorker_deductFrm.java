package vc.client.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vc.client.bz.impl.UserSrvImpl;
import vc.client.view.message.MessageRoll_mainFrm;
import vc.list.common.Goods;
import vc.list.common.Message;
import vc.list.common.MessageType;
import vc.list.common.User;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ShopWorker_deductFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textDeductId;
	private JTextField textDeductSum;
	private JTable table;
	private JScrollPane scrollPane;

	private UserSrvImpl usrv = new UserSrvImpl();
	private User owner;
	private Object[][] data;
	private List<Goods> gdlist= new ArrayList<Goods>();
	private JLabel label_2;
	private JTextField textRemain;
	private JLabel label_3;
	private JPasswordField password;
	
	public List<Goods> getGdlist() {
		return gdlist;
	}
	

	public void addGdlist(Goods gd) {
		if(gd.getRepertory()>=gd.getConsumerNum()) {
		if(gd.getRepertory()<10)
			JOptionPane.showMessageDialog(null, gd.getGoodsName()+"的库存小于10，请及时补充库存", "消费",JOptionPane.WARNING_MESSAGE);
		gdlist.add(gd);
		}else {
			JOptionPane.showMessageDialog(null, gd.getGoodsName()+"的库存已经不足!", "消费",JOptionPane.ERROR_MESSAGE);
		}
	}


	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u =new User();
					ShopWorker_deductFrm frame = new ShopWorker_deductFrm(u);
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
	public ShopWorker_deductFrm(User user) {
		
		this.owner = user;
		ShopWorker_deductMgr.add(user.getUserID(), this); 
		
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopWorker_deductFrm.class.getResource("/image/logo.jpg")));
	
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6263\u6B3E\u989D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(452, 223, 80, 45);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6263\u6B3E\u8D26\u6237\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(442, 84, 110, 45);
		contentPane.add(label_1);
		
		textDeductId = new JTextField();
		textDeductId.setBackground(new Color(255, 255, 240));
		textDeductId.setBounds(580, 88, 160, 40);
		contentPane.add(textDeductId);
		textDeductId.setColumns(10);
		
		textDeductSum = new JTextField();
		textDeductSum.setEditable(false);
		textDeductSum.setBackground(new Color(255, 255, 240));
		textDeductSum.setColumns(10);
		textDeductSum.setBounds(580, 220, 160, 40);
		contentPane.add(textDeductSum);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 120, 295, 148);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 240));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\u5546\u54C1\u540D", "\u4EF7\u683C", "\u8D2D\u4E70\u6570\u91CF"
			}
		));
		table.setRowHeight(30);
		
		JButton btnDeduct = new JButton("\u7ED3\u8D26");
		btnDeduct.setBackground(new Color(255, 255, 240));
		btnDeduct.setFont(new Font("宋体", Font.PLAIN, 26));
		btnDeduct.setBounds(552, 418, 102, 45);
		contentPane.add(btnDeduct);
		btnDeduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
/*				if(textDeductId.getText().trim().length()<1) {
					JOptionPane.showMessageDialog(null, "请先录入消费者一卡通账号！", "消费",JOptionPane.ERROR_MESSAGE);
				}else if(textDeductSum.getText().trim().length()<1) {
					JOptionPane.showMessageDialog(null, "请先录入待购商品！", "消费",JOptionPane.ERROR_MESSAGE);
				}else {*/
                Message m =new Message();
                m.setSender(owner);
                User u = new User();
                u.setUserID(textDeductId.getText().trim());
                u.setConsumer(Double.parseDouble(textDeductSum.getText().trim()));
                u.setUpass(new String(password.getPassword()));
                m.setConsumer(u);
                m.setType(MessageType.CMD_DEDUCT);
                m.setGdlist(gdlist);
                try {
					usrv.sendMessage(m);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnAdd = new JButton("\u626B\u63CF");
		btnAdd.setFont(new Font("宋体", Font.PLAIN, 26));
		btnAdd.setBounds(72, 420, 88, 38);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopWorker_scanFrm scan = new ShopWorker_scanFrm(owner);
				scan.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				scan.setVisible(true);
			}
		});
		
		
		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();			
				if (row != -1) {	
			        gdlist.remove(row);
			        refresh();
				} else {
					JOptionPane.showMessageDialog(null, "请选择一个商品！", "取消购买", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnDelete.setFont(new Font("宋体", Font.PLAIN, 26));
		btnDelete.setBounds(234, 421, 88, 38);
		contentPane.add(btnDelete);
		
		label_2 = new JLabel("\u6263\u6B3E\u540E\u4F59\u989D\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(445, 298, 128, 45);
		contentPane.add(label_2);
		
		textRemain = new JTextField();
		textRemain.setEditable(false);
		textRemain.setColumns(10);
		textRemain.setBackground(new Color(255, 255, 240));
		textRemain.setBounds(580, 298, 160, 40);
		contentPane.add(textRemain);
		
		label_3 = new JLabel("\u6D88\u8D39\u5BC6\u7801\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(442, 157, 110, 45);
		contentPane.add(label_3);
		
		password = new JPasswordField();
		password.setBounds(580, 157, 160, 40);
		contentPane.add(password);
	}
	
	
	public Object[][] getTableData(List<Goods> gdlist){
		int GdNum = gdlist.size();
		Object[][] data= new Object[GdNum][3];
		for(int i =0;i<GdNum;i++) 
		{
			for(int j=0;j<3;j++ ) 
			{
				switch(j)
				{
					case 0:
						data[i][j]=gdlist.get(i).getGoodsName();
						break;
					case 1:
						data[i][j]=gdlist.get(i).getGoodsPrice();
						break;
					case 2:
						data[i][j]=gdlist.get(i).getConsumerNum();
						break;	
				}
			}
		}
		return data;
		}
	
	
	public double getSum() {
		int sum=0;
		for(int i =0;i<gdlist.size();i++)
			sum+=gdlist.get(i).getGoodsPrice()*gdlist.get(i).getConsumerNum();
		return sum;
				
	}
	
	public void setRemain(double remain) {
		this.textRemain.setText(remain+"");
	}
	
	public void refresh() {
		data = this.getTableData(gdlist);
		table.setModel(new DefaultTableModel(
				data,
				new String[] {
						"\u5546\u54C1\u540D", "\u4EF7\u683C", "\u8D2D\u4E70\u6570\u91CF"
				}
			));
		textDeductSum.setText(getSum()+"");
		
	}
	public void clear() {
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
				},
				new String[] {
					"\u5546\u54C1\u540D", "\u4EF7\u683C", "\u8D2D\u4E70\u6570\u91CF"
				}
			));
		textDeductSum.setText("");
		this.textDeductId.setText("");
        this.textRemain.setText("");
        this.password.setText("");
        gdlist.clear();
	}
}
