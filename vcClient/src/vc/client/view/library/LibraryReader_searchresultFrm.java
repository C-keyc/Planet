package vc.client.view.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import vc.list.common.Book;
import vc.list.common.User;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LibraryReader_searchresultFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4345296496662144481L;
	private JPanel contentPane;
	private User owner;
	private String str;
	private Book bk;
	public LibraryReader_searchresultFrm(User u,Book bk) {
		this.owner = u;
		this.bk = bk;
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryReader_searchresultFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u7C4D\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 38, 97, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5269\u4F59\u6570\u91CF\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(50, 161, 97, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel bookname = new JLabel(bk.getBookName());
		bookname.setFont(new Font("宋体", Font.PLAIN, 18));
		bookname.setBounds(161, 38, 197, 34);
		contentPane.add(bookname);
		
		JLabel booknum = new JLabel(bk.getBookNum());
		booknum.setBounds(161, 161, 174, 34);
		contentPane.add(booknum);
		
		JButton button = new JButton("\u786E  \u5B9A");
		
		button.setBackground(new Color(245, 245, 245));
		button.setFont(new Font("宋体", Font.PLAIN, 28));
		button.setBounds(121, 222, 137, 46);
		contentPane.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F5C    \u8005\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(50, 121, 90, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel writer = new JLabel(bk.getBookWriter());
		writer.setFont(new Font("宋体", Font.PLAIN, 18));
		writer.setBounds(161, 114, 197, 34);
		contentPane.add(writer);
		
		JLabel bookID = new JLabel(bk.getBookID());
		bookID.setFont(new Font("宋体", Font.PLAIN, 18));
		bookID.setBounds(161, 82, 197, 34);
		contentPane.add(bookID);
		
		JLabel lblNewLabel_3 = new JLabel("\u4E66\u7C4D\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(50, 75, 95, 43);
		contentPane.add(lblNewLabel_3);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "是否关闭？");
				dispose();
			}
		});
	}

	}

