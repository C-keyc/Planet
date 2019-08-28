package seu.list.client.view;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChatPane extends JTextPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 472037544921476955L;
	public static final  String OWNER_STYLE = "OWNER_STYLE";
	public static final  String FRIEND_STYLE = "FRIEND_STYLE";
	
		
	public void append(String info, String style) {
		SimpleAttributeSet   attrSet   =   new   SimpleAttributeSet(); 
		if (style.equals(OWNER_STYLE)) {			 
			 StyleConstants.setFontFamily(attrSet, "Î¢ÈíÑÅºÚ");
	          StyleConstants.setForeground(attrSet, Color.DARK_GRAY); 	         
	          StyleConstants.setBold(attrSet, false); 	       
	          StyleConstants.setFontSize(attrSet, 16);   
		}else if(style.equals(FRIEND_STYLE)) {
			 StyleConstants.setFontFamily(attrSet, "¿¬Ìå");
	          StyleConstants.setForeground(attrSet, Color.black); 	         
	          StyleConstants.setBold(attrSet, false); 	       
	          StyleConstants.setFontSize(attrSet, 18);   
		}
		append(info, attrSet);  
	}

	public void append(String info, AttributeSet style) {
		Document   doc   =   getDocument();  	           
		  try   {   
		      doc.insertString(doc.getLength(),   info,   style);   
		  }   
		  catch   (BadLocationException   e)   {   
		      System.out.println("BadLocationException:   "   +   e);   
		  }
	}

}
