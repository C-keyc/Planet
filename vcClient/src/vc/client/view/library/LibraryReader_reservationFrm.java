package vc.client.view.library;

import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.impl.UserSrvImpl;
import vc.list.common.Seat;
import vc.list.common.User;

import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LibraryReader_reservationFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3604344832935572077L;
	private JPanel contentPane;
	private User owner;
	private JTextField Num;
	private UserSrvImpl usrv = new UserSrvImpl();
	private String num;
	private Seat s;
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	public void updatetext() {
		//Num.getText();
		Num.setText(num);
	}
	

	public LibraryReader_reservationFrm(User u) {

		this.owner = u;
		LibraryReaderReservationMgr.add(owner.getUserID(), this);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = sdf.format(new Date());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		calendar.add(calendar.DATE,1);
		String date2= sdf.format(calendar.getTime());	
		calendar.setTime(new Date());
		calendar.add(calendar.DATE,2);
		String date3= sdf.format(calendar.getTime());

		
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u56FE\u4E66\u9986");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryReader_reservationFrm.class.getResource("/image/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] listData = new String[]{"08:00-11:00", "14:00-17:00", "18:00-21:00"};
		
		JLabel label = new JLabel("\u9884\u7EA6\u65F6\u95F4\u6BB5\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(42, 127, 127, 46);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u9009\u62E9\u65E5\u671F\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(42, 51, 115, 39);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7A7A\u4F59\u5EA7\u4F4D\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(42, 207, 115, 54);
		contentPane.add(label_2);
		
			
		JRadioButton today = new JRadioButton(date1);
		today.setBounds(38, 91, 157, 27);
		contentPane.add(today);
		
		JRadioButton tomorrow = new JRadioButton(date2);
		tomorrow.setBounds(220, 91, 157, 27);
		contentPane.add(tomorrow);
		
		JRadioButton thedayaftertomorrow = new JRadioButton(date3);
		thedayaftertomorrow.setBounds(398, 91, 157, 27);
		contentPane.add(thedayaftertomorrow);
		
		
		Num = new JTextField();
		Num.setBounds(160, 224, 157, 24);
		contentPane.add(Num);
		Num.setColumns(10);
		

		
		JRadioButton time1 = new JRadioButton("08:00-11:00");
		time1.setBounds(38, 171, 157, 27);
		contentPane.add(time1);
		
		JRadioButton time2 = new JRadioButton("14:00-17:00");
		time2.setBounds(220, 171, 157, 27);
		contentPane.add(time2);
		
		JRadioButton time3 = new JRadioButton("18:00-21:00");
		time3.setBounds(398, 171, 157, 27);
		contentPane.add(time3);
		
		ButtonGroup group2=new ButtonGroup();
		group2.add(time1);
		group2.add(time2);
		group2.add(time3);
		ButtonGroup group=new ButtonGroup();
		group.add(today);
		group.add(tomorrow);
		group.add(thedayaftertomorrow);
		JButton check = new JButton("\u67E5 \u8BE2");
		//check.setForeground(new Color(176, 196, 222));
		check.setFont(new Font("宋体", Font.PLAIN, 28));
		//check.setBackground(new Color(245, 245, 245));
		check.setBounds(101, 285, 127, 54);
		contentPane.add(check);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				DefaultButtonModel todaymodel=(DefaultButtonModel)today.getModel();
				DefaultButtonModel tomorrowmodel=(DefaultButtonModel)tomorrow.getModel();
				DefaultButtonModel htmodel=(DefaultButtonModel)thedayaftertomorrow.getModel();

				Seat seat = new Seat();
				if(todaymodel.getGroup().isSelected(todaymodel)) {
					seat.setSeatDate(1);
					
				}
				if(todaymodel.getGroup().isSelected(tomorrowmodel)) {
					seat.setSeatDate(2);
				}
				if(todaymodel.getGroup().isSelected(htmodel)) {
					seat.setSeatDate(3);
				}
				if(time1.isSelected()) {
					seat.setSeatTime("1");
				}
				if(time2.isSelected()) {
					seat.setSeatTime("2");
				}
				if(time3.isSelected()) {
					seat.setSeatTime("3");
				}
				
				if(todaymodel.getGroup().isSelected(todaymodel)||tomorrowmodel.getGroup().isSelected(tomorrowmodel)
						||htmodel.getGroup().isSelected(htmodel)) {
					
					
					usrv.querySeat(owner,seat);
					updatetext();
					
				}
				
			}
			
		});
		
		
		JButton reserve = new JButton("\u9884  \u7EA6");
		//reserve.setBackground(new Color(245, 245, 245));
		//reserve.setForeground(new Color(176, 196, 222));
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
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "预约失败！","预约结果",JOptionPane.YES_OPTION);
				}
					}
				else {
					JOptionPane.showMessageDialog(contentPane, "请选择日期","提示",JOptionPane.WARNING_MESSAGE );
				}
							
			}
		});
		reserve.setFont(new Font("宋体", Font.PLAIN, 28));
		reserve.setBounds(347, 285, 127, 54);
		contentPane.add(reserve);
		
		


	}
}
