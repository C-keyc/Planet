package vc.client.view.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vc.list.common.User;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class LibraryWorker_manageFrm extends JFrame {

	private JPanel contentPane;
	private JTable bookmanage;
	private JButton toadd;
	private JButton todelete;
	private DefaultTableModel tablemodel;//表格模型

	private User owner;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new User();
					LibraryWorker_manageFrm frame = new LibraryWorker_manageFrm(u);
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
	public LibraryWorker_manageFrm(User user) {
		
		this.owner = user;
		
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryWorker_manageFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 97, 619, 298);
		contentPane.add(scrollPane);
		
		bookmanage = new JTable();
		bookmanage.setBackground(new Color(255, 255, 240));
		scrollPane.setViewportView(bookmanage);
		bookmanage.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u4E66\u7C4D\u7F16\u53F7", "\u4E66\u7C4D\u540D\u79F0", "\u4F5C\u8005", "\u4E66\u7C4D\u6570\u91CF"
			}
		) );
		
		bookmanage.setRowHeight(30);
		
		toadd = new JButton("\u589E\u52A0\u4E66\u7C4D");
		toadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryWorker_addFrm windowa=new LibraryWorker_addFrm();
				windowa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				windowa.setVisible(true);
			}
		});
		toadd.setBackground(new Color(245, 255, 250));
		toadd.setFont(new Font("宋体", Font.PLAIN, 28));
		toadd.setBounds(96, 446, 179, 68);
		contentPane.add(toadd);
		
		todelete = new JButton("\u5220\u9664\u4E66\u7C4D");
		todelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=bookmanage.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) bookmanage.getModel();
				if(row!=-1) {
					model.removeRow(row);
				JOptionPane.showMessageDialog(contentPane, "删除成功！", "删除结果",JOptionPane.PLAIN_MESSAGE); 
				}else {
					JOptionPane.showMessageDialog(contentPane, "请选择一行数据", "删除结果",JOptionPane.WARNING_MESSAGE); 
				}
				
			}
		});
		todelete.setBackground(new Color(245, 255, 250));
		todelete.setFont(new Font("宋体", Font.PLAIN, 28));
		todelete.setBounds(496, 446, 179, 68);
		contentPane.add(todelete);
	}
}
