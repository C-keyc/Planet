package vc.list.common;

public class Book implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1759296936532479153L;
	
	private int BookID;//key ��ţ��������鼮ʱ���Զ���������
	private String BookName;//�鼮����
	private String BookWriter;//�鼮����
	private String BookPublish;//�鼮������
	
	
	public Book(int bookID) {
		super();
		BookID = bookID;
	}

	
	public Book(String bookName) {
		super();
		BookName = bookName;
	}

	public Book(int bookID, String bookName, String bookWriter, String bookPublish) {
		super();
		BookID = bookID;
		BookName = bookName;
		BookWriter = bookWriter;
		BookPublish = bookPublish;
	}

	public int getBookID() {
		return BookID;
	}
	
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	
	public String getBookName() {
		return BookName;
	}
	
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	
	public String getBookWriter() {
		return BookWriter;
	}
	
	public void setBookWriter(String bookWriter) {
		BookWriter = bookWriter;
	}
	
	public String getBookPublish() {
		return BookPublish;
	}
	
	public void setBookPublish(String bookPublish) {
		BookPublish = bookPublish;
	}

	@Override
	public String toString() {
		return "Book [BookID=" + BookID + ", BookName=" + BookName + ", BookWriter=" + BookWriter + ", BookPublish="
				+ BookPublish + "]";
	}
	
	

}
