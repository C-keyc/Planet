/*
 * ���ܣ�QQ�ͻ��˵�½����
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
	/** ���屾��������� */
	private Desktop desktop = Desktop.getDesktop();
	/** ����ͳһ��Դ��ʶ������ */
	private URI uri1;
	/** ����ͳһ��Դ��ʶ������ */
	private URI uri2;
	/** ����ͳһ��Դ��ʶ������ */
	private URI uri3;
	// ���山����Ҫ�����
	JLabel jbl1;
	// �����в���Ҫ�����
	// �в�������JPanel����һ����ѡ����ڹ���
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

	// �����ϲ���Ҫ�����
	JPanel jp1;
	JButton jbtnLogin;
	JButton jbtnRegister;

	public ClientLoginFrm() {
		initWidgets();
		setProperties();
	}

	private void initWidgets() {
		
		// ������
		jbl1 = new JLabel(new ImageIcon(this.getClass().getResource("/image/logo554.GIF")));
		// jp5.add(jbl1);
		// �����в�
		initWidgtesCenter();
		// �����ϲ�
		initWidgetsSouth();
		this.add(jbl1, "North");
		this.add(jp2, "Center");
		// ��jp1��������
		this.add(jp1, "South");
	}

	private void initWidgetsSouth() {
		jp1 = new JPanel(new FlowLayout());
		jbtnLogin = new JButton(new ImageIcon(this.getClass().getResource("/image/��¼.gif")));
		// ��Ӧ�û������¼
		jbtnLogin.addActionListener(this);
		jbtnRegister = new JButton(new ImageIcon(this.getClass().getResource("/image/ע��.gif")));
		jbtnRegister.addActionListener(this);

		// ��������ť�ŵ�jp1
		jp1.add(jbtnLogin);
		jp1.add(jbtnRegister);
	}

	private void initWidgtesCenter() {
		jp2 = new JPanel(new GridLayout(3, 3));

		jp2_jbl1 = new JLabel("QQ����", JLabel.CENTER);
		jp2_jbl2 = new JLabel("QQ����", JLabel.CENTER);
		jp2_jbl3 = new JLabel("��������", JLabel.CENTER);
		jp2_jbl3.setForeground(Color.BLUE);
		jp2_jbl4 = new JLabel("�������뱣��", JLabel.CENTER);
		jp2_jbl4.setForeground(Color.BLUE);
		jp2_jbl5 = new JLabel("�����˺�", JLabel.CENTER);
		jp2_jbl5.setForeground(Color.BLUE);
		txtQqNo = new JTextField();
		jp2_txtPassword = new JPasswordField();
		jp2_jcb1 = new JCheckBox("�����¼");
		jp2_jcb2 = new JCheckBox("��ס����");

		// ����JLabel�ĳ���������������¼�
		// ����QQ����
		jp2_jbl5.setCursor(new Cursor(Cursor.HAND_CURSOR));// ����������

		// ��������¼�����
		jp2_jbl5.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jp2_jbl5.setText("<html><A   href='http://id.qq.com/'>�����˺�</A></html>");
			}

			public void mouseExited(MouseEvent e) {
				jp2_jbl5.setText("�����˺�");
			}

			public void mouseClicked(MouseEvent e) {

				try {
					// ������ַ������
					uri1 = new URI("http://id.qq.com/");
				} catch (URISyntaxException e1) {

					e1.printStackTrace();
				}
				try {
					// ���uri1��ַ����ҳ
					desktop.browse(uri1);
				} catch (IOException e1) {

					// e1.printStackTrace();
				}
			}
		});

		// �������뱣��
		jp2_jbl4.setCursor(new Cursor(Cursor.HAND_CURSOR));// ����������

		// ��������¼�����
		jp2_jbl4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jp2_jbl4.setText("<html><A   href='http://aq.qq.com/cn/services/safe_service/my_prot'>�������뱣��</A></html>");
			}

			public void mouseExited(MouseEvent e) {
				jp2_jbl4.setText("�������뱣��");
			}

			public void mouseClicked(MouseEvent e) {

				try {
					// ������ַ������
					uri2 = new URI(
							"http://aq.qq.com/cn/services/safe_service/my_prot");
				} catch (URISyntaxException e1) {

					e1.printStackTrace();
				}
				try {
					// ���uri2��ַ����ҳ
					desktop.browse(uri2);
				} catch (IOException e1) {

					// e1.printStackTrace();
				}
			}
		});

		// �������뱣��
		jp2_jbl3.setCursor(new Cursor(Cursor.HAND_CURSOR));// ����������

		// ��������¼�����
		jp2_jbl3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jp2_jbl3.setText("<html><A   href='http://aq.qq.com/cn/findpsw/findpsw_index?reLogin=true&ADUIN=0&ADSESSION=0&ADTAG=CLIENT.QQ.1881_LoginWindow.0'>��������</A></html>");
			}

			public void mouseExited(MouseEvent e) {
				jp2_jbl3.setText("��������");
			}

			public void mouseClicked(MouseEvent e) {

				try {
					// ������ַ������
					uri3 = new URI(
							"http://aq.qq.com/cn/findpsw/findpsw_index?reLogin=true&ADUIN=0&ADSESSION=0&ADTAG=CLIENT.QQ.1881_LoginWindow.0");
				} catch (URISyntaxException e1) {

					e1.printStackTrace();
				}
				try {
					// ���uri3��ַ����ҳ
					desktop.browse(uri3);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		// �ѿؼ�����˳��ӵ�jp2
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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ��ȡ��ǰ��Ļ��С
		Dimension frameSize = this.getPreferredSize();// ��ȡ��ǰ���ڴ�С
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);// ���ִ��ڵ���λ�þ���
		this.setIconImage((new ImageIcon("image/ͷ��.GIF").getImage()));
		this.setTitle("QQ�û���¼");
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
					QQLogger.clientLogger().info(user.getQqNo() + ":" + "��֤�ɹ�");
					//retUser.setStatus(UserStatus.ONLINE);
					new ClientMainFrm(retUser, us);
					// ͬʱ�رյ���½����
					this.dispose();
				} else {				
					
					JOptionPane.showMessageDialog(this, "�û������������", "����",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "���������쳣������������ã�", "����",
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
