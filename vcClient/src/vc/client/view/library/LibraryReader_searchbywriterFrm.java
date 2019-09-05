package vc.client.view.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import vc.list.common.Book;
import vc.list.common.BookRecord;
import vc.list.common.User;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class LibraryReader_searchbywriterFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1722606180305232799L;
	private JPanel contentPane;
	private JTable searchresult;
	private User owner;
	private List<Book> bklist;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param bklist 
	 */
	public LibraryReader_searchbywriterFrm(User u, List<Book> bklist) {
		this.owner=u;
		this.bklist=bklist;
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryReader_searchbywriterFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 54, 525, 293);
		contentPane.add(scrollPane);
		
		searchresult = new JTable();
		searchresult.setBackground(new Color(255, 255, 240));
		scrollPane.setViewportView(searchresult);
		Object[][] data = getTableData(bklist);
		searchresult.setModel(new DefaultTableModel(
				data,
			new String[] {
				"书籍编号", "书籍名称", "书籍作者", "书籍出版社","书籍数量"
			}
		));
		searchresult.setRowHeight(30);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 28));
		btnNewButton.setBounds(230, 390, 136, 53);
		contentPane.add(btnNewButton);
	}

	public Object[][] getTableData(List<Book> bklist)
	{
		int Num = bklist.size();
		Object[][]data = new Object[Num][5];
		for(int i = 0;i<Num;i++)
		{
			for(int j = 0;j<5;j++)
			{
				switch(j)
				{
					case 0:
						data[i][j]=bklist.get(i).getBookID();
						break;
					case 1:
						data[i][j]=bklist.get(i).getBookName();
						break;
					case 2:
						data[i][j]=bklist.get(i).getBookWriter();
						break;
					case 3:
						data[i][j]=bklist.get(i).getBookPublish();
						break;
					case 4:
						data[i][j]=bklist.get(i).getBookNum();
						break;
					 default:
						break;
					
				}
			}
		}
		return data;
	}
}
