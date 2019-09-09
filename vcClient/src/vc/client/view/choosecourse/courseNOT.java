package vc.client.view.choosecourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class courseNOT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseNOT frame = new courseNOT();
					frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
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
	public courseNOT() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("\u60A8\u8F93\u5165\u7684\u8BFE\u7A0BID\u6709\u8BEF\uFF0C\u8BF7\u91CD\u65B0\u8F93\u5165");
		lblid.setBounds(37, 74, 376, 29);
		lblid.setFont(new Font("¿¬Ìå", Font.PLAIN, 20));
		contentPane.add(lblid);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("¿¬Ìå", Font.PLAIN, 20));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(229, 172, 123, 29);
		contentPane.add(btnOk);
	}
}
