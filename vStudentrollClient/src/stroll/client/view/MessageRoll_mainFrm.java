package stroll.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessageRoll_mainFrm extends JFrame {

	private JPanel contentPane;
	private JTable tableRollMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageRoll_mainFrm frame = new MessageRoll_mainFrm();
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
	public MessageRoll_mainFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MessageRoll_mainFrm.class.getResource("/image/Z4MF2_F_JT)KDFPTL]ZBDW0.jpg")));
		setTitle("\u6B22\u8FCE\u6765\u5230\u5B66\u751F\u5B66\u7C4D\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button_search = new JButton("\u67E5\u8BE2\u5B66\u7C4D\u4FE1\u606F");
		button_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageRoll_searchDlg dialog = new MessageRoll_searchDlg();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		button_search.setBounds(34, 566, 128, 38);
		button_search.setSelectedIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\\u56FE\u72472.png"));
		contentPane.add(button_search);
		
		JButton button_add = new JButton("\u589E\u52A0\u5B66\u7C4D\u4FE1\u606F");
		button_add.setBounds(265, 566, 128, 38);
		contentPane.add(button_add);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 58, 826, 303);
		contentPane.add(scrollPane);
		
		tableRollMessage = new JTable();
		tableRollMessage.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(tableRollMessage);
		tableRollMessage.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u59D3\u540D", "\u6027\u522B", "\u5B66\u53F7", "\u4E00\u5361\u901A", "\u9662\u7CFB", "\u4E13\u4E1A", "\u5165\u5B66\u5E74\u4EFD", "\u8EAB\u4EFD\u8BC1\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableRollMessage.setRowHeight(25);
		
		
		
		
	}
}
