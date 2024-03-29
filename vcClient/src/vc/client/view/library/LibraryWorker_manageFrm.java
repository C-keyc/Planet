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

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Book;
import vc.list.common.BookRecord;
import vc.list.common.User;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class LibraryWorker_manageFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1259967030966304303L;
	private JPanel contentPane;
	private JTable bookmanage;
	private JButton toadd;
	private JButton todelete;
	private DefaultTableModel tablemodel;// 表格模型
	private UserSrvImpl usrv = new UserSrvImpl();
	private List<Book> bklist;
	private Object[][] data;
	private User owner;
	private JTextField textField;
	JComboBox<String> comboBox;

	public LibraryWorker_manageFrm(User user) {

		this.owner = user;
		LibraryWorkerMgr.add(user.getUserID(), this);
		usrv.checkAllBook(owner);
		//initialize();

	}

	/**
	 * 
	 */
	public void initialize() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(LibraryWorker_manageFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 40, 680, 300);
		contentPane.add(scrollPane);

		bookmanage = new JTable();
		bookmanage.setBackground(new Color(255, 255, 240));
		scrollPane.setViewportView(bookmanage);
		data = getTableData(bklist);
		bookmanage.setModel(new DefaultTableModel(data, new String[] { "书籍编号", "书籍名称", "书籍作者", "书籍出版社", "书籍数量" }));

		bookmanage.setRowHeight(30);

		toadd = new JButton("\u589E\u52A0\u4E66\u7C4D");
		toadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LibraryWorker_addFrm windowa = new LibraryWorker_addFrm(owner);
				windowa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				windowa.setVisible(true);
			}
		});
		toadd.setBackground(new Color(245, 255, 250));
		toadd.setFont(new Font("宋体", Font.PLAIN, 28));
		toadd.setBounds(186, 491, 157, 41);
		contentPane.add(toadd);

		todelete = new JButton("\u5220\u9664\u4E66\u7C4D");
		todelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = bookmanage.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) bookmanage.getModel();
				
				//System.out.print(id);
				
				if (row !=-1) {
					String id = data[row][0].toString();
					model.removeRow(row);
					usrv.deleteBook(owner, id);
					JOptionPane.showMessageDialog(contentPane, "删除成功！", "删除结果", JOptionPane.PLAIN_MESSAGE);
				}
				else {
				JOptionPane.showMessageDialog(contentPane, "请选择一行数据", "删除结果", JOptionPane.WARNING_MESSAGE);}}

			
		});
		todelete.setBackground(new Color(245, 255, 250));
		todelete.setFont(new Font("宋体", Font.PLAIN, 28));
		todelete.setBounds(449, 491, 151, 41);
		contentPane.add(todelete);
		
		comboBox = new JComboBox<String>();
		comboBox.insertItemAt("按书籍编号", 0);
		comboBox.insertItemAt("按书籍名称",1);
		comboBox.insertItemAt("按作者", 2);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(60, 405, 113, 30);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(206, 406, 418, 30);
		contentPane.add(textField);
		
		JButton btnSearch = new JButton("\u641C\u7D22");
		btnSearch.setFont(new Font("黑体", Font.PLAIN, 16));
		btnSearch.setBounds(660, 404, 80, 30);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String str = textField.getText().trim();
						int selectedIndex = comboBox.getSelectedIndex();
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
		contentPane.add(btnSearch);
		
		JLabel label = new JLabel("\u67E5\u8BE2\u4E66\u7C4D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(60, 363, 106, 32);
		contentPane.add(label);
		repaint();
	}

	public Object[][] getTableData(List<Book> bklist) {
		int Num = bklist.size();
		Object[][] data = new Object[Num][5];
		for (int i = 0; i < Num; i++) {
			for (int j = 0; j < 5; j++) {
				switch (j) {
				case 0:
					data[i][j] = bklist.get(i).getBookID();
					break;
				case 1:
					data[i][j] = bklist.get(i).getBookName();
					break;
				case 2:
					data[i][j] = bklist.get(i).getBookWriter();
					break;
				case 3:
					data[i][j] = bklist.get(i).getBookPublish();
					break;
				case 4:
					data[i][j] = bklist.get(i).getBookNum();
					break;
				default:
					break;

				}
			}
		}
		return data;
	}

	public void refresh() {

		data = getTableData(bklist);
		bookmanage.setModel(new DefaultTableModel(data, new String[] { "书籍编号", "书籍名称", "书籍作者", "书籍出版社", "书籍数量" }));
		contentPane.validate();
		contentPane.repaint();
	}

	public List<Book> getBklist() {
		return bklist;
	}

	public void setBklist(List<Book> bklist) {
		this.bklist = bklist;
	}
}
