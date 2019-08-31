package vc.client.view.choosecourse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;


public class courseSCheck extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseSCheck frame = new courseSCheck();
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
	public courseSCheck() {
		setTitle("\u67E5\u770B\u6211\u7684\u8BFE\u8868");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBackground(Color.WHITE);
		table.setFont(new Font("仿宋", Font.PLAIN, 18));
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u4EFB\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65F6\u95F4"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			//调用数据库显示表格内容
			new String[] {
				"courseID", "courseName", "courseTeacher", "courseTime"
			}
		));
		table.setBounds(56, 65, 300, 44);
		contentPane.add(table);
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(273, 200, 123, 29);
		contentPane.add(button);
	}
}
