package vc.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ShopComsumer_welcomeFrm extends JFrame {

	private JPanel contentPane;
	public static ShopComsumer_checkremainingFrm windowc;
	public static ShopComsumer_depositFrm windowd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopComsumer_welcomeFrm frame = new ShopComsumer_welcomeFrm();
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
	public ShopComsumer_welcomeFrm() {
		setBackground(SystemColor.activeCaption);
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopComsumer_welcomeFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("\u6B22\u8FCE\u6765\u5230\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		title.setBounds(10, 134, 776, 52);
		title.setFont(new Font("华文行楷", Font.PLAIN, 47));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(250, 128, 114));
		contentPane.add(title);
		
		JButton toCheck = new JButton("\u4F59\u989D\u67E5\u8BE2");
		toCheck.setIcon(null);
		toCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowc=new ShopComsumer_checkremainingFrm();
				windowc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				windowc.setVisible(true);
			}
		});
		toCheck.setForeground(new Color(0, 0, 139));
		toCheck.setBackground(new Color(192, 192, 192));
		toCheck.setFont(new Font("宋体", Font.PLAIN, 28));
		toCheck.setBounds(150, 384, 156, 79);
		contentPane.add(toCheck);
		
		JButton toDeposit = new JButton("\u5145   \u503C");
		toDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowd=new ShopComsumer_depositFrm();
				windowd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				windowd.setVisible(true);
			}
		});
		toDeposit.setForeground(new Color(0, 0, 139));
		toDeposit.setBackground(new Color(192, 192, 192));
		toDeposit.setFont(new Font("宋体", Font.PLAIN, 28));
		toDeposit.setBounds(493, 384, 156, 79);
		contentPane.add(toDeposit);
	}
}
