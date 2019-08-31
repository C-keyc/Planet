package vc.client.test;

import javax.swing.SwingUtilities;

import vc.client.view.Login;


public class VcClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				Login login = new Login();
				login.setVisible(true);				
			}
		});
	}

}

