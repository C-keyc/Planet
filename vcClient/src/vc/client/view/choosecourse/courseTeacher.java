package vc.client.view.choosecourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class courseTeacher extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseTeacher frame = new courseTeacher();
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
	public courseTeacher() {
		setTitle("\u6B22\u8FCE\u6765\u5230\u9009\u8BFE\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u767B\u9646\u8EAB\u4EFD\uFF1A");
		label.setBounds(93, 52, 99, 21);
		contentPane.add(label);
		
		JLabel lblId = new JLabel("ID\uFF1A");
		lblId.setBounds(355, 52, 81, 21);
		contentPane.add(lblId);
		
		JLabel label_1 = new JLabel("\u6559\u5E08");
		label_1.setBounds(190, 52, 81, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6570\u5B57");
		label_2.setBounds(406, 52, 81, 21);
		contentPane.add(label_2);
		
		JButton button = new JButton("\u6DFB\u52A0\u8BFE\u7A0B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseTADD add=new courseTADD();
				add.setVisible(true);
			}
		});
		button.setBounds(232, 133, 123, 29);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88\u8BFE\u7A0B");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseTDELETE delete=new courseTDELETE();
				delete.setVisible(true);
			}
		});
		btnNewButton.setBounds(232, 202, 123, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u770B\u6211\u7684\u8BFE\u7A0B");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseTCheck check=new courseTCheck();
				check.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				check.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(179, 288, 225, 29);
		contentPane.add(btnNewButton_1);
	}
}
