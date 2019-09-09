package vc.client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Changepassword extends JFrame {

	private static final long serialVersionUID = 7557864416922060926L;
	private JPanel contentPane;
	private User owner;
	private JPasswordField newpassword;
	private JPasswordField confirm;
	private UserSrvImpl usrv = new UserSrvImpl ();

	public Changepassword(User u) {
		setResizable(false);
		this.owner=u;
		initialize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 获取当前屏幕大小
		Dimension frameSize = this.getPreferredSize();// 获取当前窗口大小
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);// 保持窗口弹出位置居中
		
	}
	private void initialize(){	

		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Changepassword.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setBounds(41, 36, 59, 29);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel name = new JLabel(owner.getUname());
		name.setBounds(135, 36, 173, 29);
		name.setFont(new Font("宋体", Font.PLAIN, 18));
		contentPane.add(name);
		
		JLabel label = new JLabel("\u4E00\u5361\u901A\uFF1A");
		label.setBounds(41, 71, 84, 29);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		contentPane.add(label);
		
		JLabel lblS = new JLabel("\u4FEE\u6539\u5BC6\u7801\uFF1A");
		lblS.setBounds(41, 108, 95, 29);
		lblS.setFont(new Font("宋体", Font.PLAIN, 18));
		contentPane.add(lblS);
		
		JLabel label_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_1.setBounds(41, 150, 95, 29);
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		contentPane.add(label_1);
		
		JLabel cardID = new JLabel(owner.getUserID());
		cardID.setBounds(135, 71, 173, 29);
		cardID.setFont(new Font("宋体", Font.PLAIN, 18));
		contentPane.add(cardID);
				
		newpassword = new JPasswordField();
		newpassword.setBounds(135, 107, 173, 35);
		contentPane.add(newpassword);
		
		confirm = new JPasswordField();
		confirm.setBounds(135, 149, 173, 35);
		contentPane.add(confirm);
		
		//String newpassword_a=new String(newpassword.getPassword());
		//String confirm_b=new String(confirm.getPassword());
		
		JButton change = new JButton("\u786E\u8BA4\u4FEE\u6539");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(newpassword.getText().length()==0||newpassword.getText().equals("")||confirm.getText().length()==0||confirm.getText().equals("")) {
					//如果没有输入，提示
					JOptionPane.showMessageDialog(contentPane, "请输入密码","提示",JOptionPane.WARNING_MESSAGE );
					}else if(!newpassword.getText().equals(confirm.getText())) {
						//两次密码输入不一致
						JOptionPane.showMessageDialog(contentPane, "两次密码输入不一致！", "错误警告",JOptionPane.YES_OPTION); 
					}else {
						usrv.changePassword(owner, newpassword.getText().trim());
						dispose();
					}
			}
		});
		change.setBounds(126, 197, 110, 43);
		contentPane.add(change);
	}
	
}
