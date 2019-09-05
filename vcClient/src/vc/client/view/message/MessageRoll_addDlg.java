package vc.client.view.message;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Student;
import vc.list.common.User;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MessageRoll_addDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textName;
	private JTextField textECardId;
	private JTextField textNum;
	private JTextField textDepartment;
	private JTextField textMajor;
	private JTextField textClass;
	private JTextField textGrade;
	private JTextField textLength;
	private JTextField textInRoll;
	private JTextField textInSchool;
	private User owner;
	private UserSrvImpl usrv = new UserSrvImpl();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			MessageRoll_addDlg dialog = new MessageRoll_addDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public MessageRoll_addDlg(User user) {
		this.owner = user;
		setIconImage(Toolkit.getDefaultToolkit().getImage(MessageRoll_addDlg.class.getResource("/image/logo.jpg")));
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5B66\u7C4D\u7BA1\u7406");
		setBounds(100, 100, 400, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel(" \u8BF7\u8F93\u5165\u8981\u6DFB\u52A0\u7684\u5B66\u7C4D\u4FE1\u606F");
			label.setBounds(9, 11, 366, 53);
			label.setForeground(new Color(0, 0, 0));
			label.setFont(new Font("Dialog", Font.PLAIN, 25));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(label);
		}
		
			JLabel lbRollName = new JLabel("*\u59D3\u540D\uFF1A");
			lbRollName.setBounds(44, 105, 54, 24);
			lbRollName.setFont(new Font("黑体", Font.PLAIN, 15));
			contentPanel.add(lbRollName);
		
			JLabel lbRollGender = new JLabel("*\u4E00\u5361\u901A\u53F7\uFF1A");
			lbRollGender.setBounds(44, 140, 92, 24);
			lbRollGender.setFont(new Font("黑体", Font.PLAIN, 15));
			contentPanel.add(lbRollGender);
		
			JLabel lbRollID = new JLabel("*\u5B66\u53F7\uFF1A");
			lbRollID.setBounds(44, 175, 54, 24);
			lbRollID.setFont(new Font("黑体", Font.PLAIN, 15));
			contentPanel.add(lbRollID);
		
			JLabel lbRollCollege = new JLabel("*\u9662\u7CFB\uFF1A");
			lbRollCollege.setBounds(44, 210, 54, 24);
			lbRollCollege.setFont(new Font("黑体", Font.PLAIN, 15));
			contentPanel.add(lbRollCollege);
		
			JLabel lbRollMajor = new JLabel("*\u4E13\u4E1A\uFF1A");
			lbRollMajor.setBounds(44, 245, 54, 24);
			lbRollMajor.setFont(new Font("黑体", Font.PLAIN, 15));
			contentPanel.add(lbRollMajor);
		
			JLabel lbRollYear = new JLabel("*\u73ED\u7EA7\uFF1A");
			lbRollYear.setBounds(44, 280, 81, 24);
			lbRollYear.setFont(new Font("黑体", Font.PLAIN, 15));
			contentPanel.add(lbRollYear);
		
			JLabel lbRollIdentityID = new JLabel("*\u662F\u5426\u5728\u7C4D\uFF1A");
			lbRollIdentityID.setBounds(44, 386, 92, 24);
			lbRollIdentityID.setFont(new Font("黑体", Font.PLAIN, 15));
			contentPanel.add(lbRollIdentityID);
		
			textName = new JTextField();
			textName.setToolTipText("");
			textName.setBounds(136, 105, 220, 25);
			contentPanel.add(textName);
			textName.setColumns(10);
		
			textECardId = new JTextField();
			textECardId.setBounds(136, 140, 220, 25);
			textECardId.setColumns(10);
			contentPanel.add(textECardId);
		
			textNum = new JTextField();
			textNum.setBounds(136, 175, 220, 25);
			textNum.setColumns(10);
			contentPanel.add(textNum);
		
			textDepartment = new JTextField();
			textDepartment.setBounds(136, 210, 220, 25);
			textDepartment.setColumns(10);
			contentPanel.add(textDepartment);
		
			textMajor = new JTextField();
			textMajor.setBounds(136, 245, 220, 25);
			textMajor.setColumns(10);
			contentPanel.add(textMajor);
		
			textClass = new JTextField();
			textClass.setBounds(136, 280, 220, 25);
			textClass.setColumns(10);
			contentPanel.add(textClass);
		
			textGrade = new JTextField();
			textGrade.setBounds(136, 315, 220, 25);
			textGrade.setColumns(10);
			contentPanel.add(textGrade);
			
			JLabel lbRollcardID = new JLabel("*\u662F\u5426\u5728\u6821\uFF1A");
			lbRollcardID.setBounds(44, 420, 92, 24);
			lbRollcardID.setFont(new Font("黑体", Font.PLAIN, 15));
			contentPanel.add(lbRollcardID);
			
			textLength = new JTextField();
			textLength.setBounds(136, 350, 220, 25);
			textLength.setColumns(10);
			contentPanel.add(textLength);
			
			textInRoll = new JTextField();
			textInRoll.setColumns(10);
			textInRoll.setBounds(136, 385, 220, 25);
			contentPanel.add(textInRoll);
			
			textInSchool = new JTextField();
			textInSchool.setColumns(10);
			textInSchool.setBounds(136, 420, 220, 25);
			contentPanel.add(textInSchool);
			
			{
				JButton btnOk = new JButton("\u786E\u5B9A");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textName.getText().length()==0||
						   textECardId.getText().length()==0||
						   textNum.getText().length()==0||
						   textDepartment.getText().length()==0||
						   textMajor.getText().length()==0||
						   textClass.getText().length()==0||
						   textGrade.getText().length()==0||
						   textLength.getText().length()==0||
						   textInRoll.getText().length()==0||
						   textInSchool.getText().length()==0)
							JOptionPane.showMessageDialog(contentPanel, "请填写所有必填项", "警告", JOptionPane.WARNING_MESSAGE);
						else {
							Student st =new Student(
							textName.getText(),
						    textECardId.getText(),
						    textNum.getText(),
						    textGrade.getText(),
						    textDepartment.getText(),
						    textMajor.getText(),
						    textClass.getText(),
						    textLength.getText(),
						    textInRoll.getText(),
						    textInSchool.getText());
							try {
								usrv.insertStudent(owner, st);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							dispose();
						}
					}
				});
				btnOk.setBounds(89, 476, 66, 23);
				contentPanel.add(btnOk);
				btnOk.setActionCommand("OK");
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancel = new JButton("\u53D6\u6D88");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setBounds(213, 476, 66, 23);
				contentPanel.add(btnCancel);
				btnCancel.setActionCommand("Cancel");
			}
			
			
			
			JLabel label = new JLabel("*\u5165\u5B66\u5E74\u4EFD\uFF1A");
			label.setFont(new Font("黑体", Font.PLAIN, 15));
			label.setBounds(44, 314, 92, 24);
			contentPanel.add(label);
			
			JLabel label_1 = new JLabel("*\u5B66\u5236\uFF1A");
			label_1.setFont(new Font("黑体", Font.PLAIN, 15));
			label_1.setBounds(44, 351, 81, 24);
			contentPanel.add(label_1);
			
			JLabel label_2 = new JLabel("\u5E26\u201C*\u201D\u4E3A\u5FC5\u586B");
			label_2.setFont(new Font("宋体", Font.PLAIN, 14));
			label_2.setBounds(141, 68, 105, 15);
			contentPanel.add(label_2);
	}
}
