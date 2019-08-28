package seu.list.client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import seu.list.client.bz.IUserSrv;
import seu.list.client.bz.impl.IUserSrvImpl;
import seu.list.common.Message;
import seu.list.common.MessageType;
import seu.list.common.QQLogger;
import seu.list.common.User;
import seu.list.common.UserStatus;

/**
 * ����ѵ����촰�� ��Ϣ����ʾ�������ͽ����ն�
 * 
 * @author Aodong Shen
 */
public class ChatFrm extends JFrame implements ICallback {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8883731487098966373L;
	public static final String NAME_SPLITTER = "-";
	/**
	 * @uml.property name="txtChat"
	 * @uml.associationEnd
	 */
	ChatOutPane chatOutputPane;
	ChatInPane chatInputPane;
	JScrollPane jsp;
	String ownerNo;
	String friendNo;
	/**
	 * @uml.property name="owner"
	 * @uml.associationEnd
	 */
	private User owner;
	/**
	 * @uml.property name="friend"
	 * @uml.associationEnd
	 */
	private User friend;
	private IUserSrv ius = new IUserSrvImpl();

	// private String ownerId;

	public ChatFrm(String ownerNo, String friendNo) {

		this.ownerNo = ownerNo;
		this.friendNo = friendNo;
		// this.ownerId = this.ownerNo + NAME_SPLITTER + this.friendNo;
		initWidgets();
		setProperties();
	}

	public void initWidgets() {
		chatOutputPane = new ChatOutPane();
		chatOutputPane.setFont(new Font("΢���ź�", Font.PLAIN, 16));

		jsp = new JScrollPane(chatOutputPane);
		chatInputPane = new ChatInPane(this);

		this.add(jsp, "Center");
		this.add(chatInputPane, "South");

		this.setTitle(ownerNo + "���ں�" + friendNo + "����");

	}

	public void setProperties() {
		this.getRootPane().setDefaultButton(
				this.chatInputPane.getDefaultButton());
		this.setSize(400, 360);
		this.setPreferredSize(this.getSize());
		this.setIconImage((new ImageIcon("image/ͷ��.GIF").getImage()));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ��ȡ��ǰ��Ļ��С
		Dimension frameSize = this.getPreferredSize();// ��ȡ��ǰ���ڴ�С
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);// ���ִ��ڵ���λ�þ���
		this.setVisible(true);
		this.chatInputPane.requestFocusInWindow();
	}

	// дһ��������������ʾ��Ϣ
	public void showMessage(Message m) {
		String info = m.getSender().getNickName() + ":" + m.getSendTime()
				+ "\n" + m.getContent() + "\r\n";
		this.chatOutputPane.append(info, ChatOutPane.FRIEND_STYLE);
	}

	public void showMessage(String text) {
		String info = text;
		this.chatOutputPane.append(info);
	}

	/**
	 * @param owner
	 * @uml.property name="owner"
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}

	/**
	 * @param user
	 * @uml.property name="friend"
	 */
	public void setFriend(User user) {
		this.friend = user;
	}

	@Override
	public void doCallback(Object object, MyAWTEvent evt) {
		if (object instanceof ChatInPane) {

			ChatInPane cip = (ChatInPane) object;
			if (evt.getType().equals(MyAWTEvent.SEND)) {

				String text = cip.getText();
				QQLogger.clientLogger().info(
						this.owner.getNickName() + this.owner.getStatus());
				if (this.owner.getStatus().trim().equals(UserStatus.ONLINE)) {
					// ����û�����˷��Ͱ�ť

					try {
						ius.chat(this.owner, this.friend, text);
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
				// ������ʾ
				String info = this.owner.getNickName() + ": "
						+ new Date().toString() + "\n" + text + "\r\n";
				this.chatOutputPane.append(info, ChatOutPane.OWNER_STYLE);
				cip.setText("");
			} else if (evt.getType().equals(MyAWTEvent.CLOSE)) {
				this.dispose();
			} else if (evt.getType().equals(MyAWTEvent.FILE)) {
				final JFileChooser fc = new JFileChooser();
				// In response to a button click:
				int returnVal = fc.showOpenDialog(this);
				File file = null;
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
					// This is where a real application would open the file.
					// log.append("Opening: " + file.getName() + ".");

					if (this.owner.getStatus().trim().equals(UserStatus.ONLINE)) {

						try {
							ius.sendFile(this.owner, this.friend, file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

					// ������ʾ
					String info = this.owner.getNickName() + ": "
							+ new Date().toString() + "\n�����ļ���"
							+ file.getName() + "\r\n";
					this.chatOutputPane.append(info, ChatOutPane.OWNER_STYLE);
				}
			} else if (evt.getType().equals(MyAWTEvent.SHAKE)) {
				QQLogger.clientLogger().info(
						this.owner.getNickName() + this.owner.getStatus());
				if (this.owner.getStatus().trim().equals(UserStatus.ONLINE)) {
					try {
						ius.chat(this.owner, this.friend, "������~~~~");
						ius.sendShake(this.owner, this.friend);
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
				// ������ʾ
				String info = this.owner.getNickName() + ": "
						+ new Date().toString() + "\n" + "������~~~~" + "\r\n";
				this.chatOutputPane.append(info, ChatOutPane.OWNER_STYLE);
				cip.setText("");
			}
		}
	}

	public void showFileWidget(Message msg) throws IOException {
		String type = msg.getType();
		if (type.equals(MessageType.RST_FAILURE)) { // ����
			QQLogger.clientLogger().info("�Է����ջ����ߣ�");

			File file = (File) msg.getData();
			msg.setContent("�Է�����:");
			this.showMessage(msg);
			String info = "<html><a href='" + file.getAbsolutePath() + "'>"
					+ file.getName() + "</a></html>";
			this.showMessage(info);
			//
			JOptionPane.showMessageDialog(this, "�Է����ջ�����", "����",
					JOptionPane.WARNING_MESSAGE);

		} else if (type.equals(MessageType.RST_SUCCESS)) { // ͬ��
			QQLogger.clientLogger().info("�Է�ͬ����գ�");
			File file = (File) msg.getData();
			// JOptionPane.showMessageDialog(this, "�Է�ͬ�����", "����",
			// JOptionPane.WARNING_MESSAGE);
			this.showMessage("�Է�ͬ�����" + file.getName());
			//
			msg.setSender(this.owner);
			msg.setReceiver(this.friend);
			msg.setType(MessageType.FILE_DATA);
			ius.sendFileMessage(msg);
			//
			this.chatInputPane.showProgress(true);
			ius.sendFile(this.owner, this.friend.getQqNo(), file);

		} else if (type.equals(MessageType.FILE_DATA)) { // ������
			QQLogger.clientLogger().info("��ʼ�������ݣ�");
			//
			final JFileChooser fc = new JFileChooser();
			// In response to a button click:
			int rs = fc.showSaveDialog(this);
			File file = null;
			if (rs == JFileChooser.APPROVE_OPTION) {
				this.chatInputPane.showProgress(true);
				file = fc.getSelectedFile();
				File sendFile = (File) msg.getData();
				ius.receiveFile(this.owner, this.friend.getQqNo(), file,
						sendFile.length());
			}

		} else if (type.equals(MessageType.FILE_RECE)) {

		} else if (type.equals(MessageType.FILE_SEND)) { // �����ļ�����֪ͨ

			//
			this.setVisible(true);
			File file = (File) msg.getData();
			int rs = JOptionPane.showConfirmDialog(this,
					this.friend.getNickName() + "�����ļ���" + file.getName(),
					"�Ƿ����", JOptionPane.YES_NO_OPTION);
			msg.setSender(this.owner);
			msg.setReceiver(this.friend);
			if (rs == 0) {
				msg.setType(MessageType.RST_SUCCESS);
				msg.setContent("�����ļ�");
				this.showMessage(msg);
			} else {
				msg.setType(MessageType.RST_FAILURE);
				msg.setContent("�����ļ�");
				this.showMessage(msg);
			}
			ius.sendFileMessage(msg);
		} else {
			QQLogger.clientLogger().warning("�������Ϣ���ͣ�");
		}
	}

	public void showProgress(double d) {
		this.chatInputPane.showProgress((int) d);
	}

	public void showProgress(File file) {
		this.chatInputPane.showProgress(false);
		System.out.println(file.getAbsolutePath());
		String info = "<html><a href='" + file.getAbsolutePath() + "'>"
				+ file.getName() + "</a></html>";
		this.showMessage(info);
	}

	/**
	 * ���涶��
	 */
	public void doShake() {
		new Thread() {
			@Override
			public void run() {
				final Rectangle r = ChatFrm.this.getBounds();
				final int left = r.x;
				final int top = r.y;
				for (int i = 0; i < 20; i++) {
					if (i % 2 == 0)
						ChatFrm.this.setBounds(left + 5, top + 5, r.width,
								r.height);
					else
						ChatFrm.this.setBounds(left - 5, top - 5, r.width,
								r.height);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ChatFrm.this.setBounds(left, top, r.width, r.height);
			}
		}.start();// �������߳�
	}
}
