package vc.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import vc.client.view.ShopComsumer_welcomeFrm;
import vc.list.common.User;

public class ShopComsumer_checkremainingFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2684507566552175175L;
	
	private JPanel contentPane;
	private JTable table;
	private JButton ok;

	/**
	 * Launch the application.
	 */
	
	private User owner ; 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u =new User();
					ShopComsumer_checkremainingFrm frame= new ShopComsumer_checkremainingFrm(u);
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
	public ShopComsumer_checkremainingFrm(User user) {
		setResizable(false);
		this.owner = user;
		
		
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopComsumer_checkremainingFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 428);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 69, 552, 59);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 224));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{owner.getUname(), owner.getUserID(), owner.getAccount()},
			},
			new String[] {
				"\u59D3\u540D", "\u4E00\u5361\u901A", "\u4F59\u989D"
			}
		) );
		table.setRowHeight(30);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(),(30)));
		/*
		 * ok = new JButton("\u786E  \u5B9A"); ok.addActionListener(new ActionListener()
		 * { public void actionPerformed(ActionEvent e) {
		 * 
		 * } }); ok.setForeground(new Color(0, 0, 139)); ok.setBackground(new Color(176,
		 * 196, 222)); ok.setFont(new Font("ËÎÌו", Font.PLAIN, 28)); ok.setBounds(208,
		 * 261, 161, 59); contentPane.add(ok);
		 */
	}

}
