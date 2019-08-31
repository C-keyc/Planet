package vc.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vc.list.common.User;
import vc.server.db.AccessUtil;

public class UserDao_Imp implements UserDao {
	public static final String SQL_USER_LOGIN = "SELECT * FROM User WHERE UserID=? AND UserPassword=?";
	
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
				return new User(id,password,type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
