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

public class LibraryReader_searchNotresultFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4345296496662144481L;
	private JPanel contentPane;
	private User owner;
	private String str;

	public LibraryReader_searchNotresultFrm(User u) {
		this.owner = u;

		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryReader_searchNotresultFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 253);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u786E  \u5B9A");
		
		button.setBackground(new Color(245, 245, 245));
		button.setFont(new Font("宋体", Font.PLAIN, 28));
		button.setBounds(124, 119, 137, 46);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("\u62B1\u6B49\uFF0C\u6CA1\u6709\u627E\u5230\u76F8\u5173\u4E66\u7C4D!");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(52, 50, 309, 29);
		contentPane.add(lblNewLabel);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "是否关闭？");
				dispose();
			}
		});
	}

	}

