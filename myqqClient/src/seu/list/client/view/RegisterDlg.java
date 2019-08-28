package seu.list.client.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import seu.list.client.bz.ClientMainFrmMgr;
import seu.list.client.bz.IUserSrv;
import seu.list.client.bz.impl.IUserSrvImpl;
import seu.list.common.User;
/**
 * @author  john
 */
public class RegisterDlg extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 771184339737471409L;
	JLabel jl1;
	JLabel jl2;
	JLabel jl3;
	JLabel jl4;
	JLabel jl5;
	JTextField jtf1;
	JTextField jtf2;
	JTextField jtf5;
	JPasswordField jtf3;
	JPasswordField jtf4;
	JButton jb1;
	JButton jb2;
	JPanel jp;
	/**
	 * @uml.property  name="user"
	 * @uml.associationEnd  
	 */
	private User user;
	
	public RegisterDlg()
	{
		initWidgets();
		setProperties();
		
	}
	public void setProperties() {
		this.setSize(325,220);
		this.setIconImage((new ImageIcon("image/头像.GIF").getImage()));
		this.setTitle("QQ用户注册");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   //获取当前屏幕大小
		Dimension frameSize = this.getPreferredSize();//获取当前窗口大小
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);//保持窗口弹出位置居中
		//this.setVisible(true);
	}
	public void initWidgets() {
		jl1=new JLabel("QQ号码",JLabel.CENTER);
		jl2=new JLabel("昵称",JLabel.CENTER);
		jl3=new JLabel("性别",JLabel.CENTER);
		jl4=new JLabel("密码",JLabel.CENTER);
		jl5=new JLabel("确认密码",JLabel.CENTER);
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf5=new JTextField();
		jtf3=new JPasswordField();
		jtf4=new JPasswordField();
		
		jb1=new JButton("确定");
		jb1.addActionListener(this);
		jb2=new JButton("重置");
		jb2.addActionListener(this);
		jp=new JPanel(new GridLayout(6,2,4,4));
		
		jp.add(jl1);
		jp.add(jtf1);
		jp.add(jl2);
		jp.add(jtf2);
		jp.add(jl3);
		jp.add(jtf5);
		jp.add(jl4);
		jp.add(jtf3);
		jp.add(jl5);
		jp.add(jtf4);
		jp.add(jb1);
		jp.add(jb2);
		
		this.add(jp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 此时还没有登录：如何处理
		if(e.getSource()==jb1)//确定按钮
		{
			
			IUserSrv ius = new IUserSrvImpl();
			User u = new User();		
			String qqNo = jtf1.getText().trim();
			u.setQqNo(qqNo);
			u.setNickName(jtf2.getText());
			u.setPassword(new String(jtf3.getPassword()));
			u.setSex(jtf5.getText());
			if (qqNo == null || qqNo.isEmpty()) {
				JOptionPane.showMessageDialog(this, "号码不能为空","",JOptionPane.WARNING_MESSAGE);
				return;
			}else if (ClientMainFrmMgr.get(qqNo) != null) {
				JOptionPane.showMessageDialog(this, "此号码已经被注册","",JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			try {
				this.user = ius.register(u);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // 阻塞形式
			
			if(user != null)
			{				
				JOptionPane.showMessageDialog(this, "注册成功","",JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "注册失败","",JOptionPane.WARNING_MESSAGE);
			}
			//
			
		}else if(e.getSource()==jb2){//重置按钮
			jtf1.setText("");
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");
			jtf5.setText("");
		}
		
	}
	/**
	 * @return
	 * @uml.property  name="user"
	 */
	public User getUser() {
		return user;
	}
	
}
