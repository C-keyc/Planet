package vc.client.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class WkAddPRpd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WkAddPRpd frame = new WkAddPRpd();
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
	public WkAddPRpd() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(WkAddPRpd.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 264);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u6210\u529F\uFF01");
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 26));
		label.setBounds(129, 60, 132, 60);
		contentPane.add(label);
		
		JButton btnOk = new JButton("\u786E\u5B9A");
		btnOk.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		btnOk.setBounds(162, 181, 75, 31);
		contentPane.add(btnOk);
	}

}
