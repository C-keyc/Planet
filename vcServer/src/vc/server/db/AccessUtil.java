
package vc.server.db;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vc.list.common.Book;
import vc.list.common.BookRecord;
import vc.list.common.Course;
import vc.list.common.Goods;
 
/**
 * @author LZL
 * 本类是数据库的连接工具类
 * 有两个方法
 * public static Connection getConnection()连接的方法
 * public static void Close(Connection conn,Statement st,ResultSet res)释放资源的方法
 */
public class AccessUtil {
	// variables
	private static Connection connection = null;
	//private static Statement statement = null;
	//private static ResultSet resultSet = null;
	public static Connection getConnection() {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			System.out.println("驱动加载成功！");

		} catch (ClassNotFoundException cnfex) {
			System.out.println("驱动加载失败！");
			cnfex.printStackTrace();
		}
		try {
			String msAccDB = new File("").getAbsolutePath().replace('\\', '/') + "/user.mdb";//相对文件获取mdb文件的位置 文件放在工程根目录  
			//新版本Access保存时应该选择2002-2003数据库版本即使.mdb格式
			String dbURL = "jdbc:ucanaccess://" + msAccDB;
			connection = DriverManager.getConnection(dbURL);
			System.out.println("数据库连接成功！");
			
			return connection;
		} 
		catch (SQLException sqlex) {
			System.out.println("数据库连接失败！");
			sqlex.printStackTrace();
		} 
		return null;
	}
	
	public static void Close(Connection conn,Statement st,ResultSet res) {
			try {
				if(res!=null) {
					res.close();
					res=null;
				}
				if(st!=null) {
					st.close();
					st=null;
				}
				if(conn!=null) {
					conn.close();
					conn=null;
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
		
	}

	public static void Close(Connection conn, PreparedStatement st) {
		try {

			if(st!=null) {
				st.close();
				st=null;
			}
			if(conn!=null) {
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
	}

	public static List<Goods> GoodsResultSet2List(ResultSet result) {
		List<Goods> goods = new ArrayList<Goods>();
				
			try {
				while(result.next())
				{
				Goods g = new Goods();
				g.setGoodsID(result.getString(1));
				g.setGoodsName(result.getString(2));
				g.setGoodsPrice(result.getDouble(3));
				goods.add(g);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return goods;
	}
	public static List<BookRecord> BookRecordResultSet2List(ResultSet result) {
		List<BookRecord> bookrecord = new ArrayList<BookRecord>();
		
		try {
			while(result.next())
			{
			BookRecord b = new BookRecord();
			b.setBookRecordID(result.getString(1));
			b.setBookRecordName(result.getString(2));
			b.setBookRecordDate(result.getString(3));
			b.setBookRecordState(result.getString(4));
			b.setBookRecordLeftTime(result.getString(5));
			
			bookrecord.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookrecord;
	}
	
	public static List<Course> CourseResultSet2List(ResultSet result) {
		List<Course> course = new ArrayList<Course>();
				
			try {
				while(result.next())
				{
			    Course g = new Course();
				g.setCourseID(result.getString(1));
				g.setCourseName(result.getString(2));
				g.setCourseTeacher(result.getString(3));
				g.setCourseTime(result.getString(4));
                course.add(g);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return course;
	}

	public static List<Book> BookResultSet2List(ResultSet result) {
		List<Book> booklist = new ArrayList<Book>();
		try {
			while(result.next())
			{
			Book b = new Book();
			b.setBookID(result.getString(1));
			b.setBookName(result.getString(2));
			b.setBookWriter(result.getString(3));
			b.setBookPublish(result.getString(4));
			b.setBookNum(result.getString(5));
			booklist.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return booklist;
	}
}