package vc.client.view.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.list.common.User;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.FocusAdapter;

public class LibraryReader_searchFrm extends JFrame {

	private JPanel contentPane;
	public static LibraryReader_searchresultFrm windowsr;
	private JTextField searchinformation;
	public static LibraryReader_searchbywriterFrm windoww;
	private User owner;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public LibraryReader_searchFrm(User u) {
		this.owner=u;
		
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryReader_searchFrm.class.getResource("/image/logo.jpg")));
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 264);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u65B9\u5F0F\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(25, 13, 97, 56);
		contentPane.add(lblNewLabel);
			
		searchinformation = new JTextField();
		searchinformation.setBounds(39, 124, 273, 39);
		contentPane.add(searchinformation);
		searchinformation.setColumns(10);
		
		
		JRadioButton byname = new JRadioButton("\u6309\u4E66\u7C4D\u540D\u79F0");
		byname.setBounds(118, 30, 157, 27);
		contentPane.add(byname);
		
		JRadioButton byID = new JRadioButton("\u6309\u4E66\u7C4D\u7F16\u53F7");
		byID.setBounds(118, 62, 157, 27);
		contentPane.add(byID);
		
		JRadioButton bywriter = new JRadioButton("\u6309\u4F5C\u8005");
		bywriter.setBounds(118, 94, 157, 27);
		contentPane.add(bywriter);
		
		ButtonGroup group=new ButtonGroup();
		group.add(bywriter);
		group.add(byID);
		group.add(byname);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultButtonModel namemodel=(DefaultButtonModel)byname.getModel();
				DefaultButtonModel IDmodel=(DefaultButtonModel)byID.getModel();
				DefaultButtonModel writermodel=(DefaultButtonModel)bywriter.getModel();
				
				if(searchinformation.getText().length()==0||searchinformation.getText().equals("")) {
					//���û�����룬��ʾ
					JOptionPane.showMessageDialog(searchinformation, "�������ı�","��ʾ",JOptionPane.WARNING_MESSAGE );
				}else if(namemodel.getGroup().isSelected(namemodel)||IDmodel.getGroup().isSelected(IDmodel)) {
					//���ѡ�а������򰴱�Ų�ѯ
					windowsr=new LibraryReader_searchresultFrm(owner);
					windowsr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					windowsr.setVisible(true);
				}else if(writermodel.getGroup().isSelected(writermodel)) {
					//���ѡ�а����߲�ѯ
					windoww=new LibraryReader_searchbywriterFrm(owner);
					windoww.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					windoww.setVisible(true);
				}else {
					//���ʲô��ûѡ����ʾ
					JOptionPane.showMessageDialog(contentPane, "��ѡ���ѯ��ʽ��","��ʾ",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setBounds(106, 165, 129, 39);
		contentPane.add(btnNewButton);
	}
}
