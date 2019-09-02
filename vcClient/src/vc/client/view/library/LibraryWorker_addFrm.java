package vc.client.view.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	private JPanel contentPane;
	private JTextField bookID;
	private JTextField bookname;
	private JTextField booknumber;
	private JTextField writer;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryWorker_addFrm frame = new LibraryWorker_addFrm();
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
	public LibraryWorker_addFrm() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryWorker_addFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u7C4D\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(69, 89, 100, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E66\u7C4D\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(69, 143, 90, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4E66\u7C4D\u6570\u91CF\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(69, 191, 90, 35);
		contentPane.add(lblNewLabel_2);
		
		bookID = new JTextField();
		bookID.setBounds(199, 92, 185, 39);
		contentPane.add(bookID);
		bookID.setColumns(10);
		
		bookname = new JTextField();
		bookname.setBounds(199, 141, 185, 41);
		contentPane.add(bookname);
		bookname.setColumns(10);
		
		booknumber = new JTextField();
		booknumber.setBounds(199, 190, 185, 40);
		contentPane.add(booknumber);
		booknumber.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BF7\u8F93\u5165\u4E66\u7C4D\u4FE1\u606F\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(69, 34, 306, 42);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(true) {
					JOptionPane.showMessageDialog(contentPane, "添加成功.", "添加结果",JOptionPane.PLAIN_MESSAGE); 
				}else {
					JOptionPane.showMessageDialog(contentPane, "添加失败！", "添加结果",JOptionPane.YES_OPTION); 
				}
			}
		});
		btnNewButton.setBackground(new Color(245, 255, 250));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 28));
		btnNewButton.setBounds(145, 288, 153, 49);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("\u4F5C   \u8005\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(75, 239, 91, 37);
		contentPane.add(lblNewLabel_4);
		
		writer = new JTextField();
		writer.setBounds(199, 238, 185, 40);
		contentPane.add(writer);
		writer.setColumns(10);
	}
}
