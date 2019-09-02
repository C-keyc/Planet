package vc.client.view.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import vc.client.view.WkManageMgr;


import vc.list.common.User;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryReader_mainFrm extends JFrame {

	private JPanel contentPane;
	public static LibraryReader_checkrecordFrm windowc;
	public static LibraryReader_reservationFrm windowr;
	public static LibraryReader_searchFrm windows;
	private User owner;

	/**
	 * Launch the application.
	 */





	/**
	 * Create the frame.
	 */

	
	public LibraryReader_mainFrm(User user) {
			
		this.owner=user;
		initialize();
		
	}
	private void initialize(){

		

		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryReader_mainFrm.class.getResource("/image/logo.jpg")));
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setForeground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u6765\u5230\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 45));
		lblNewLabel.setBounds(37, 121, 711, 139);
		contentPane.add(lblNewLabel);
		
		JButton tocheck = new JButton("\u67E5\u8BE2\u501F\u9605\u8BB0\u5F55");
		tocheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowc=new LibraryReader_checkrecordFrm(owner);
				windowc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				windowc.setVisible(true);
			}
		});
		tocheck.setFont(new Font("宋体", Font.PLAIN, 18));
		tocheck.setBounds(89, 382, 170, 70);
		contentPane.add(tocheck);
		
		JButton toreservation = new JButton("\u9884\u7EA6\u5EA7\u4F4D");
		toreservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowr=new LibraryReader_reservationFrm(owner);
				windowr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				windowr.setVisible(true);
			}
		});
		toreservation.setFont(new Font("宋体", Font.PLAIN, 18));
		toreservation.setBounds(296, 384, 170, 70);
		contentPane.add(toreservation);
		
		JButton tosearch = new JButton("\u67E5\u8BE2\u4E66\u7C4D");
		tosearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windows=new LibraryReader_searchFrm(owner);
				windows.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				windows.setVisible(true);
			}
		});
		tosearch.setFont(new Font("宋体", Font.PLAIN, 18));
		tosearch.setBounds(499, 382, 170, 70);
		contentPane.add(tosearch);
	}

}
