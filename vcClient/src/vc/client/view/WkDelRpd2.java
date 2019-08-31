package vc.client.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;

public class WkDelRpd2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WkDelRpd2 frame = new WkDelRpd2();
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
	public WkDelRpd2() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(WkDelRpd2.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(0, 0, 376, 227);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u5220\u9664\u5931\u8D25\uFF01");
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 26));
		label.setBounds(129, 60, 132, 60);
		panel.add(label);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		button.setBounds(150, 170, 72, 30);
		panel.add(button);
	}

}
