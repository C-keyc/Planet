package stroll.client.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessageRoll_searchDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_searchInput;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MessageRoll_searchDlg dialog = new MessageRoll_searchDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MessageRoll_searchDlg() {
		setTitle("\u67E5\u8BE2\u5B66\u7C4D\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MessageRoll_searchDlg.class.getResource("/image/Z4MF2_F_JT)KDFPTL]ZBDW0.jpg")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\u8BF7\u8F93\u5165\u9700\u8981\u67E5\u8BE2\u7684");
			label.setFont(new Font("»ªÎÄÐÐ¿¬", Font.PLAIN, 30));
			label.setBounds(102, 29, 252, 41);
			contentPanel.add(label);
		}
		
		textField_searchInput = new JTextField();
		textField_searchInput.setBounds(102, 155, 240, 30);
		contentPanel.add(textField_searchInput);
		textField_searchInput.setColumns(10);
		
		JRadioButton radioButton_name = new JRadioButton("\u59D3\u540D");
		radioButton_name.setSelected(true);
		radioButton_name.setBackground(new Color(240, 255, 240));
		buttonGroup.add(radioButton_name);
		radioButton_name.setBounds(102, 85, 80, 25);
		contentPanel.add(radioButton_name);
		
		JRadioButton radioButton_ID = new JRadioButton("\u5B66\u53F7");
		radioButton_ID.setBackground(new Color(240, 255, 240));
		buttonGroup.add(radioButton_ID);
		radioButton_ID.setBounds(187, 85, 80, 25);
		contentPanel.add(radioButton_ID);
		
		JRadioButton radioButton_cardID = new JRadioButton("\u4E00\u5361\u901A");
		radioButton_cardID.setBackground(new Color(240, 255, 240));
		buttonGroup.add(radioButton_cardID);
		radioButton_cardID.setBounds(272, 85, 80, 25);
		contentPanel.add(radioButton_cardID);
		
		JRadioButton radioButton_college = new JRadioButton("\u9662\u7CFB");
		buttonGroup.add(radioButton_college);
		radioButton_college.setBackground(new Color(240, 255, 240));
		radioButton_college.setBounds(102, 110, 80, 25);
		contentPanel.add(radioButton_college);
		
		JRadioButton radioButton_major = new JRadioButton("\u4E13\u4E1A");
		buttonGroup.add(radioButton_major);
		radioButton_major.setBackground(new Color(240, 255, 240));
		radioButton_major.setBounds(187, 110, 80, 25);
		contentPanel.add(radioButton_major);
		
		JRadioButton radioButton_year = new JRadioButton("\u5165\u5B66\u5E74\u4EFD");
		radioButton_year.setBackground(new Color(240, 255, 240));
		radioButton_year.setBounds(272, 110, 80, 25);
		contentPanel.add(radioButton_year);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(240, 255, 240));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u5B9A");
				okButton.setSelectedIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\\u56FE\u72472.png"));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
			}
		}
	}
}
