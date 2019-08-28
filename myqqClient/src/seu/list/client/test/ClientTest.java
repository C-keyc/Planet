package seu.list.client.test;

import javax.swing.SwingUtilities;

import org.junit.Test;

import seu.list.client.view.ClientLoginFrm;
import seu.list.common.QQLogger;

public class ClientTest {
	@Test
	public void mainRun() {
		QQLogger.clientLogger().info("¿Í»§¶ËÆô¶¯");
		new ClientLoginFrm();
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				new ClientTest().mainRun();				
			}
		});
		
	}
}
