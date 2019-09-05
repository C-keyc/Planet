package vc.client.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.list.common.Goods;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;

public class WkCheckRpd extends JFrame {

	private JPanel contentPane;
	private JTextField textPrice;
	private JTextField textItemId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Goods gd =new Goods();
					WkCheckRpd frame = new WkCheckRpd(gd);
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
	public WkCheckRpd(Goods gd ) {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		setIconImage(Toolkit.getDefaultToolkit().getImage(WkCheckRpd.class.getResource("/image/logo.jpg")));
		setResizable(false);
		setBounds(100, 100, 390, 264);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u540D\uFF1A");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		lblNewLabel.setBounds(58, 40, 80, 40);
		contentPane.add(lblNewLabel);
		
		textPrice = new JTextField();
		textPrice.setBackground(new Color(255, 255, 240));
		textPrice.setBounds(160, 110, 128, 43);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
		
		textPrice.setText(""+gd.getGoodsPrice());
		
		JLabel label = new JLabel("\u4EF7\u683C\uFF1A");
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		label.setBounds(67, 110, 61, 40);
		contentPane.add(label);
		
		textItemId = new JTextField();
		textItemId.setColumns(10);
		textItemId.setBackground(new Color(255, 255, 240));
		textItemId.setBounds(160, 40, 128, 43);
		contentPane.add(textItemId);
		
		textItemId.setText(gd.getGoodsName());
		
		JButton btnOk = new JButton("\u786E\u5B9A");
		btnOk.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		btnOk.setBounds(162, 181, 75, 31);
		contentPane.add(btnOk);
		
		
		
		
	}

}
