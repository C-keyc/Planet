package vc.client.view.choosecourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class courseStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseStudent frame = new courseStudent();
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
	public courseStudent() {
		setTitle("\u6B22\u8FCE\u6765\u5230\u9009\u8BFE\u7CFB\u7EDF");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u767B\u9646\u8EAB\u4EFD\uFF1A");
		label.setBounds(33, 15, 95, 21);
		contentPane.add(label);
		
		//把姓名和ID覆盖掉
		JLabel label_1 = new JLabel("\u5B66\u751F");
		label_1.setBounds(131, 15, 81, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6570\u5B57");
		label_2.setBounds(501, 15, 81, 21);
		contentPane.add(label_2);
		
		JLabel lblid = new JLabel("\u9009\u8BFEID\uFF1A");
		lblid.setBounds(35, 84, 81, 21);
		contentPane.add(lblid);
		
		JLabel lblid_1 = new JLabel("\u9000\u8BFEID\uFF1A");
		lblid_1.setBounds(35, 148, 81, 21);
		contentPane.add(lblid_1);
		
		textField = new JTextField();
		textField.setBounds(127, 81, 96, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 145, 96, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u9009\u8BFE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		  //调用数据库来判断输入的课程ID是否正确，根据输入的正确与否来弹出不同的对话框
				courseSOK ok=new courseSOK();
				ok.setVisible(true);
				//	choosecourseNOT not=new choosecourseNOT();
				//   not.setVisible(true);
			}
		});
		button.setBounds(392, 80, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u8BFE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//调用数据库来判断输入的课程ID是否正确，根据输入的正确与否来弹出不同的对话框
				courseSOK ok=new courseSOK();
				ok.setVisible(true);
				//	choosecourseNOT not=new choosecourseNOT();
				//   not.setVisible(true);
			}
		});
		button_1.setBounds(392, 144, 123, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u67E5\u770B\u5DF2\u9009\u8BFE\u7A0B");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				courseSCheck check=new courseSCheck();
				check.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				check.setVisible(true);
			}
		});
		button_2.setBounds(250, 206, 163, 29);
		contentPane.add(button_2);
		
		JLabel label_3 = new JLabel("\u6240\u6709\u8BFE\u7A0B\uFF1A");
		label_3.setBounds(33, 270, 112, 21);
		contentPane.add(label_3);
		
		table = new JTable();
		table.setBounds(215, 296, 1, 1);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u4EFB\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65F6\u95F4"},
				{"1", "\u8F6F\u4EF6\u5B9E\u8DF5", "\u6C88\u50B2\u4E1C", "\u5468\u4E00\u4E0A\u5348\u516B\u70B9"},
				{"2", "\u8BA1\u7EC4\u5B9E\u9A8C", "\u4EFB\u56FD\u6797", "\u5468\u4E8C\u4E0B\u5348\u4E09\u70B9"},
			},
			new String[] {
					"courseID", "courseName", "courseTeacher", "courseTime"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(87);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(124);
		table_1.setBounds(159, 266, 370, 60);
		contentPane.add(table_1);
		
		JLabel lblId = new JLabel("ID\uFF1A");
		lblId.setBounds(392, 15, 81, 21);
		contentPane.add(lblId);
	}
}
