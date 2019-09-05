
package vc.server.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
			String msAccDB = "C:/Users/Key/Desktop/user.mdb";//这里写你的.mdb文件的位置 注意使用的是正斜杠  
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
}
/*
 * public static void main(String[] args) {
 * 
 * try { Connection con=getConnection(); Statement sta = con.createStatement();
 * ResultSet res = sta.executeQuery("select * from user");
 * 
 * } catch (SQLException e) { e.printStackTrace(); } } }
 */