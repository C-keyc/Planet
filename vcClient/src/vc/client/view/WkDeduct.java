package vc.client.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WkDeduct extends JFrame {

	private JPanel contentPane;
	private JTextField textDeductId;
	private JTextField textDeductSum;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WkDeduct frame = new WkDeduct();
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
	public WkDeduct() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(WkDeduct.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6263\u6B3E\u989D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(456, 215, 80, 45);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6263\u6B3E\u8D26\u6237\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(445, 130, 110, 45);
		contentPane.add(label_1);
		
		textDeductId = new JTextField();
		textDeductId.setBackground(new Color(255, 255, 240));
		textDeductId.setBounds(580, 130, 160, 40);
		contentPane.add(textDeductId);
		textDeductId.setColumns(10);
		
		textDeductSum = new JTextField();
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
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u5546\u54C1\u540D", "\u4EF7\u683C"
			}
		));
		table.setRowHeight(30);
		
		JButton btnDeduct = new JButton("\u6263\u6B3E");
		btnDeduct.setBackground(new Color(255, 255, 240));
		btnDeduct.setFont(new Font("宋体", Font.PLAIN, 26));
		btnDeduct.setBounds(552, 418, 102, 45);
		contentPane.add(btnDeduct);
		
		JButton btnAdd = new JButton("\u626B\u63CF");
		btnAdd.setFont(new Font("宋体", Font.PLAIN, 26));
		btnAdd.setBounds(72, 420, 88, 38);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("宋体", Font.PLAIN, 26));
		btnDelete.setBounds(234, 421, 88, 38);
		contentPane.add(btnDelete);
	}
}
