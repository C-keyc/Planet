package vc.server.test;

import javax.swing.SwingUtilities;

import vc.server.view.VcServerFrame;

public class VcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new VcServerFrame();
			}
			
		});
	}

}
