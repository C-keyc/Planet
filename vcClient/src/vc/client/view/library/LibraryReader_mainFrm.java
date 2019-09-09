package vc.client.view.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Book;
import vc.list.common.BookRecord;
import vc.list.common.Goods;
import vc.list.common.Message;

import vc.list.common.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class LibraryReader_mainFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -558541361441249042L;
	private JPanel contentPane;
	private JTable recordtable;
	private UserSrvImpl usrv = new UserSrvImpl();
	private User owner;
	private List<BookRecord> bkrlist = new ArrayList<BookRecord>();
	private JTextField textField;

	private JComboBox<String> combobox= new JComboBox<>(); 


	/**
	 * Launch the application.
	 */



	/**
	 * Create the frame.
	 */

	public LibraryReader_mainFrm(User user)
	{
		this.owner=user;		
		LibraryReaderMgr.add(user.getUserID(), this);  //放入这个gui的表集合里，相应消息时拿出来
		CheckBook();
		//initialize();
	}
	
	public void initialize() {

		setVisible(false);

		setBackground(new Color(240, 255, 255));
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryReader_mainFrm.class.getResource("/image/logo.jpg")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 94, 650, 275);
		contentPane.add(scrollPane);
		
		JTable recordtable = new JTable();
		recordtable.setBackground(new Color(255, 255, 240));
		scrollPane.setViewportView(recordtable);
		Object[][] data = getTableData(bkrlist);
		recordtable.setModel(new DefaultTableModel(
			data,
			new String[] {
				"\u4E66\u7C4D\u7F16\u53F7", "\u4E66\u7C4D\u540D\u79F0", "\u501F\u9605\u65F6\u95F4", "\u5F52\u8FD8\u72B6\u6001", "\u5269\u4F59\u65F6\u95F4"
			}
		));
		recordtable.setRowHeight(30);
		
		JLabel lblNewLabel = new JLabel("\u4E00\u5361\u901A\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 20, 100, 30);
		contentPane.add(lblNewLabel);
		
		JLabel eID = new JLabel(owner.getUserID());
		eID.setFont(new Font("宋体", Font.PLAIN, 18));
		eID.setBounds(115, 20, 160, 30);
		contentPane.add(eID);
		
		JButton btnReserve = new JButton("\u9884\u7EA6\u5EA7\u4F4D");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LibraryReader_reservationFrm windowr = new LibraryReader_reservationFrm(owner);
				windowr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				windowr.setVisible(true);
			}
		});
		btnReserve.setFont(new Font("宋体", Font.PLAIN, 18));
		btnReserve.setBounds(626, 17, 122, 37);
		contentPane.add(btnReserve);
		
		
		combobox.setBounds(60, 452, 113, 30);
		combobox.insertItemAt("按书籍编号", 0);
		combobox.insertItemAt("按书籍名称",1);
		combobox.insertItemAt("按作者", 2);
		combobox.setSelectedIndex(0);
		contentPane.add(combobox);
		
		textField = new JTextField();
		textField.setBounds(205, 452, 396, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("\u641C\u7D22");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String str = textField.getText().trim();
						int selectedIndex = combobox.getSelectedIndex();
						if(textField.getText().length()==0||textField.getText().equals("")) {
							JOptionPane.showMessageDialog(contentPane, "请输入搜索内容！","提示",JOptionPane.WARNING_MESSAGE);
						}else {
						if(selectedIndex==0) {			
							usrv.queryBookID(owner,str);
							textField.setText("");
						}
						if(selectedIndex==1) {
							usrv.queryBookName(owner,str);
							textField.setText("");
						}
						 if(selectedIndex==2) {
							usrv.queryBookWriter(owner,str);
							textField.setText("");
						}
						}
					}
				});
		btnSearch.setFont(new Font("黑体", Font.PLAIN, 16));
		btnSearch.setBounds(630, 452, 80,30);
		contentPane.add(btnSearch);
		
		JLabel lblNewLabel_1 = new JLabel("\u67E5\u8BE2\u4E66\u7C4D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(60, 410, 106, 18);
		contentPane.add(lblNewLabel_1);
		repaint();

	}
	public Object[][] getTableData(List<BookRecord> bkrlist)
	{
		int Num = bkrlist.size();
		Object[][]data = new Object[Num][5];
		for(int i = 0;i<Num;i++)
		{
			for(int j = 0;j<5;j++)
			{
				switch(j)
				{
					case 0:
						data[i][j]=bkrlist.get(i).getBookRecordID();
						break;
					case 1:
						data[i][j]=bkrlist.get(i).getBookRecordName();
						break;
					case 2:
						data[i][j]=bkrlist.get(i).getBookRecordDate();
						break;
					case 3:
						data[i][j]=bkrlist.get(i).getBookRecordState();
						break;
					case 4:
						data[i][j]=bkrlist.get(i).getBookRecordLeftTime();
						break;
					 default:
						break;
					
				}
			}
		}
		return data;
	}
	
	
	public void CheckBook() {
		
		Message msg = new Message();
		msg.setType("CMD_CHECK_BOOK");
		msg.setSender(owner);
		System.out.println("LibararyReader:客户端发送信息成功！");
		
		try {
			usrv.sendMessage(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public List<BookRecord> getBkrlist() {
		return bkrlist;
	}

	public void setBkrlist(List<BookRecord> bkrlist) {
		this.bkrlist = bkrlist;
	}
}
