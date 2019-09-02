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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryReader_checkrecordFrm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable recordtable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryReader_checkrecordFrm frame = new LibraryReader_checkrecordFrm();
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
	public LibraryReader_checkrecordFrm() {
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
				{null, null, null, null, null},
			},
			new String[] {
				"\u4E66\u7C4D\u7F16\u53F7", "\u4E66\u7C4D\u540D\u79F0", "\u501F\u9605\u65F6\u95F4", "\u5F52\u8FD8\u72B6\u6001", "\u5269\u4F59\u65F6\u95F4"
			}
		));
		recordtable.setRowHeight(30);
		
		JLabel lblNewLabel = new JLabel("\u4E00\u5361\u901A\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
		lblNewLabel.setBounds(14, 13, 106, 44);
		contentPane.add(lblNewLabel);
		
		JLabel eID = new JLabel("");
		eID.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
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
		OK.setFont(new Font("ËÎÌו", Font.PLAIN, 28));
		OK.setBounds(217, 305, 113, 49);
		contentPane.add(OK);
		

	}
}
