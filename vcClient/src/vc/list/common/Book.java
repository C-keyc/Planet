package vc.list.common;

public class Book implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1759296936532479153L;
	
	private String BookID;//key ��ţ��������鼮ʱ���Զ���������
	private String BookName;//�鼮����
	private String BookWriter;//�鼮����
	private String BookPublish;//�鼮������
	private String BookNum;//�鼮ʣ������
	
	
	public Book(String bookID) {
		super();
		BookID = bookID;
	}

	

	public Book() {
		super();
	}



	public Book(String bookID, String bookName, String bookWriter, String bookPublish, String bookNum) {
		super();
		BookID = bookID;
		BookName = bookName;
		BookWriter = bookWriter;
		BookPublish = bookPublish;
		BookNum = bookNum;
	}



	public Book(String bookID, String bookName, String bookWriter, String bookPublish) {
		super();
		BookID = bookID;
		BookName = bookName;
		BookWriter = bookWriter;
		BookPublish = bookPublish;
	}

	public String getBookNum() {
		return BookNum;
	}



	public void setBookNum(String bookNum) {
		BookNum = bookNum;
	}



	public String getBookID() {
		return BookID;
	}
	
	public void setBookID(String bookID) {
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
				+ BookPublish + ", BookNum=" + BookNum + "]";
	}


	

}
