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
import java.awt.Toolkit;
import javax.swing.JButton;

public class WkAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textItemId;
	private JTextField textItemName;
	private JTextField textPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WkAdd frame = new WkAdd();
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
	public WkAdd() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(WkAdd.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
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
		btnAdd.setBounds(200, 296, 80, 40);
		contentPane.add(btnAdd);
	}
}
