package vc.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopComsumer_depositFrm extends JFrame {
	private JTextField depositmoney;
	public static ShopComsumer_depositfailFrm windowf;
	public static ShopComsumer_depositsuccessFrm windows;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopComsumer_depositFrm frame = new ShopComsumer_depositFrm();
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
	public ShopComsumer_depositFrm() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setLayout(null);
		
		JLabel title = new JLabel("\u6821\u56ED\u5361\u5145\u503C");
		title.setForeground(new Color(250, 128, 114));
		title.setBackground(new Color(250, 128, 114));
		title.setFont(new Font("楷体", Font.PLAIN, 33));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(20, 30, 326, 45);
		getContentPane().add(title);
		
		JLabel name1 = new JLabel("姓  名：");
		name1.setFont(new Font("楷体", Font.BOLD, 18));
		name1.setBounds(10, 80, 85, 30);
		getContentPane().add(name1);
		
		JLabel ecard = new JLabel("一卡通：");
		ecard.setFont(new Font("楷体", Font.BOLD, 18));
		ecard.setBounds(10, 115, 85, 30);
		getContentPane().add(ecard);
		
		JLabel count = new JLabel("账户余额：");
		count.setFont(new Font("楷体", Font.BOLD, 18));
		count.setBounds(10, 150, 113, 30);
		getContentPane().add(count);
		
		JLabel demon = new JLabel("充值金额：");
		demon.setFont(new Font("楷体", Font.BOLD, 18));
		demon.setBounds(10, 185, 113, 30);
		getContentPane().add(demon);
		
		depositmoney = new JTextField();
		depositmoney.setBounds(150, 185, 113, 30);
		getContentPane().add(depositmoney);
		depositmoney.setColumns(10);
		
		JLabel name = new JLabel("");
		name.setBounds(150, 80, 113, 30);
		getContentPane().add(name);
		
		JLabel eID = new JLabel("");
		eID.setBounds(150, 115, 113, 30);
		getContentPane().add(eID);
		
		JLabel remaining = new JLabel("");
		remaining.setBounds(150, 150, 113, 30);
		getContentPane().add(remaining);
		
		JButton Deps = new JButton("\u5145\u503C");
		Deps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(true) {
				windows=new ShopComsumer_depositsuccessFrm();
				windows.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				windows.setVisible(true);
				}else {
					windowf=new ShopComsumer_depositfailFrm();
					windowf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					windowf.setVisible(true);
				}
			}
		});
		Deps.setBackground(new Color(176, 196, 222));
		Deps.setForeground(new Color(0, 0, 128));
		Deps.setFont(new Font("宋体", Font.PLAIN, 28));
		Deps.setBounds(127, 243, 105, 45);
		getContentPane().add(Deps);
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5546\u5E97");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopComsumer_depositFrm.class.getResource("/image/logo.jpg")));
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 342);
		
		
	}
}
