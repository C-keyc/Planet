package vc.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vc.list.common.User;
import vc.server.db.AccessUtil;

public class UserDao_Imp implements UserDao {
	public static final String SQL_USER_LOGIN = "SELECT * FROM User WHERE UserID=? AND UserPassword=?";
	private static final String SQL_ACCOUNT_UPDATE = "UPDATE User SET UserAccount=? WHERE UserID=?" ;

	@Override
	public User Login(User user) {
		Connection conn = AccessUtil.getConnection();
		
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {

			prepareStatement = conn.prepareStatement(SQL_USER_LOGIN);
			//执行sql语句 Query，得到结果用result记录
			prepareStatement.setString(1, user.getUserID());
			prepareStatement.setString(2, user.getUpass());
			//执行语句
			result = prepareStatement.executeQuery();
			while(result.next()){
				String id = result.getString("UserID");
				String password = result.getString("UserPassword");
				int type = result.getInt("Usertype");
				String name = result.getString("UserName");
				double account = result.getDouble("UserAccount");

				return new User(id,password,name,type,account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean UpdateAccount(User user) {
		// TODO Auto-generated method stub
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_ACCOUNT_UPDATE);
			// 执行sql语句 Query8 /，得到结果用result记录
			prepareStatement.setDouble(1, user.getAccount());
			prepareStatement.setString(2, user.getUserID());
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

}
