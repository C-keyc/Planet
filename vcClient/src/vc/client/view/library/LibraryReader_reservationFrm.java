package vc.client.view.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.list.common.User;

import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class LibraryReader_reservationFrm extends JFrame {

	private JPanel contentPane;
	private User owner;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public LibraryReader_reservationFrm(User u) {
		this.owner=u;
		
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryReader_reservationFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox time = new JComboBox();
		time.setBackground(new Color(245, 245, 245));
		time.setModel(new DefaultComboBoxModel(new String[] {"8\uFF1A00-11\uFF1A00", "14\uFF1A00-17\uFF1A00", "18:00-21:00"}));
		time.setBounds(162, 141, 155, 39);
		contentPane.add(time);
		
		JLabel label = new JLabel("\u9884\u7EA6\u65F6\u95F4\u6BB5\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(42, 135, 127, 46);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u9009\u62E9\u65E5\u671F\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(42, 43, 115, 39);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7A7A\u4F59\u5EA7\u4F4D\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(42, 207, 115, 54);
		contentPane.add(label_2);
		
		JLabel availableseat = new JLabel("");
		availableseat.setFont(new Font("宋体", Font.PLAIN, 18));
		availableseat.setBounds(162, 213, 176, 46);
		contentPane.add(availableseat);
			
		JRadioButton today = new JRadioButton("");
		today.setBounds(38, 91, 157, 27);
		contentPane.add(today);
		
		JRadioButton tomorrow = new JRadioButton("");
		tomorrow.setBounds(220, 91, 157, 27);
		contentPane.add(tomorrow);
		
		JRadioButton thedayaftertomorrow = new JRadioButton("");
		thedayaftertomorrow.setBounds(398, 91, 157, 27);
		contentPane.add(thedayaftertomorrow);
		
		ButtonGroup group=new ButtonGroup();
		group.add(today);
		group.add(tomorrow);
		group.add(thedayaftertomorrow);
		
		JButton reserve = new JButton("\u9884  \u7EA6");
		reserve.setBackground(new Color(245, 245, 245));
		reserve.setForeground(new Color(176, 196, 222));
		reserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultButtonModel todaymodel=(DefaultButtonModel)today.getModel();
				DefaultButtonModel tomorrowmodel=(DefaultButtonModel)tomorrow.getModel();
				DefaultButtonModel htmodel=(DefaultButtonModel)thedayaftertomorrow.getModel();
				
				if(todaymodel.getGroup().isSelected(todaymodel)||tomorrowmodel.getGroup().isSelected(tomorrowmodel)
						||htmodel.getGroup().isSelected(htmodel)) {
					//已选择日期
					if(true){
					JOptionPane.showMessageDialog(contentPane, "预约成功！","预约结果",JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(contentPane, "预约失败！","预约结果",JOptionPane.YES_OPTION);
				}
				}else {
					JOptionPane.showMessageDialog(contentPane, "请选择日期","提示",JOptionPane.WARNING_MESSAGE );
				}
							
			}
		});
		reserve.setFont(new Font("宋体", Font.PLAIN, 28));
		reserve.setBounds(219, 285, 127, 54);
		contentPane.add(reserve);
	}
}
