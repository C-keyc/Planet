package vc.client.view.choosecourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JScrollPane;

public class courseTCheck extends JFrame {

	private JPanel contentPane;
	private JTable table_checkteachercourse;
	private JScrollPane scrollPane;
	
/*	private Vector TableData;//鐢ㄦ潵瀛樻斁琛ㄦ牸鏁版嵁鐨勭嚎鎬ц〃
    private Vector TableTitle;//琛ㄦ牸鐨� 鍒楁爣棰�
    @SuppressWarnings("unchecked")
	public void test1()
{
 TableData = new Vector();
TableTitle= new Vector();
TableTitle.add("绗竴鍒�");
 TableTitle.add("绗簩鍒�"); 
 TableTitle.add("绗笁鍒�");
String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Leading";
String userName="sa"; 
String userPwd="123456";
}
*/
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseTCheck frame = new courseTCheck();
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
	public courseTCheck() {
		setTitle("\u67E5\u770B\u6211\u7684\u6388\u8BFE\u8BFE\u7A0B");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 31, 398, 102);
		contentPane.add(scrollPane);
		
		table_checkteachercourse = new JTable();
		scrollPane.setViewportView(table_checkteachercourse);
		table_checkteachercourse.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_checkteachercourse.setModel(new DefaultTableModel(
			new Object[][] {
				{" ", "", "", ""},
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
				"\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u4EFB\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65F6\u95F4"
			}
		));
		table_checkteachercourse.getColumnModel().getColumn(1).setPreferredWidth(91);
		table_checkteachercourse.getColumnModel().getColumn(2).setPreferredWidth(92);
		table_checkteachercourse.getColumnModel().getColumn(3).setPreferredWidth(88);
		table_checkteachercourse.setRowHeight(20);
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setBounds(268, 188, 123, 29);
		contentPane.add(button);
	}
}
