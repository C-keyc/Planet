package seu.list.widget;

import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * This class represents the buttons used in toolbars.
 * 
 * @author <a href="mailto:stephane@hillion.org">Stephane Hillion</a>
 * @author <a href="mailto:shen.list@seu.edu.cn">Aodong Shen</a>
 * @version $Id: JToolbarButton.java 498555 2007-01-22 08:09:33Z cam $
 * @version $Id: SToolbarButton.java 2012-06-22 08:09:33Z $
 */
public class SToolbarButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1330571445613109013L;

	/**
	 * Creates a new toolbar button.
	 */
	public SToolbarButton() {
		initialize();
	}

	/**
	 * Creates a new toolbar button.
	 * 
	 * @param txt
	 *            The button text.
	 */
	public SToolbarButton(String txt) {
		super(txt);
		initialize();
	}

	public SToolbarButton(Icon icon) {
		super(icon);
		initialize();
	}

	/**
	 * Initializes the button.
	 */
	protected void initialize() {
		if (!System.getProperty("java.version").startsWith("1.3")) {
			setOpaque(false);
			setBackground(new java.awt.Color(0, 0, 0, 0));
		}
		setBorderPainted(false);
		setMargin(new Insets(2, 2, 2, 2));
		addMouseListener(new MouseListener());
	}

	/**
	 * To manage the mouse interactions.
	 */
	protected class MouseListener extends MouseAdapter {
		public void mouseEntered(MouseEvent ev) {
			setBorderPainted(true);
		}

		public void mouseExited(MouseEvent ev) {
			setBorderPainted(false);
		}
	}
}