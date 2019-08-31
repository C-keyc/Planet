package vc.client.view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class WkDelRpd extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WkDelRpd frame = new WkDelRpd();
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
	public WkDelRpd() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(WkDelRpd.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 28, 237, 65);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 240));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"\u5546\u54C1\u540D", "\u4EF7\u683C"
			}
		));
		table.setRowHeight(30);
		
		JLabel label = new JLabel("\u786E\u8BA4\u5220\u9664\u8BE5\u5546\u54C1\uFF1F");
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 24));
		label.setBounds(123, 119, 205, 42);
		contentPane.add(label);
		
		JButton btnYes = new JButton("\u786E\u8BA4");
		btnYes.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnYes.setBounds(100, 200, 80, 30);
		contentPane.add(btnYes);
		
		JButton btnNo = new JButton("\u53D6\u6D88");
		btnNo.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		btnNo.setBounds(260, 200, 80, 30);
		contentPane.add(btnNo);
	}
}
