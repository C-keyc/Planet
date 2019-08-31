package vc.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import vc.list.common.Goods;
import vc.server.db.AccessUtil;

public class GoodsDao_Imp implements GoodsDao {

	private static final String SQL_GOODS_QUERYNAME = "SELECT * FROM Goods WHERE GoodsName=?";
	private static final String SQL_GOODS_QUERYID ="SELECT * FROM Goods WHERE GoodsID=?";
	private static final String SQL_GOODS_INSERT = "INSERT INTO Goods VALUES(?,?,?)";
	private static final String SQL_GOODS_DELETE = "DELETE FROM Goods WHERE GoodsName=?";
	private static final String SQL_GOODS_UPDATE = "UPDATE FROM Goods SET GoodsPrice=? WHERE GoodsName=?" ;
	private static final String SQL_GOODS_GETALLGOODS = "select * from Goods";

	@Override
	public Goods QueryName(String str) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {

			prepareStatement = conn.prepareStatement(SQL_GOODS_QUERYNAME);
			// ִ��sql��� Query8 /���õ������result��¼
			prepareStatement.setString(1, str);
			// ִ�����
			result = prepareStatement.executeQuery();
			while (result.next()) {
				String id = result.getString("GoodsID");
				String name = result.getString("GoodsName");
				Double price = result.getDouble("GoodsPrice");
				return new Goods(id, name, price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	@Override
	public Goods QueryID(String str) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {

			prepareStatement = conn.prepareStatement(SQL_GOODS_QUERYID);
			// ִ��sql��� Query8 /���õ������result��¼
			prepareStatement.setString(1, str);
			// ִ�����
			result = prepareStatement.executeQuery();
			while (result.next()) {
				String id = result.getString("GoodsID");
				String name = result.getString("GoodsName");
				double price = result.getDouble("GoodsPrice");
				return new Goods(id, name, price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	
	@Override
	public List<Goods> getAllGoods() {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Goods> goods= null;
		try {

			prepareStatement = conn.prepareStatement(SQL_GOODS_GETALLGOODS);
			// ִ��sql��� Query8 /���õ������result��¼
			// ִ�����
			result = prepareStatement.executeQuery();
			goods = AccessUtil.GoodsResultSet2List(result);
			return goods;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	@Override
	public boolean InsertGoods(Goods goods) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_GOODS_INSERT);
			// ִ��sql��� Query8 /���õ������result��¼
			prepareStatement.setString(1, goods.getGoodsID());
			prepareStatement.setString(2, goods.getGoodsName());
			prepareStatement.setDouble(3, goods.getGoodsPrice());
			// ִ�����
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

	@Override
	public boolean DeleteGoods(Goods goods) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_GOODS_DELETE);
			// ִ��sql��� Query8 /���õ������result��¼
			prepareStatement.setString(1, goods.getGoodsName());
			// ִ�����
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

	@Override
	public boolean UpdateGoodes(Goods goods) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_GOODS_UPDATE);
			// ִ��sql��� Query8 /���õ������result��¼
			prepareStatement.setDouble(1, goods.getGoodsPrice());
			prepareStatement.setString(2, goods.getGoodsName());
			// ִ�����
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
