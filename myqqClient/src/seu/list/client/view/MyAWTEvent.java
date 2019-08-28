package seu.list.client.view;

import java.awt.AWTEvent;
import java.awt.Event;

public class MyAWTEvent extends AWTEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5539848971705965873L;
	public static final String SEND = "SEND";
	public static final String CLOSE = "CLOSE";
	public static final String FILE = "FILE";
	public static final String SHAKE = "SHAKE";
	private String type;

	public MyAWTEvent(Event evt) {
		super(evt);
		
	}
	public MyAWTEvent(AWTEvent evt, String type) {
		super(evt.getSource(), evt.getID());		
		this.setType(type);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
