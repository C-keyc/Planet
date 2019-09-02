package vc.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ShopComsumer_depositsuccessFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopComsumer_depositsuccessFrm frame = new ShopComsumer_depositsuccessFrm();
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
	public ShopComsumer_depositsuccessFrm() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopComsumer_depositsuccessFrm.class.getResource("/image/logo.jpg")));
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 264);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5145\u503C\u6210\u529F\uFF01");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("¿¬Ìå", Font.PLAIN, 28));
		lblNewLabel.setBounds(10, 41, 366, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("¿¬Ìå", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ShopComsumer_depositFrm.windows.isVisible())
				ShopComsumer_depositFrm.windows.setVisible(false);
			}
		});
		btnNewButton.setBounds(125, 149, 119, 46);
		contentPane.add(btnNewButton);
	}
}
