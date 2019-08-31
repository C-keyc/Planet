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




public class VcServerFrame extends JFrame implements ActionListener {

	JButton jb1, jb2;
	JPanel jp1;
	private IServerSrv server;
	private static final long serialVersionUID = 1L;
	
	public VcServerFrame() {
		
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
		jp1 = new JPanel();
		jb1 = new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2 = new JButton("关闭服务器");
		jb2.addActionListener(this);
		jb2.setEnabled(false);
		jp1.add(jb1);
		jp1.add(jb2);
		this.add(jp1, BorderLayout.NORTH);
	}
	
	private void setProperties() {
		this.setSize(500, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.pack();
	}
}
