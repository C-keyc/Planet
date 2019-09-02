package vc.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ShopComsumer_depositfailFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopComsumer_depositfailFrm frame = new ShopComsumer_depositfailFrm();
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
	public ShopComsumer_depositfailFrm() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopComsumer_depositfailFrm.class.getResource("/image/logo.jpg")));
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 264);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5145\u503C\u5931\u8D25\uFF01");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("¿¬Ìå", Font.PLAIN, 28));
		lblNewLabel.setBounds(10, 41, 366, 53);
		contentPane.add(lblNewLabel);
		
		JButton OK = new JButton("\u786E\u5B9A");
		OK.setBackground(new Color(176, 196, 222));
		OK.setForeground(new Color(0, 0, 128));
		OK.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ShopComsumer_depositFrm.windowf.isVisible())
				ShopComsumer_depositFrm.windowf.setVisible(false);
			}
		});
		OK.setBounds(125, 149, 119, 46);
		contentPane.add(OK);
	}

}
