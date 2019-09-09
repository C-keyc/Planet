package vc.server.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vc.server.bz.IServerSrv;
import vc.server.bz.IServerSrvImpl;
import java.awt.Font;
import java.awt.Color;




public class VcServerFrame extends JFrame implements ActionListener {

	JButton jb1, jb2;
	private IServerSrv server;
	private static final long serialVersionUID = 1L;
	
	public VcServerFrame() {
		getContentPane().setBackground(new Color(240, 248, 255));
		
		setProperties();
		initNorthPane();
		
		//
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				if(server != null && !server.isClosed())
					server.close();

			
			}});
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == jb1) {
			//
			server = new IServerSrvImpl();
			server.start();			

			//
			jb1.setEnabled(false);
			jb2.setEnabled(true);

		} else if (e.getSource() == jb2) {
			//
			server.close();
			
			//
			jb2.setEnabled(false);
			jb1.setEnabled(true);


		}
	}

	private void initNorthPane() {
		getContentPane().setLayout(null);
		jb1 = new JButton("启动服务器");
		jb1.setFont(new Font("黑体", Font.PLAIN, 18));
		jb1.setBounds(36, 102, 138, 44);
		getContentPane().add(jb1);
		jb2 = new JButton("关闭服务器");
		jb2.setFont(new Font("黑体", Font.PLAIN, 18));
		jb2.setBounds(204, 102, 138, 44);
		getContentPane().add(jb2);
		jb2.addActionListener(this);
		jb2.setEnabled(false);
		jb1.addActionListener(this);
	}
	
	private void setProperties() {
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.pack();
	}
}
