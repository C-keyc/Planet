/*
 * 功能：QQ客户端登陆界面
 */
package seu.list.client.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import seu.list.client.bz.IUserSrv;
import seu.list.client.bz.impl.IUserSrvImpl;
import seu.list.common.QQLogger;
import seu.list.common.User;

public class ClientLoginFrm extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2321671407164708853L;
	/** 定义本机桌面对象 */
	private Desktop desktop = Desktop.getDesktop();
	/** 定义统一资源标识符对象 */
	private URI uri1;
	/** 定义统一资源标识符对象 */
	private URI uri2;
	/** 定义统一资源标识符对象 */
	private URI uri3;
	// 定义北部需要的组件
	JLabel jbl1;
	// 定义中部需要的组件
	// 中部有三个JPanel，有一个叫选项卡窗口管理
	JPanel jp2;
	JLabel jp2_jbl1;
	JLabel jp2_jbl2;
	JLabel jp2_jbl3;
	JLabel jp2_jbl4;
	JLabel jp2_jbl5;
	JTextField txtQqNo;
	JPasswordField jp2_txtPassword;
	JCheckBox jp2_jcb1;
	JCheckBox jp2_jcb2;

	// 定义南部需要的组件
	JPanel jp1;
	JButton jbtnLogin;
	JButton jbtnRegister;

	public ClientLoginFrm() {
		initWidgets();
		setProperties();
	}

	private void initWidgets() {
		
		// 处理北部
		jbl1 = new JLabel(new ImageIcon(this.getClass().getResource("/image/logo554.GIF")));
		// jp5.add(jbl1);
		// 处理中部
		initWidgtesCenter();
		// 处理南部
		initWidgetsSouth();
		this.add(jbl1, "North");
		this.add(jp2, "Center");
		// 把jp1放在南面
		this.add(jp1, "South");
	}

	private void initWidgetsSouth() {
		jp1 = new JPanel(new FlowLayout());
		jbtnLogin = new JButton(new ImageIcon(this.getClass().getResource("/image/登录.gif")));
		// 响应用户点击登录
		jbtnLogin.addActionListener(this);
		jbtnRegister = new JButton(new ImageIcon(this.getClass().getResource("/image/注册.gif")));
		jbtnRegister.addActionListener(this);

		// 把两个按钮放到jp1
		jp1.add(jbtnLogin);
		jp1.add(jbtnRegister);
	}

	private void initWidgtesCenter() {
		jp2 = new JPanel(new GridLayout(3, 3));

		jp2_jbl1 = new JLabel("QQ号码", JLabel.CENTER);
		jp2_jbl2 = new JLabel("QQ密码", JLabel.CENTER);
		jp2_jbl3 = new JLabel("忘记密码", JLabel.CENTER);
		jp2_jbl3.setForeground(Color.BLUE);
		jp2_jbl4 = new JLabel("申请密码保护", JLabel.CENTER);
		jp2_jbl4.setForeground(Color.BLUE);
		jp2_jbl5 = new JLabel("申请账号", JLabel.CENTER);
		jp2_jbl5.setForeground(Color.BLUE);
		txtQqNo = new JTextField();
		jp2_txtPassword = new JPasswordField();
		jp2_jcb1 = new JCheckBox("隐身登录");
		jp2_jcb2 = new JCheckBox("记住密码");

		// 处理JLabel的超链接情况，鼠标的事件
		// 申请QQ号码
		jp2_jbl5.setCursor(new Cursor(Cursor.HAND_CURSOR));// 设置鼠标外观

		// 设置鼠标事件监听
		jp2_jbl5.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jp2_jbl5.setText("<html><A   href='http://id.qq.com/'>申请账号</A></html>");
			}

			public void mouseExited(MouseEvent e) {
				jp2_jbl5.setText("申请账号");
			}

			public void mouseClicked(MouseEvent e) {

				try {
					// 定义网址的内容
					uri1 = new URI("http://id.qq.com/");
				} catch (URISyntaxException e1) {

					e1.printStackTrace();
				}
				try {
					// 浏览uri1网址的网页
					desktop.browse(uri1);
				} catch (IOException e1) {

					// e1.printStackTrace();
				}
			}
		});

		// 申请密码保护
		jp2_jbl4.setCursor(new Cursor(Cursor.HAND_CURSOR));// 设置鼠标外观

		// 设置鼠标事件监听
		jp2_jbl4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jp2_jbl4.setText("<html><A   href='http://aq.qq.com/cn/services/safe_service/my_prot'>申请密码保护</A></html>");
			}

			public void mouseExited(MouseEvent e) {
				jp2_jbl4.setText("申请密码保护");
			}

			public void mouseClicked(MouseEvent e) {

				try {
					// 定义网址的内容
					uri2 = new URI(
							"http://aq.qq.com/cn/services/safe_service/my_prot");
				} catch (URISyntaxException e1) {

					e1.printStackTrace();
				}
				try {
					// 浏览uri2网址的网页
					desktop.browse(uri2);
				} catch (IOException e1) {

					// e1.printStackTrace();
				}
			}
		});

		// 申请密码保护
		jp2_jbl3.setCursor(new Cursor(Cursor.HAND_CURSOR));// 设置鼠标外观

		// 设置鼠标事件监听
		jp2_jbl3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jp2_jbl3.setText("<html><A   href='http://aq.qq.com/cn/findpsw/findpsw_index?reLogin=true&ADUIN=0&ADSESSION=0&ADTAG=CLIENT.QQ.1881_LoginWindow.0'>忘记密码</A></html>");
			}

			public void mouseExited(MouseEvent e) {
				jp2_jbl3.setText("忘记密码");
			}

			public void mouseClicked(MouseEvent e) {

				try {
					// 定义网址的内容
					uri3 = new URI(
							"http://aq.qq.com/cn/findpsw/findpsw_index?reLogin=true&ADUIN=0&ADSESSION=0&ADTAG=CLIENT.QQ.1881_LoginWindow.0");
				} catch (URISyntaxException e1) {

					e1.printStackTrace();
				}
				try {
					// 浏览uri3网址的网页
					desktop.browse(uri3);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		// 把控件按照顺序加到jp2
		jp2.add(jp2_jbl1);
		jp2.add(txtQqNo);
		jp2.add(jp2_jbl5);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_txtPassword);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);
	}

	private void setProperties() {
		this.getRootPane().setDefaultButton(jbtnLogin);
		this.setSize(325, 220);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 获取当前屏幕大小
		Dimension frameSize = this.getPreferredSize();// 获取当前窗口大小
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);// 保持窗口弹出位置居中
		this.setIconImage((new ImageIcon("image/头像.GIF").getImage()));
		this.setTitle("QQ用户登录");
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jbtnLogin) {

			IUserSrv us = new IUserSrvImpl();

			User user = new User();
			String qqNo = txtQqNo.getText().trim();
			user.setQqNo(qqNo);
			user.setPassword(new String(jp2_txtPassword.getPassword()));
			User retUser = null;
			try {
				retUser = us.login(user);
				if (retUser != null) {
					QQLogger.clientLogger().info(user.getQqNo() + ":" + "验证成功");
					//retUser.setStatus(UserStatus.ONLINE);
					new ClientMainFrm(retUser, us);
					// 同时关闭掉登陆界面
					this.dispose();
				} else {				
					
					JOptionPane.showMessageDialog(this, "用户名或密码错误", "警告",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "网络连接异常，请检查相关配置！", "警告",
						JOptionPane.WARNING_MESSAGE);
			}
			
		} else if (e.getSource() == jbtnRegister) {

			this.setVisible(false);
			RegisterDlg r = new RegisterDlg();
			r.setModalityType(ModalityType.APPLICATION_MODAL);
			r.setVisible(true);
			User u = r.getUser();
			this.txtQqNo.setText(u.getQqNo());
			r.dispose();
			this.setVisible(true);
		}
	}
}
