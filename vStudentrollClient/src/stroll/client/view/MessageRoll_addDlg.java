package stroll.client.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class MessageRoll_addDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textRollName;
	private JTextField textRollGender;
	private JTextField textRollID;
	private JTextField textRollCollege;
	private JTextField textRollMajor;
	private JTextField textRollYear;
	private JTextField textRollIdentityID;
	private JTextField textRollcardID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MessageRoll_addDlg dialog = new MessageRoll_addDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MessageRoll_addDlg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MessageRoll_addDlg.class.getResource("/image/Z4MF2_F_JT)KDFPTL]ZBDW0.jpg")));
		setTitle("\u589E\u52A0\u5B66\u7C4D\u4FE1\u606F");
		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel(" \u8BF7\u8F93\u5165\u5B66\u7C4D\u4FE1\u606F");
			label.setForeground(new Color(0, 0, 0));
			label.setFont(new Font("华文行楷", Font.PLAIN, 30));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(10, 10, 414, 53);
			contentPanel.add(label);
		}
		
			JLabel lbRollName = new JLabel("\u59D3\u540D\uFF1A");
			lbRollName.setFont(new Font("黑体", Font.PLAIN, 15));
			lbRollName.setBounds(20, 75, 54, 24);
			contentPanel.add(lbRollName);
		
			JLabel lbRollGender = new JLabel("\u6027\u522B\uFF1A");
			lbRollGender.setFont(new Font("黑体", Font.PLAIN, 15));
			lbRollGender.setBounds(20, 110, 54, 24);
			contentPanel.add(lbRollGender);
		
			JLabel lbRollID = new JLabel("\u5B66\u53F7\uFF1A");
			lbRollID.setFont(new Font("黑体", Font.PLAIN, 15));
			lbRollID.setBounds(20, 145, 54, 24);
			contentPanel.add(lbRollID);
		
			JLabel lbRollCollege = new JLabel("\u9662\u7CFB\uFF1A");
			lbRollCollege.setFont(new Font("黑体", Font.PLAIN, 15));
			lbRollCollege.setBounds(20, 180, 54, 24);
			contentPanel.add(lbRollCollege);
		
			JLabel lbRollMajor = new JLabel("\u4E13\u4E1A\uFF1A");
			lbRollMajor.setFont(new Font("黑体", Font.PLAIN, 15));
			lbRollMajor.setBounds(20, 215, 54, 24);
			contentPanel.add(lbRollMajor);
		
			JLabel lbRollYear = new JLabel("\u5165\u5B66\u5E74\u4EFD\uFF1A");
			lbRollYear.setFont(new Font("黑体", Font.PLAIN, 15));
			lbRollYear.setBounds(20, 250, 81, 24);
			contentPanel.add(lbRollYear);
		
			JLabel lbRollIdentityID = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
			lbRollIdentityID.setFont(new Font("黑体", Font.PLAIN, 15));
			lbRollIdentityID.setBounds(20, 285, 81, 24);
			contentPanel.add(lbRollIdentityID);
		
			textRollName = new JTextField();
			textRollName.setBounds(175, 75, 220, 25);
			contentPanel.add(textRollName);
			textRollName.setColumns(10);
		
			textRollGender = new JTextField();
			textRollGender.setColumns(10);
			textRollGender.setBounds(175, 110, 220, 25);
			contentPanel.add(textRollGender);
		
			textRollID = new JTextField();
			textRollID.setColumns(10);
			textRollID.setBounds(175, 145, 220, 25);
			contentPanel.add(textRollID);
		
			textRollCollege = new JTextField();
			textRollCollege.setColumns(10);
			textRollCollege.setBounds(175, 180, 220, 25);
			contentPanel.add(textRollCollege);
		
			textRollMajor = new JTextField();
			textRollMajor.setColumns(10);
			textRollMajor.setBounds(175, 215, 220, 25);
			contentPanel.add(textRollMajor);
		
			textRollYear = new JTextField();
			textRollYear.setColumns(10);
			textRollYear.setBounds(175, 250, 220, 25);
			contentPanel.add(textRollYear);
		
			textRollIdentityID = new JTextField();
			textRollIdentityID.setColumns(10);
			textRollIdentityID.setBounds(175, 285, 220, 25);
			contentPanel.add(textRollIdentityID);
			
			JLabel lbRollcardID = new JLabel("\u4E00\u5361\u901A\uFF1A");
			lbRollcardID.setFont(new Font("黑体", Font.PLAIN, 15));
			lbRollcardID.setBounds(20, 320, 82, 24);
			contentPanel.add(lbRollcardID);
			
			textRollcardID = new JTextField();
			textRollcardID.setColumns(10);
			textRollcardID.setBounds(175, 320, 220, 25);
			contentPanel.add(textRollcardID);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(240, 255, 240));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u5B9A");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
