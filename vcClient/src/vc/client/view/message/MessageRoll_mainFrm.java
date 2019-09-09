package vc.client.view.message;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vc.client.bz.impl.UserSrvImpl;

import vc.list.common.Student;
import vc.list.common.User;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class MessageRoll_mainFrm extends JFrame {

	private JPanel contentPane;
	private JTable tblMessage;
	boolean tableEditable = false;
	private Object[][] tabledata;
	private DefaultTableModel tablemodel;//表格模型
	JComboBox<String> comboBox;
	private JTextField textSearchInput;
	//新增类的属性
	
	private User owner;
	private List<Student> stlist;
	private UserSrvImpl usrv = new UserSrvImpl();
	private boolean COMMUNICATE_FINISHED =false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new User();
					MessageRoll_mainFrm frame = new MessageRoll_mainFrm(u);
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
	public MessageRoll_mainFrm(User user) {
		setResizable(false);
		this.owner=user;
		setVisible(false);
		MessageRoll_mainMgr.add(owner.getUserID(), this);
		try {
			if(owner.getType()!=1)
				usrv.getAllStudents(owner);
			else {
				Student st =new Student();
				st.setStudentID(owner.getUserID());
				usrv.queryStudentID(owner,st);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//initialize();
		
		
	}
	
	public void initialize() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5B66\u7C4D\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MessageRoll_mainFrm.class.getResource("/image/logo.jpg")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 800, 600);
		this.setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index =comboBox.getSelectedIndex();
				String str =textSearchInput.getText();
				Student st =new Student();
				if(str.length()==0)
					JOptionPane.showMessageDialog(contentPane, "没有输入信息", "", JOptionPane.INFORMATION_MESSAGE);
				else {
					try{
						if(index==0) 
							{st.setStudentName(str);
							usrv.queryStudentName(owner, st);}
						if(index==1) 
							{st.setStudentNum(str);
							usrv.queryStudentNum(owner, st);}
						if(index==2) 
							{st.setStudentID(str);
							usrv.queryStudentID(owner, st);}
						if(index==3) 
							{st.setStudentDepartment(str);
							usrv.queryStudentDepartment(owner, st);}
						if(index==4) 
							{st.setStudentMajor(str);
							usrv.queryStudentMajor(owner, st);}
						if(index==5) 
							{st.setStudentGrade(str);
							usrv.queryStudentGrade(owner, st);}
								
					} catch (IOException eIO) {
						eIO.printStackTrace();
					  }
				}
			}
		});
		btnSearch.setFont(new Font("宋体", Font.PLAIN, 15));
		btnSearch.setBounds(645,79, 108, 30);
		btnSearch.setVisible(false);
		btnSearch.setEnabled(false);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("\u589E\u52A0\u5B66\u7C4D\u4FE1\u606F");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageRoll_addDlg dialog = new MessageRoll_addDlg(owner);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("宋体", Font.PLAIN, 15));
		btnAdd.setBounds(36, 437, 128, 38);
		btnAdd.setVisible(false);
		btnAdd.setEnabled(false);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("\u5220\u9664\u5B66\u7C4D\u4FE1\u606F");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblMessage.getSelectedRow();
				if(selectedRow<0)
					JOptionPane.showMessageDialog(contentPane, "没有选中的学生", "提示", JOptionPane.INFORMATION_MESSAGE);
				else {
					String stID= (String) tablemodel.getValueAt(selectedRow, 1);
					Student st1 = new Student();
					st1.setStudentID(stID);
					try {
						usrv.deleteStudent(owner,st1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    	    }
			}
		});
		btnDelete.setFont(new Font("宋体", Font.PLAIN, 15));
		btnDelete.setBounds(331, 437, 128, 38);
		btnDelete.setVisible(false);
		btnDelete.setEnabled(false);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("\u4FEE\u6539\u5B66\u7C4D\u4FE1\u606F");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableEditable==false) {
					tableEditable=true;
					JOptionPane.showMessageDialog(contentPane, "修改后输入回车确认", "提示", JOptionPane.INFORMATION_MESSAGE);
					btnUpdate.setText("完成修改");
					btnAdd.setEnabled(false);
					btnDelete.setEnabled(false);
					btnSearch.setEnabled(false);
				}
				else
				{
					tableEditable=false;
					btnUpdate.setText("\u4FEE\u6539\u5B66\u7C4D\u4FE1\u606F");
					btnAdd.setEnabled(true);
					btnDelete.setEnabled(true);
					btnSearch.setEnabled(true);
				}
			}
		});
		btnUpdate.setFont(new Font("宋体", Font.PLAIN, 15));
		btnUpdate.setBounds(625, 437, 128, 38);
		btnUpdate.setVisible(false);
		btnUpdate.setEnabled(false);
		contentPane.add(btnUpdate);
		
		
		
		
		String type="";
		if(owner.getType()==1)
			type="同学";
		if(owner.getType()==2)
			type="老师";
		if(owner.getType()==3)
			type="管理员";
		String welcome ="欢迎您，"+owner.getUname()+" "+type+"!";
		JLabel lbWelcome = new JLabel(welcome);
		lbWelcome.setFont(new Font("楷体", Font.PLAIN, 20));
		lbWelcome.setBounds(36, 25, 277, 30);
		contentPane.add(lbWelcome);
		
		/*JLabel lblNameXX = new JLabel("\u59D3\u540DXX");
		lblNameXX.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNameXX.setBounds(81, 25, 90, 30);
		contentPane.add(lblNameXX);
		
		JLabel lblECard = new JLabel("\u4E00\u5361\u901A\u53F7\uFF1A");
		lblECard.setFont(new Font("宋体", Font.PLAIN, 16));
		lblECard.setBounds(176, 25, 80, 30);
		contentPane.add(lblECard);
		
		JLabel lblECardXX = new JLabel("\u4E00\u5361\u901A\u53F7XX");
		lblECardXX.setFont(new Font("宋体", Font.PLAIN, 16));
		lblECardXX.setBounds(256, 25, 143, 30);
		contentPane.add(lblECardXX);
		
		JLabel lblIdentity = new JLabel("\u8EAB\u4EFD\uFF1A");
		lblIdentity.setFont(new Font("宋体", Font.PLAIN, 16));
		lblIdentity.setBounds(403, 25, 50, 30);
		contentPane.add(lblIdentity);
		
		JLabel lblIdentityXX = new JLabel("\u8EAB\u4EFDXX");
		lblIdentityXX.setFont(new Font("宋体", Font.PLAIN, 16));
		lblIdentityXX.setBounds(448, 25, 90, 30);
		contentPane.add(lblIdentityXX);*/
		
		tblMessage = new JTable();
		tblMessage.setBackground(new Color(255, 255, 240));
		tblMessage.setRowHeight(30);
		
		
		tabledata = setTabledata(stlist);
		tablemodel =new DefaultTableModel(
				tabledata,
				new String[] {
						"\u59D3\u540D", "\u4E00\u5361\u901A\u53F7", "\u5B66\u53F7", "\u5165\u5B66\u5E74\u4EFD", "\u9662\u7CFB", "\u4E13\u4E1A", "\u73ED\u7EA7", "\u5B66\u5236", "\u662F\u5426\u5728\u7C4D", "\u662F\u5426\u5728\u6821"
					}
			) 
		{
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				public boolean isCellEditable(int row, int column) {
					if(column==1)
						return false;
					return tableEditable;
				}
			};
		tablemodel.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				int type = e.getType();
				int row = e.getFirstRow();
				int column = e.getColumn();
				if (type == TableModelEvent.UPDATE) {
					System.out.println("此事件是由\"修改\"触发，在"+row+"行"+ column +"列");
					String str=(String) tablemodel.getValueAt(row, column);
					String stID=(String) tablemodel.getValueAt(row, 1);
					try {
						usrv.updateStudent(owner,str,stID,column);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		tblMessage.setModel(tablemodel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 127, 717, 246);
		scrollPane.setViewportView(tblMessage);
		contentPane.add(scrollPane);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox.setBounds(90, 79, 98, 30);
		comboBox.insertItemAt("姓名 ", 0);
		comboBox.insertItemAt("学号 ", 1);
		comboBox.insertItemAt("一卡通 ", 2);
		comboBox.insertItemAt("院系 ", 3);
		comboBox.insertItemAt("专业 ", 4);
		comboBox.insertItemAt("入学年份 ", 5);
		comboBox.setSelectedIndex(0);
		comboBox.setVisible(false);
		contentPane.add(comboBox);
		
		textSearchInput = new JTextField();
		textSearchInput.setFont(new Font("宋体", Font.PLAIN, 15));
		textSearchInput.setBounds(193, 79, 442, 30);
		textSearchInput.setVisible(false);
		textSearchInput.setEnabled(false);
		contentPane.add(textSearchInput);
		//textSearchInput.setColumns(10);
		
		JLabel label = new JLabel("\u67E5\u8BE2\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(36, 79, 58, 30);
		label.setVisible(false);
		contentPane.add(label);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 获取当前屏幕大小
		Dimension frameSize = this.getSize();// 获取当前窗口大小
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);// 保持窗口弹出位置居中
		
		if(owner.getType() == 3){
			btnSearch.setVisible(true);
			btnSearch.setEnabled(true);
			label.setVisible(true);
			textSearchInput.setVisible(true);
			textSearchInput.setEnabled(true);
			comboBox.setVisible(true);
			comboBox.setEnabled(true);
			btnAdd.setVisible(true);
			btnAdd.setEnabled(true);
			btnDelete.setVisible(true);
			btnDelete.setEnabled(true);
			btnUpdate.setVisible(true);
			btnUpdate.setEnabled(true);
			}//管理员界面所有按钮可见且可使用
			
			if(owner.getType() == 2){
			btnSearch.setVisible(true);
			btnSearch.setEnabled(true);
			label.setVisible(true);
			textSearchInput.setVisible(true);
			textSearchInput.setEnabled(true);
			comboBox.setVisible(true);
			comboBox.setEnabled(true);
			}//教师界面仅可查询，其他按钮不可见
		repaint();
	}
	
	
	public void setStList(List<Student> stlist) {
		this.stlist = stlist;
	}
	public void setCOMMUNICATE_FINISHED(boolean COMMUNICATE_FINISHED) {
		this.COMMUNICATE_FINISHED = COMMUNICATE_FINISHED;
	}
	public Object[][] setTabledata(List<Student> StList){
		int stNum = StList.size();
		if(stNum>0) {
		Object[][] data = new Object[stNum][10];
		for(int i = 0;i<stNum;i++)
			for(int j = 0;j<10;j++)
			{
				switch(j) {
				case 0:
					data[i][j]=StList.get(i).getStudentName();break;
				case 1:
					data[i][j]=StList.get(i).getStudentID();break;
				case 2:
					data[i][j]=StList.get(i).getStudentNum();break;
				case 3:
					data[i][j]=StList.get(i).getStudentGrade();break;
				case 4:
					data[i][j]=StList.get(i).getStudentDepartment();break;
				case 5:
					data[i][j]=StList.get(i).getStudentMajor();break;
				case 6:
					data[i][j]=StList.get(i).getStudentClass();break;
				case 7:
					data[i][j]=StList.get(i).getStudentLength();break;
				case 8:
					data[i][j]=StList.get(i).getStudentRe();break;
				case 9:
					data[i][j]=StList.get(i).getStudentinSchool();break;
				}
			}
		
		return data;
		}
		else {
			return null;
		}
	}
	
	public JPanel getPanel() {
		return contentPane;
	}
}
