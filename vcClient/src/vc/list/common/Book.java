package vc.list.common;

public class Book implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1759296936532479153L;
	
	private int BookID;//key 书号（加入新书籍时会自动升序排序
	private String BookName;//书籍名称
	private String BookWriter;//书籍作者
	private String BookPublish;//书籍出版社
	
	
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
