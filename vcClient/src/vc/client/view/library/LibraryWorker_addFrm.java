package vc.client.view.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Book;
import vc.list.common.User;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryWorker_addFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7486595713472290389L;
	private JPanel contentPane;
	private JTextField bookID;
	private JTextField bookname;
	private JTextField booknumber;
	private JTextField bookwriter;
	private UserSrvImpl usrv = new UserSrvImpl();
	private User owner;
	private JTextField bookpublish;
	



	public LibraryWorker_addFrm(User u) {
		this.owner = u;
		LibraryWorkerAddMgr.add(owner.getUserID(), this);
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryWorker_addFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u7C4D\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(95, 40, 100, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E66\u7C4D\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(95, 93, 90, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4E66\u7C4D\u6570\u91CF\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(95, 253, 90, 35);
		contentPane.add(lblNewLabel_2);
		
		bookID = new JTextField();
		bookID.setBounds(199, 40, 185, 39);
		contentPane.add(bookID);
		bookID.setColumns(10);
		
		bookname = new JTextField();
		bookname.setBounds(199, 92, 185, 41);
		contentPane.add(bookname);
		bookname.setColumns(10);
		
		booknumber = new JTextField();
		booknumber.setBounds(199, 252, 185, 40);
		contentPane.add(booknumber);
		booknumber.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BF7\u8F93\u5165\u4E66\u7C4D\u4FE1\u606F\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(69, 0, 306, 42);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = bookID.getText().trim();
				String name = bookname.getText().trim();
				String writer = bookwriter.getText().trim();
				String pub = bookpublish.getText().trim();
				String num = booknumber.getText().trim();
				Book bk = new Book(id,name,writer,pub,num);
				LibraryWorker_manageFrm libraryWorker_manageFrm = LibraryWorkerMgr.get(owner.getUserID());
				usrv.addBook(owner,bk);
				//usrv.checkAllBook(owner);
				dispose();
				
				
			}
		});
		btnNewButton.setBackground(new Color(245, 255, 250));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 28));
		btnNewButton.setBounds(166, 331, 153, 49);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(116, 146, 91, 37);
		contentPane.add(lblNewLabel_4);
		
		bookwriter = new JTextField();
		bookwriter.setBounds(199, 146, 185, 40);
		contentPane.add(bookwriter);
		bookwriter.setColumns(10);
		
		bookpublish = new JTextField();
		bookpublish.setColumns(10);
		bookpublish.setBounds(199, 199, 185, 40);
		contentPane.add(bookpublish);
		
		JLabel label = new JLabel("\u4E66\u7C4D\u51FA\u7248\u793E\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(81, 208, 126, 18);
		contentPane.add(label);
	}
}
