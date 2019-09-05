package vc.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vc.client.bz.thread.CourseThreadSrv;
import vc.list.common.Course;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class XKCourseFrm extends JFrame {

	private JPanel contentPane;
	private JTextField CourseName;
	private JTextField rKteacher;
	private Course course;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XKCourseFrm frame = new XKCourseFrm();
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
	public XKCourseFrm() {
		setResizable(false);
		course = new Course();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton add = new JButton("\u6DFB\u52A0");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = CourseName.getText().trim();
				String rkTeacher = rKteacher.getText().trim();
				course.setName(name);
				course.setRkTeacher(rkTeacher);
				try {
					
					
					CourseThreadSrv cts = new CourseThreadSrv();
					ObjectOutputStream oos = new ObjectOutputStream(cts.getOutputStream());
					oos.writeObject(course);
					oos.flush();
					//cts.start();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		contentPane.add(add);
		
		rKteacher = new JTextField();
		contentPane.add(rKteacher);
		rKteacher.setColumns(10);
		
		CourseName = new JTextField();
		contentPane.add(CourseName);
		CourseName.setColumns(10);
	}

}
