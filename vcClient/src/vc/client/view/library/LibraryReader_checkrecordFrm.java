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
import vc.client.view.WkManageMgr;
import vc.list.common.Book;
import vc.list.common.BookRecord;
import vc.list.common.Goods;
import vc.list.common.Message;
import vc.list.common.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;

public class LibraryReader_checkrecordFrm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable recordtable;
	private UserSrvImpl usrv = new UserSrvImpl();
	private User owner;
    private BookRecord bkr;
	private List<BookRecord> bkrlist;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public LibraryReader_checkrecordFrm(User user)
	{
		this.owner=user;
				
		LibraryReaderMgr.add(user.getUserID(), this);  //放入这个gui的表集合里，相应消息时拿出来
		CheckBook();
		
		initialize();
	}
	
	private void initialize() {

		setBackground(new Color(240, 255, 255));
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryReader_checkrecordFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 70, 465, 209);
		contentPane.add(scrollPane);
		
		recordtable = new JTable();
		recordtable.setBackground(new Color(255, 255, 240));
		scrollPane.setViewportView(recordtable);
		recordtable.setModel(new DefaultTableModel(
			new Object[][] {
				{bkrlist.get(0).getBookRecordID(), bkrlist.get(1).getBookRecordName(), bkrlist.get(2).getBookRecordDate(), bkrlist.get(3).getBookRecordState(), bkrlist.get(4).getBookRecordLeftTime()},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\u4E66\u7C4D\u7F16\u53F7", "\u4E66\u7C4D\u540D\u79F0", "\u501F\u9605\u65F6\u95F4", "\u5F52\u8FD8\u72B6\u6001", "\u5269\u4F59\u65F6\u95F4"
			}
		));
		recordtable.setRowHeight(30);
		
		JLabel lblNewLabel = new JLabel("\u4E00\u5361\u901A\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(14, 13, 106, 44);
		contentPane.add(lblNewLabel);
		
		JLabel eID = new JLabel("");
		eID.setFont(new Font("宋体", Font.PLAIN, 18));
		eID.setBounds(108, 21, 177, 33);
		contentPane.add(eID);
		
		JButton OK = new JButton("\u786E\u5B9A");
		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LibraryReader_mainFrm.windowc.isVisible())
					LibraryReader_mainFrm.windowc.setVisible(false);
			}
		});
		OK.setBackground(new Color(255, 255, 240));
		OK.setFont(new Font("宋体", Font.PLAIN, 28));
		OK.setBounds(217, 305, 113, 49);
		contentPane.add(OK);
		

	}
	
	
	public void refresh(List<Goods> gdlist) {	
			
		}
	
	public void CheckBook() {
		
		Message msg = new Message();
		msg.setType("CMD_CHECK_BOOK");
		msg.setSender(owner);
		
		
		try {
			usrv.sendMessage(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
