package vc.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vc.list.common.Book;
import vc.list.common.BookRecord;
import vc.list.common.Seat;
import vc.server.db.AccessUtil;

public class BookDao_Imp implements BookDao {

	private static final String SQL_BOOK_CHECKBOOK = "SELECT * FROM BookRecord WHERE UserID=?";
	private static final String SQL_BOOK_QUERYNAME = "SELECT * FROM Book WHERE BookName=?";
	private static final String SQL_BOOK_QUERYWRITER = "SELECT * FROM Book WHERE BookWriter=?";
	private static final String SQL_BOOK_QUERYID = "SELECT * FROM Book WHERE BookID=?";
	private static final String SQL_BOOK_CHECKALLBOOK = "SELECT * FROM Book";
	private static final String SQL_BOOK_INSERT = "INSERT INTO Book VALUES(?,?,?,?,?)";
	private static final String SQL_BOOK_DELETE = "DELETE FROM Book WHERE BookID=?";
	private static final String SQL_SEAT_QUERY = "SELECT * FROM Seat WHERE Time=?";

	@Override
	public List<BookRecord> getAllBook(String id) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<BookRecord> bkr= null;
		try {

			prepareStatement = conn.prepareStatement(SQL_BOOK_CHECKBOOK);
			// 执行sql语句 Query8 /，得到结果用result记录
			// 执行语句
			prepareStatement.setString(1, id);
			result = prepareStatement.executeQuery();
			bkr = AccessUtil.BookRecordResultSet2List(result);
			return bkr;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	@Override
	public List<Book> QueryBookName(String name) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Book> bk= new ArrayList<Book>();
		try {

			prepareStatement = conn.prepareStatement(SQL_BOOK_QUERYNAME);
			// 执行sql语句 Query8 /，得到结果用result记录
			// 执行语句
			prepareStatement.setString(1, name);
			result = prepareStatement.executeQuery();
			while (result.next()) {
				String id = result.getString("BookID");
				String namee = result.getString("BookName");
				String writer = result.getString("BookWriter");
				String publish = result.getString("BookPublish");
				String num = result.getString("BookNum");
				bk.add(new Book(id,namee,writer,publish,num));
			}
			return bk;
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	@Override
	public List<Book> QueryBookWriter(String writer) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Book> bk= null;
		try {

			prepareStatement = conn.prepareStatement(SQL_BOOK_QUERYWRITER);
			// 执行sql语句 Query8 /，得到结果用result记录
			// 执行语句
			prepareStatement.setString(1, writer);
			result = prepareStatement.executeQuery();
			bk = AccessUtil.BookResultSet2List(result);
			return bk;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	@Override
	public Book QueryBookID(String id) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {

			prepareStatement = conn.prepareStatement(SQL_BOOK_QUERYID);
			// 执行sql语句 Query8 /，得到结果用result记录
			// 执行语句
			prepareStatement.setString(1, id);
			result = prepareStatement.executeQuery();
			while (result.next()) {
				String idd = result.getString("BookID");
				String namee = result.getString("BookName");
				String writer = result.getString("BookWriter");
				String publish = result.getString("BookPublish");
				String num = result.getString("BookNum");
				return new Book(idd,namee,writer,publish,num);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	public List<Book> CheckAllBook() {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Book> bk= null;
		try {

			prepareStatement = conn.prepareStatement(SQL_BOOK_CHECKALLBOOK);
			result = prepareStatement.executeQuery();
			bk = AccessUtil.BookResultSet2List(result);
			return bk;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	public int AddBook(Book bk) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		Book findedbook = QueryBookID(bk.getBookID());
		if(findedbook==null) {
		int result = -1;
		try {
			prepareStatement = conn.prepareStatement(SQL_BOOK_INSERT);
			prepareStatement.setString(1, bk.getBookID());
			prepareStatement.setString(2, bk.getBookName());
			prepareStatement.setString(3, bk.getBookWriter());
			prepareStatement.setString(4, bk.getBookPublish());
			prepareStatement.setString(5, bk.getBookNum());
			result = prepareStatement.executeUpdate();
			return result;
			}
		    catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement);
		}
		}
		return -2;
		
		
	}

	public boolean DeleteBook(Book bk) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_BOOK_DELETE);
			// 执行sql语句 Query8 /，得到结果用result记录
			prepareStatement.setString(1, bk.getBookID());
			// 执行语句
			result = prepareStatement.executeUpdate();
			return result>0?true:false;
			}
		    catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement);
		}
		return false;

		
	}

	public Seat QuerySeat(Seat seat) {
		
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {

			prepareStatement = conn.prepareStatement(SQL_SEAT_QUERY);
			prepareStatement.setString(1, seat.getSeatTime());
			result = prepareStatement.executeQuery();
			
			while (result.next()) {
				String t = result.getString("Today");
				String tt = result.getString("Tomorrow");
				String d = result.getString("DayafterTomorrow");
				String ttt = result.getString("Time");
				if(seat.getSeatDate()==1)return new Seat(t);
				if(seat.getSeatDate()==2)return new Seat(tt);
				if(seat.getSeatDate()==3)return new Seat(d);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;

	}

	
	
}
