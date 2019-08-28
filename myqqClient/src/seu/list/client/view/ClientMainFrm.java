package seu.list.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import seu.list.client.bz.ClientMainFrmMgr;
import seu.list.client.bz.IUserSrv;
import seu.list.client.bz.impl.IUserSrvImpl;
import seu.list.common.Message;
import seu.list.common.MessageType;
import seu.list.common.QQLogger;
import seu.list.common.User;
import seu.list.common.UserStatus;

/**
 * @author  john
 */
public class ClientMainFrm extends JFrame implements ActionListener,
		MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5243240355751562335L;

	private static final String VERSION = "SEU-QQ2012";

	private static final int MAX_NUM_FRIENDS = 100;

	int friendsCnt;// 保存好友的数目
	
	// 处理第一张卡片（我的好友）
	JLabel jphy_jl;
	JPanel jphy1;

	JPanel jphy2;

	JPanel jphy3;

	JPanel jphy4;

	JPanel jphy5;
	JButton jphy_jb1;

	JButton cdFriend_btnStranger;

	JButton cdStranger_btnBlack;

	JButton cdFriend_btnAdd;

	JButton cdFriend_btnDel;

	JButton cdFriend_btnExit;
	JScrollPane jspl;
	String ownerNo;
	List<JLabel> lblFriendIcos;
	
	// 处理第二张卡片（陌生人）
	JLabel jpmsr_jl;
	JPanel panStranger;

	JPanel jpmsr2;

	JPanel jpmsr3;

	JPanel jpmsr4;

	JPanel jpmsr5;
	JButton cdStranger_btnFriend;

	JButton cdStranger_btnStranger;

	JButton cdFriend_btnBlack;

	JButton cdStranger_btnAdd;

	JButton cdStranger_btnDel;

	JButton cdStranger_btnExit;
	JScrollPane jspl2;


	// 处理第三张卡片（黑名单）
	JLabel jphmd_jl;
	JPanel jphmd1;

	JPanel jphmd2;

	JPanel jphmd3;

	JPanel jphmd4;
	JButton cdBlack_btnFriend;

	JButton cdBlack_btnStranger;

	JButton jphmd_jb3;

	JButton cdBlack_btnAdd;

	JButton cdBlack_btnDel;

	JButton cdBlack_btnExit;
	JScrollPane jspl3;

	// 把整个JFrame设置成CardLayout
	CardLayout cl;
	private String strBtnFriends;
	private String strBtnStrangers;
	private String strBtnBlacklists;
	private int friendsOnlineCnt;

	private List<User> friends;

	/**
	 * @uml.property  name="iuserSrv"
	 * @uml.associationEnd  
	 */
	private IUserSrv iuserSrv;

	/**
	 * @uml.property  name="owner"
	 * @uml.associationEnd  
	 */
	private User owner;

	private boolean isOnline;

	private JButton cdStranger_btnLog;

	private JButton cdBlack_btnLog;

	private JButton cdFriend_btnLog;

	/**
	 * 
	 * @param retUser
	 * @param ius
	 */
	public ClientMainFrm(User retUser, IUserSrv ius) {
		this.owner = retUser;
		this.ownerNo = this.owner.getQqNo();
		ClientMainFrmMgr.add(this.ownerNo, this);
		this.iuserSrv = ius;
		initData();
		initWidgets();
		queryMyFriends();
		setProperties();
	}

	// 查询用户的好友，然后显示出来
	public void queryMyFriends() {
		User user = new User();
		user.setQqNo(ownerNo);
		//
		IUserSrv ius = new IUserSrvImpl();
		try {
			ius.quyFriend(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initFriendsView() {

		friendsCnt = 0;
		friendsOnlineCnt = 0;
		for (User f : friends) {
			JLabel jlb = new JLabel(f.getQqNo(), new ImageIcon(
			"image/头像.GIF"), JLabel.LEFT);
			lblFriendIcos.add(jlb);
			if (f.getStatus().trim().equals(UserStatus.OFFLINE))
				jlb.setEnabled(false);
			else
				friendsOnlineCnt++;
			jlb.addMouseListener(this);
			jphy2.add(jlb);			
			friendsCnt++;
			System.out.println("好友：" + f);
		}
		//

		strBtnFriends = "[" + friendsOnlineCnt + "/" + friendsCnt + "]";

		//
		updateButtonsText();
	}

	private void updateButtonsText() {

		jphy_jb1.setText("我的好友" + this.strBtnFriends);
		cdFriend_btnStranger.setText(this.strBtnStrangers);
		cdStranger_btnBlack.setText(this.strBtnBlacklists);
		cdStranger_btnFriend.setText("我的好友" + this.strBtnFriends);
		cdStranger_btnStranger.setText(this.strBtnStrangers);
		cdFriend_btnBlack.setText(this.strBtnBlacklists);
		cdBlack_btnFriend.setText("我的好友" + this.strBtnFriends);
		cdBlack_btnStranger.setText(this.strBtnStrangers);
		jphmd_jb3.setText(this.strBtnBlacklists);

	}

	// 更新在线的好友的情况

	public void updateFriend(Message m) {
		String type = m.getType();
		if (type.equals(MessageType.DAT_LOGIN)) {
			String friendNo = m.getContent();
			QQLogger.clientLogger().info("上线：" + friendNo);

			int index = isFriend(friendNo);
			if (index  != -1) {
				lblFriendIcos.get(index).setEnabled(true);
				friendsOnlineCnt++;
			}

		} else if (type.equals(MessageType.DAT_LOGOUT)) {
			if (m.getSender().getQqNo().equals(this.owner.getQqNo())) {
				QQLogger.clientLogger().info("被踢：" + this.ownerNo);
				setOnline(false);
				//
				// ClientMainFrmMgr.remove(this.ownerNo);

			} else {
				String friendNo = m.getContent();
				QQLogger.clientLogger().info("下线：" + friendNo);
				//
				int index = isFriend(friendNo);
				if (index != -1) {
					lblFriendIcos.get(index).setEnabled(false);
					friendsOnlineCnt--;
				}
			}
		}
		strBtnFriends = "[" + friendsOnlineCnt + "/" + friendsCnt + "]";
		updateButtonsText();
	}

	/**
	 * 更改用户在线状态时的处理
	 * @param  isOnline
	 * @uml.property  name="isOnline"
	 */
	private void setOnline(boolean isOnline) {
		this.isOnline = isOnline;

		if (isOnline) {

		} else {
			friendsOnlineCnt = 0;
			for (JLabel jlb : this.lblFriendIcos) {
				jlb.setEnabled(isOnline);
			}
			//
			Iterator<Entry<String, ChatFrm>> it = ChatFrmMgr.getInstance()
					.getPool().entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, ChatFrm> et = it.next();
				String key = et.getKey();
				if (key.startsWith(this.ownerNo)) {
					et.getValue().setOwner(owner);
				}
			}
		}
		this.cdBlack_btnAdd.setVisible(isOnline);
		this.cdFriend_btnAdd.setVisible(isOnline);
		this.cdStranger_btnAdd.setVisible(isOnline);
		//
		this.cdBlack_btnDel.setVisible(isOnline);
		this.cdFriend_btnDel.setVisible(isOnline);
		this.cdStranger_btnDel.setVisible(isOnline);
		//
		this.cdFriend_btnLog.setVisible(!isOnline);
		this.cdStranger_btnLog.setVisible(!isOnline);
		this.cdBlack_btnLog.setVisible(!isOnline);
	}

	private void initData() {
		strBtnFriends = "我的好友[0/0]";
		strBtnStrangers = "陌生人[0/0]";
		strBtnBlacklists = "黑名单[0/0]";
		this.isOnline = true;
	}

	private void setProperties() {
		// 在窗口显示自己的编号
		this.setSize(300, 550);
		this.setLocation(900, 80);
		this.setTitle(VERSION + "   " + owner.getNickName());
		Image img = Toolkit.getDefaultToolkit().getImage("image/头像.GIF");
		setIconImage(img);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				exit();
			}
		});
	}

	private void initWidgets() {
		// 处理第一张卡片（显示好友列表）
		initFriendCard();

		// 处理第二张卡片(显示陌生人)
		jpmsr_jl = new JLabel(ownerNo, new ImageIcon("image/头像.GIF"),
				JLabel.LEFT);
		cdStranger_btnFriend = new JButton("我的好友");
		cdStranger_btnFriend.addActionListener(this);
		cdStranger_btnStranger = new JButton("陌生人");
		cdFriend_btnBlack = new JButton("黑名单");
		cdFriend_btnBlack.addActionListener(this);
		cdStranger_btnAdd = new JButton("增加好友");
		cdStranger_btnAdd.addActionListener(this);
		cdStranger_btnDel = new JButton("删除好友");
		cdStranger_btnDel.addActionListener(this);

		cdStranger_btnLog = new JButton("登录");
		cdStranger_btnLog.addActionListener(this);

		cdStranger_btnExit = new JButton("退出");
		cdStranger_btnExit.addActionListener(this);

		panStranger = new JPanel(new BorderLayout());
		// 假定有20个陌生人
		jpmsr2 = new JPanel(new GridLayout(20, 1, 4, 4));

		jpmsr3 = new JPanel(new GridLayout(3, 1));
		// 把两个按钮加入到jphy3中
		jpmsr3.add(jpmsr_jl);
		jpmsr3.add(cdStranger_btnFriend);
		jpmsr3.add(cdStranger_btnStranger);

		jpmsr5 = new JPanel();
		jpmsr5.add(cdStranger_btnAdd);
		jpmsr5.add(cdStranger_btnDel);
		jpmsr5.add(cdStranger_btnLog);
		jpmsr5.add(cdStranger_btnExit);

		jpmsr4 = new JPanel(new GridLayout(2, 1));
		jpmsr4.add(cdFriend_btnBlack);
		jpmsr4.add(jpmsr5);
		jspl2 = new JScrollPane(jpmsr2);

		// 对jpmsr1初始化
		panStranger.add(jpmsr3, "North");
		panStranger.add(jspl2, "Center");
		panStranger.add(jpmsr4, "South");

		// 处理第三张卡片（显示黑名单）
		jphmd_jl = new JLabel(ownerNo + "", new ImageIcon("image/头像.GIF"),
				JLabel.LEFT);
		cdBlack_btnFriend = new JButton("我的好友");
		cdBlack_btnFriend.addActionListener(this);
		cdBlack_btnStranger = new JButton("陌生人");
		cdBlack_btnStranger.addActionListener(this);
		jphmd_jb3 = new JButton("黑名单");
		cdBlack_btnAdd = new JButton("增加好友");
		cdBlack_btnAdd.addActionListener(this);
		cdBlack_btnDel = new JButton("删除好友");
		cdBlack_btnDel.addActionListener(this);
		cdBlack_btnLog = new JButton("登录");
		cdBlack_btnLog.addActionListener(this);
		cdBlack_btnExit = new JButton("退出");
		cdBlack_btnExit.addActionListener(this);

		jphmd1 = new JPanel(new BorderLayout());
		// 假定有10个好友
		jphmd2 = new JPanel(new GridLayout(10, 1, 4, 4));

		jphmd3 = new JPanel(new GridLayout(4, 1));
		jphmd4 = new JPanel();
		// 把两个按钮加入到jphy3中
		jphmd3.add(jphmd_jl);
		jphmd3.add(cdBlack_btnFriend);
		jphmd3.add(cdBlack_btnStranger);
		jphmd3.add(jphmd_jb3);
		jphmd4.add(cdBlack_btnAdd);
		jphmd4.add(cdBlack_btnDel);
		jphmd4.add(cdBlack_btnLog);
		jphmd4.add(cdBlack_btnExit);
		jspl3 = new JScrollPane(jphmd2);

		// 对jphmd1初始化
		jphmd1.add(jphmd3, "North");
		jphmd1.add(jspl3, "Center");
		jphmd1.add(jphmd4, "South");

		cl = new CardLayout();
		this.setLayout(cl);
		this.add(jphy1, "1");
		this.add(panStranger, "2");
		this.add(jphmd1, "3");
		//

		this.cdFriend_btnLog.setVisible(false);
		this.cdStranger_btnLog.setVisible(false);
		this.cdBlack_btnLog.setVisible(false);
	}

	/**
	 * 根据分组实现
	 */
	private void initFriendCard() {
		jphy_jl = new JLabel(ownerNo + "", new ImageIcon("image/头像.GIF"),
				JLabel.LEFT);

		jphy_jb1 = new JButton(strBtnFriends);
		cdFriend_btnStranger = new JButton(strBtnStrangers);
		cdFriend_btnStranger.addActionListener(this);

		cdStranger_btnBlack = new JButton(strBtnBlacklists);
		cdStranger_btnBlack.addActionListener(this);
		cdFriend_btnAdd = new JButton("增加好友");
		cdFriend_btnAdd.addActionListener(this);
		cdFriend_btnDel = new JButton("删除好友");
		cdFriend_btnDel.addActionListener(this);
		cdFriend_btnLog = new JButton("登录");
		cdFriend_btnLog.addActionListener(this);
		cdFriend_btnExit = new JButton("退出");
		cdFriend_btnExit.addActionListener(this);

		jphy1 = new JPanel(new BorderLayout());
		// 限定只能有50个好友
		jphy2 = new JPanel(new GridLayout(MAX_NUM_FRIENDS, 1, 4, 4));
		// 给jphy2，初始化50个好友
		lblFriendIcos = new ArrayList<JLabel>();

		jphy3 = new JPanel(new GridLayout(3, 1));
		// 把两个按钮加入到jphy3中

		jphy4 = new JPanel(new GridLayout(2, 1));
		jphy4.add(jphy_jl);
		jphy4.add(jphy_jb1);

		jphy5 = new JPanel();
		jphy5.add(cdFriend_btnAdd);
		jphy5.add(cdFriend_btnDel);
		jphy5.add(cdFriend_btnLog);
		jphy5.add(cdFriend_btnExit);

		jphy3.add(cdFriend_btnStranger);
		jphy3.add(cdStranger_btnBlack);
		jphy3.add(jphy5);

		jspl = new JScrollPane(jphy2);

		// 对jphy1初始化
		jphy1.add(jphy4, "North");
		jphy1.add(jspl, "Center");
		jphy1.add(jphy3, "South");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == cdFriend_btnStranger
				|| e.getSource() == cdBlack_btnStranger)// 如果点击了陌生人的按钮，就显示第二张卡片
		{
			cl.show(this.getContentPane(), "2");
		} else if (e.getSource() == cdStranger_btnFriend
				|| e.getSource() == cdBlack_btnFriend)// 如果点击了我的好友的按钮，就显示第一张卡片
		{
			cl.show(this.getContentPane(), "1");
		} else if (e.getSource() == cdStranger_btnBlack
				|| e.getSource() == cdFriend_btnBlack)// 如果点击了黑名单的按钮，就显示第三张卡片
		{
			cl.show(this.getContentPane(), "3");
		} else if (e.getSource() == cdFriend_btnAdd
				|| e.getSource() == cdStranger_btnAdd
				|| e.getSource() == cdBlack_btnAdd) {
			// 增加好友--简单版本
			String friendNo = JOptionPane.showInputDialog("请输入要添加好友的QQ号码：");
			if (friendNo == null || friendNo.trim().isEmpty()) {
				return;
			}
			friendNo = friendNo.trim();
			if (friendNo.equals(this.ownerNo)) {
				JOptionPane.showMessageDialog(this, "不能添加自己", "警告",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			// 检查好友是否已经添加过
			// if ((friend = iuserSrv.isFriend(this.owner, friendNo)) == null) {
			if (isFriend(friendNo) == -1) {
				try {
					this.iuserSrv.addFriend(this.owner, friendNo);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(this, "已是好友", "警告",
						JOptionPane.WARNING_MESSAGE);
			}

		} else if (e.getSource() == cdFriend_btnDel
				|| e.getSource() == cdStranger_btnDel
				|| e.getSource() == cdBlack_btnDel) {
			String friendNo = JOptionPane.showInputDialog("请输入要删除好友的QQ号码：");
			if (friendNo == null || friendNo.trim().isEmpty()) {
				return;
			}
			friendNo = friendNo.trim();
			if (isFriend(friendNo) != -1) {
				try {
					this.iuserSrv.delFriend(this.owner, friendNo);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(this, "不是好友", "警告",
						JOptionPane.WARNING_MESSAGE);
			}

		} else if (e.getSource() == cdFriend_btnLog
				|| e.getSource() == cdStranger_btnLog
				|| e.getSource() == cdBlack_btnLog) {
			this.dispose();
			new ClientLoginFrm();
		} else if (e.getSource() == cdFriend_btnExit
				|| e.getSource() == cdStranger_btnExit
				|| e.getSource() == cdBlack_btnExit) {
			// 退出

			exit();
		}
	}

	private int isFriend(String friendNo) {
		int rs = -1;
		for (int i = 0; i < this.friends.size(); i++) {
			if (friends.get(i).getQqNo().equals(friendNo)) {
				rs = i;
				break;
			}
		}
		return rs;
	}

	private void exit() {
		if (this.isOnline)
			try {
				this.iuserSrv.logout(this.owner);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		// 断开与服务器的连接
		System.exit(0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 响应用户双击的事件，并得到好友的编号
		if (e.getClickCount() == 2)// 双击
		{
			// 得到好友编号
			String friendNo = ((JLabel) e.getSource()).getText();
			// 从聊天界面池中获取聊天界面，并显示
			String key = this.ownerNo + ChatFrm.NAME_SPLITTER + friendNo;
			ChatFrm cf = ChatFrmMgr.getInstance().get(key);
			cf.setOwner(this.owner);
			cf.setFriend(this.friends.get(isFriend(friendNo)));
			if (!cf.isVisible())
				cf.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel) e.getSource();
		jl.setForeground(Color.red);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel) e.getSource();
		jl.setForeground(Color.black);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param friends
	 * @uml.property  name="friends"
	 */
	public void setFriends(List<User> friends) {
		this.friends = friends;
		initFriendsView();
	}

	public void addFriend(Message msg) {
		User friend = msg.getSender();
		if (friend != null) {
			JOptionPane.showMessageDialog(this, "添加成功", "信息",
					JOptionPane.INFORMATION_MESSAGE);
			this.friends.add(friend);
			String friendNo = friend.getQqNo();
		
			JLabel jlb = new JLabel(friendNo, new ImageIcon(
			"image/头像.GIF"), JLabel.LEFT);;
					
			if (friend.getStatus().trim().equals(UserStatus.OFFLINE))
				jlb.setEnabled(false);
			else
				friendsOnlineCnt++;
			jlb.addMouseListener(this);
			jphy2.add(jlb);
			this.lblFriendIcos.add(jlb);	
			
			friendsCnt++;
			strBtnFriends = "[" + friendsOnlineCnt + "/" + friendsCnt + "]";
			//
			updateButtonsText();
			//
		} else {
			JOptionPane.showMessageDialog(this, "添加失败", "警告",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	public void delFriend(Message msg) {		
		User friend = msg.getSender();
		if (friend != null) {
			JOptionPane.showMessageDialog(this, "删除成功", "信息",
					JOptionPane.INFORMATION_MESSAGE);
			String friendNo = friend.getQqNo();
			int index = isFriend(friendNo);
			this.friends.remove(index);	
			
			if (friend.getStatus().trim().equals(UserStatus.ONLINE))			
				friendsOnlineCnt--;
			JLabel jlb = this.lblFriendIcos.remove(index);
			jphy2.remove(jlb);
			
			friendsCnt--;
			strBtnFriends = "[" + friendsOnlineCnt + "/" + friendsCnt + "]";
			//
			updateButtonsText();
			//
		} else {
			JOptionPane.showMessageDialog(this, "删除失败", "警告",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
