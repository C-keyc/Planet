package stroll.client.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class MessageRoll_updateDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNewName;
	private JTextField textNewGender;
	private JTextField textFNewID;
	private JTextField textNewCollege;
	private JTextField textNewMajor;
	private JTextField textNewYear;
	private JTextField textNewIdentityID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MessageRoll_updateDlg dialog = new MessageRoll_updateDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MessageRoll_updateDlg() {
		setTitle("\u4FEE\u6539\u5B66\u751F\u5B66\u7C4D\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MessageRoll_updateDlg.class.getResource("/image/Z4MF2_F_JT)KDFPTL]ZBDW0.jpg")));
		setBounds(100, 100, 644, 483);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbtips_inputID = new JLabel("\u8BF7\u8F93\u5165\u4FEE\u6539\u540E\u7684\u5B66\u751F\u4FE1\u606F");
		lbtips_inputID.setFont(new Font("华文行楷", Font.PLAIN, 30));
		lbtips_inputID.setBounds(150, 26, 365, 48);
		contentPanel.add(lbtips_inputID);
		
		textNewName = new JTextField();
		textNewName.setBounds(317, 84, 268, 24);
		contentPanel.add(textNewName);
		textNewName.setColumns(10);
		{
			JLabel label1 = new JLabel("\u59D3\u540D\uFF1A");
			label1.setFont(new Font("黑体", Font.PLAIN, 15));
			label1.setBounds(14, 85, 54, 24);
			contentPanel.add(label1);
		}
		{
			JLabel label2 = new JLabel("\u6027\u522B\uFF1A");
			label2.setFont(new Font("黑体", Font.PLAIN, 15));
			label2.setBounds(14, 120, 54, 24);
			contentPanel.add(label2);
		}
		{
			JLabel label3 = new JLabel("\u5B66\u53F7\uFF1A");
			label3.setFont(new Font("黑体", Font.PLAIN, 15));
			label3.setBounds(14, 155, 54, 24);
			contentPanel.add(label3);
		}
		{
			JLabel label4 = new JLabel("\u9662\u7CFB\uFF1A");
			label4.setFont(new Font("黑体", Font.PLAIN, 15));
			label4.setBounds(14, 190, 54, 24);
			contentPanel.add(label4);
		}
		{
			JLabel label5 = new JLabel("\u4E13\u4E1A\uFF1A");
			label5.setFont(new Font("黑体", Font.PLAIN, 15));
			label5.setBounds(14, 225, 54, 24);
			contentPanel.add(label5);
		}
		{
			JLabel label6 = new JLabel("\u5165\u5B66\u5E74\u4EFD\uFF1A");
			label6.setFont(new Font("黑体", Font.PLAIN, 15));
			label6.setBounds(14, 260, 81, 24);
			contentPanel.add(label6);
		}
		{
			JLabel label7 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
			label7.setFont(new Font("黑体", Font.PLAIN, 15));
			label7.setBounds(14, 295, 81, 24);
			contentPanel.add(label7);
		}
		
			JLabel lbIdentityID = new JLabel("XXXXXXXXXXXX");
			lbIdentityID.setFont(new Font("黑体", Font.PLAIN, 15));
			lbIdentityID.setBounds(131, 294, 158, 24);
			contentPanel.add(lbIdentityID);
		
			JLabel lbYear = new JLabel("2017");
			lbYear.setFont(new Font("黑体", Font.PLAIN, 15));
			lbYear.setBounds(131, 259, 81, 24);
			contentPanel.add(lbYear);
		
			JLabel lbMajor = new JLabel("\u8BA1\u7B97\u673A\u79D1\u5B66\u4E0E\u6280\u672F");
			lbMajor.setFont(new Font("黑体", Font.PLAIN, 15));
			lbMajor.setBounds(131, 224, 158, 24);
			contentPanel.add(lbMajor);
		
			JLabel lbCollege = new JLabel("\u8BA1\u7B97\u673A\u79D1\u5B66\u4E0E\u5DE5\u7A0B\u5B66\u9662");
			lbCollege.setFont(new Font("黑体", Font.PLAIN, 15));
			lbCollege.setBounds(131, 189, 158, 24);
			contentPanel.add(lbCollege);
		
			JLabel lbID = new JLabel("09011111");
			lbID.setFont(new Font("黑体", Font.PLAIN, 15));
			lbID.setBounds(131, 154, 81, 24);
			contentPanel.add(lbID);
		
			JLabel lbGender = new JLabel("\u7537");
			lbGender.setFont(new Font("黑体", Font.PLAIN, 15));
			lbGender.setBounds(131, 119, 54, 24);
			contentPanel.add(lbGender);
		
			JLabel lbName = new JLabel("\u5F20\u4E09");
			lbName.setFont(new Font("黑体", Font.PLAIN, 15));
			lbName.setBounds(131, 84, 54, 24);
			contentPanel.add(lbName);
		
		
		textNewGender = new JTextField();
		textNewGender.setColumns(10);
		textNewGender.setBounds(317, 122, 268, 24);
		contentPanel.add(textNewGender);
		
		textFNewID = new JTextField();
		textFNewID.setColumns(10);
		textFNewID.setBounds(317, 157, 268, 24);
		contentPanel.add(textFNewID);
		
		textNewCollege = new JTextField();
		textNewCollege.setColumns(10);
		textNewCollege.setBounds(317, 192, 268, 24);
		contentPanel.add(textNewCollege);
		
		textNewMajor = new JTextField();
		textNewMajor.setColumns(10);
		textNewMajor.setBounds(317, 227, 268, 24);
		contentPanel.add(textNewMajor);
		
		textNewYear = new JTextField();
		textNewYear.setColumns(10);
		textNewYear.setBounds(317, 262, 268, 24);
		contentPanel.add(textNewYear);
		
		textNewIdentityID = new JTextField();
		textNewIdentityID.setColumns(10);
		textNewIdentityID.setBounds(317, 297, 268, 24);
		contentPanel.add(textNewIdentityID);
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
