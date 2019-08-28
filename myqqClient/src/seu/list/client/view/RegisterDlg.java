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
		this.setIconImage((new ImageIcon("image/ͷ��.GIF").getImage()));
		this.setTitle("QQ�û�ע��");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   //��ȡ��ǰ��Ļ��С
		Dimension frameSize = this.getPreferredSize();//��ȡ��ǰ���ڴ�С
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);//���ִ��ڵ���λ�þ���
		//this.setVisible(true);
	}
	public void initWidgets() {
		jl1=new JLabel("QQ����",JLabel.CENTER);
		jl2=new JLabel("�ǳ�",JLabel.CENTER);
		jl3=new JLabel("�Ա�",JLabel.CENTER);
		jl4=new JLabel("����",JLabel.CENTER);
		jl5=new JLabel("ȷ������",JLabel.CENTER);
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf5=new JTextField();
		jtf3=new JPasswordField();
		jtf4=new JPasswordField();
		
		jb1=new JButton("ȷ��");
		jb1.addActionListener(this);
		jb2=new JButton("����");
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
		// ��ʱ��û�е�¼����δ���
		if(e.getSource()==jb1)//ȷ����ť
		{
			
			IUserSrv ius = new IUserSrvImpl();
			User u = new User();		
			String qqNo = jtf1.getText().trim();
			u.setQqNo(qqNo);
			u.setNickName(jtf2.getText());
			u.setPassword(new String(jtf3.getPassword()));
			u.setSex(jtf5.getText());
			if (qqNo == null || qqNo.isEmpty()) {
				JOptionPane.showMessageDialog(this, "���벻��Ϊ��","",JOptionPane.WARNING_MESSAGE);
				return;
			}else if (ClientMainFrmMgr.get(qqNo) != null) {
				JOptionPane.showMessageDialog(this, "�˺����Ѿ���ע��","",JOptionPane.WARNING_MESSAGE);
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
			} // ������ʽ
			
			if(user != null)
			{				
				JOptionPane.showMessageDialog(this, "ע��ɹ�","",JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "ע��ʧ��","",JOptionPane.WARNING_MESSAGE);
			}
			//
			
		}else if(e.getSource()==jb2){//���ð�ť
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
