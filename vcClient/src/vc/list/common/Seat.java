package vc.list.common;

public class Seat implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8422893709270751116L;
	private int SeatDate;
	private String SeatTime;
	private String SeatNum;
	
	public Seat() {
		super();
	}
	
	public Seat(String seatNum) {
		super();
		SeatNum = seatNum;
	}

	public Seat(int seatDate, String seatTime, String seatNum) {
		super();
		SeatDate = seatDate;
		SeatTime = seatTime;
		SeatNum = seatNum;
	}
	@Override
	public String toString() {
		return "Seat [SeatDate=" + SeatDate + ", SeatTime=" + SeatTime + ", SeatNum=" + SeatNum + "]";
	}
	public int getSeatDate() {
		return SeatDate;
	}
	public void setSeatDate(int seatDate) {
		SeatDate = seatDate;
	}
	public String getSeatTime() {
		return SeatTime;
	}
	public void setSeatTime(String seatTime) {
		SeatTime = seatTime;
	}
	public String getSeatNum() {
		return SeatNum;
	}
	public void setSeatNum(String seatNum) {
		SeatNum = seatNum;
	}
	
}
