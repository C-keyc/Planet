package seu.list.client.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChatOutPane extends JTextPane implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 472037544921476955L;
	public static final String OWNER_STYLE = "OWNER_STYLE";
	public static final String FRIEND_STYLE = "FRIEND_STYLE";
	static SimpleAttributeSet ITALIC_GRAY = new SimpleAttributeSet();
	static SimpleAttributeSet BOLD_BLACK = new SimpleAttributeSet();
	static SimpleAttributeSet BLACK = new SimpleAttributeSet();

	// Best to reuse attribute sets as much as possible.
	static {

		StyleConstants.setForeground(ITALIC_GRAY, Color.gray);
		StyleConstants.setItalic(ITALIC_GRAY, true);
		StyleConstants.setFontFamily(ITALIC_GRAY, "Î¢ÈíÑÅºÚ");
		StyleConstants.setFontSize(ITALIC_GRAY, 14);				

		StyleConstants.setForeground(BOLD_BLACK, Color.black);
		StyleConstants.setBold(BOLD_BLACK, true);
		StyleConstants.setFontFamily(BOLD_BLACK, "¿¬Ìå");
		StyleConstants.setFontSize(BOLD_BLACK, 14);

		StyleConstants.setForeground(BLACK, Color.black);
		StyleConstants.setFontFamily(BLACK, "ËÎÌå");
		StyleConstants.setFontSize(BLACK, 14);
	}

	private Document doc;

	public ChatOutPane() {
		this.setContentType("text/html");
		this.setEditable(false);
		doc = this.getStyledDocument();
	}

	public void append(String info, String style) {

		if (style.equals(OWNER_STYLE)) {
			append(info, ITALIC_GRAY);
		} else if (style.equals(FRIEND_STYLE)) {
			append(info, BOLD_BLACK);
		}

	}

	public void append(String info, AttributeSet style) {

		try {
			doc.insertString(doc.getLength(), info, style);
		} catch (BadLocationException e) {
			System.out.println("BadLocationException:   " + e);
		}
	}

	public void append(String info) {
		JLabel lbl = new JLabel();
		lbl.setText(info);
		lbl.addMouseListener(this);
		this.setCaretPosition(doc.getLength());
		this.insertComponent(lbl);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// System.out.println(e);
		if (e.getSource() instanceof JLabel) {
			JLabel lbl = (JLabel) e.getSource();
			String[] strs = lbl.getText().split("'");
			String command = "cmd /c start " + strs[1];
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof JLabel) {
			this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() instanceof JLabel) {
			this.setCursor(Cursor.getDefaultCursor());
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		ChatOutPane chatOutPane = new ChatOutPane();
		jf.add(chatOutPane);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(400, 400);
		jf.setVisible(true);
		final JFileChooser fc = new JFileChooser();
		// In response to a button click:
		int returnVal = fc.showOpenDialog(jf);
		File file = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			chatOutPane.append("<html><a href='" + file.getAbsolutePath()
					+ "'>" + file.getName() + "</a></html>");
		}
		chatOutPane.append("\r\nChatOutPane.OWNER_STYLE", ChatOutPane.OWNER_STYLE);
		chatOutPane.append("\r\nChatOutPane.FRIEND_STYLE", ChatOutPane.FRIEND_STYLE);
	}

}
