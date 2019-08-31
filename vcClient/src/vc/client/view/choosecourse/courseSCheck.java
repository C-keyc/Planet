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
import javax.swing.JScrollPane;


public class courseSCheck extends JFrame {

	private JPanel contentPane;
	private JTable table_checkstudentcourse;
	private JScrollPane scrollPane;

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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 65, 363, 79);
		contentPane.add(scrollPane);
		
		table_checkstudentcourse = new JTable();
		scrollPane.setViewportView(table_checkstudentcourse);
		table_checkstudentcourse.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table_checkstudentcourse.setBackground(Color.WHITE);
		table_checkstudentcourse.setFont(new Font("·ÂËÎ", Font.PLAIN, 18));
		table_checkstudentcourse.setForeground(Color.BLACK);
		table_checkstudentcourse.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", ""},
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
				"\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u4EFB\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65F6\u95F4"
			}
		));
		table_checkstudentcourse.getColumnModel().getColumn(1).setPreferredWidth(84);
		table_checkstudentcourse.getColumnModel().getColumn(2).setPreferredWidth(87);
		table_checkstudentcourse.getColumnModel().getColumn(3).setPreferredWidth(89);
		
		JButton button_quit = new JButton("\u9000\u51FA");
		button_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_quit.setBounds(273, 200, 123, 29);
		contentPane.add(button_quit);
	}
}
