package vc.list.common;

public class BookRecord implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5236280107969560968L;
	private String BookRecordID;
	private String BookRecordName;
	private String BookRecordDate;
	private String BookRecordState;
	private String BookRecordLeftTime;
	
	
	public BookRecord() {
		super();
	}
	public BookRecord(String bookRecordID, String bookRecordName, String bookRecordDate, String bookRecordState,
			String bookRecordLeftTime) {
		super();
		BookRecordID = bookRecordID;
		BookRecordName = bookRecordName;
		BookRecordDate = bookRecordDate;
		BookRecordState = bookRecordState;
		BookRecordLeftTime = bookRecordLeftTime;
	}
	public String getBookRecordID() {
		return BookRecordID;
	}
	public void setBookRecordID(String bookRecordID) {
		BookRecordID = bookRecordID;
	}
	public String getBookRecordName() {
		return BookRecordName;
	}
	public void setBookRecordName(String bookRecordName) {
		BookRecordName = bookRecordName;
	}
	public String getBookRecordDate() {
		return BookRecordDate;
	}
	public void setBookRecordDate(String bookRecordDate) {
		BookRecordDate = bookRecordDate;
	}
	public String getBookRecordState() {
		return BookRecordState;
	}
	public void setBookRecordState(String bookRecordState) {
		BookRecordState = bookRecordState;
	}
	public String getBookRecordLeftTime() {
		return BookRecordLeftTime;
	}
	public void setBookRecordLeftTime(String bookRecordLeftTime) {
		BookRecordLeftTime = bookRecordLeftTime;
	}
	@Override
	public String toString() {
		return "BookRecord [BookRecordID=" + BookRecordID + ", BookRecordName=" + BookRecordName + ", BookRecordDate="
				+ BookRecordDate + ", BookRecordState=" + BookRecordState + ", BookRecordLeftTime=" + BookRecordLeftTime
				+ "]";
	}
	
	
	
	

}
