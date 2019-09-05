
package vc.server.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vc.list.common.Goods;
 
/**
 * @author LZL
 * ���������ݿ�����ӹ�����
 * ����������
 * public static Connection getConnection()���ӵķ���
 * public static void Close(Connection conn,Statement st,ResultSet res)�ͷ���Դ�ķ���
 */
public class AccessUtil {
	// variables
	private static Connection connection = null;
	//private static Statement statement = null;
	//private static ResultSet resultSet = null;
	public static Connection getConnection() {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			System.out.println("�������سɹ���");

		} catch (ClassNotFoundException cnfex) {
			System.out.println("��������ʧ�ܣ�");
			cnfex.printStackTrace();
		}
		try {
			String msAccDB = "C:/Users/Key/Desktop/user.mdb";//����д���.mdb�ļ���λ�� ע��ʹ�õ�����б��  
			//�°汾Access����ʱӦ��ѡ��2002-2003���ݿ�汾��ʹ.mdb��ʽ
			String dbURL = "jdbc:ucanaccess://" + msAccDB;
			connection = DriverManager.getConnection(dbURL);
			System.out.println("���ݿ����ӳɹ���");
			
			return connection;
		} 
		catch (SQLException sqlex) {
			System.out.println("���ݿ�����ʧ�ܣ�");
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