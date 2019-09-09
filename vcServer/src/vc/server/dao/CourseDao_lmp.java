package vc.server.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vc.list.common.Course;
import vc.list.common.CourseOwner;
import vc.server.db.AccessUtil;

public class CourseDao_lmp implements CourseDao {

	private static final String SQL_Course_QUERYID ="SELECT * FROM Course WHERE courseID=?";
	private static final String SQL_Course_INSERT = "INSERT INTO Course VALUES(?,?,?,?)";
	private static final String SQL_Course_DELETE = "DELETE FROM Course WHERE courseID=?";
	private static final String SQL_Course_GETALLCOURSE = "SELECT * FROM Course";
	private static final String SQL_CourseOwner_INSERT = "INSERT INTO CourseOwner(ownerID,courseID) VALUES(?,?)";
	private static final String SQL_CourseOwner_DELETE = "DELETE FROM CourseOwner WHERE ownerID=? AND courseID=?";
	private static final String SQL_CourseOwner_QUERY_COURSEID="SELECT courseID FROM CourseOwner WHERE ownerID=?";
	private static final String SQL_Course_QUERY_COURSENAME="SELECT * FROM Course WHERE courseTeacher=?";
	
	
	@Override
	public Course QueryID(String str) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {

			prepareStatement = conn.prepareStatement(SQL_Course_QUERYID);
			prepareStatement.setString(1, str);
			result = prepareStatement.executeQuery();
			while (result.next()) {
				String id = result.getString("courseID");
				String name = result.getString("courseName");
				String teacher = result.getString("courseTeacher");
				String time = result.getString("courseTime");
				return new Course(id, name, teacher,time);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	
	@Override
	public List<Course> getAllCourse() {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Course> course= null;
		try {

			prepareStatement = conn.prepareStatement(SQL_Course_GETALLCOURSE);
			// 执行sql语句 Query8 /，得到结果用result记录
			// 执行语句
			result = prepareStatement.executeQuery();
			course = AccessUtil.CourseResultSet2List(result);
			return course;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	public List<Course> getStudentCourse(String id) {
		Connection conn = AccessUtil.getConnection();
        CourseOwner courseowner=new CourseOwner();
        courseowner.setOwnerID(id);
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Course> course= new ArrayList<Course>();
		try {
			prepareStatement = conn.prepareStatement(SQL_CourseOwner_QUERY_COURSEID);
			prepareStatement.setString(1, id);
			result = prepareStatement.executeQuery();

			while(result.next()){
				String IDDD=result.getString("courseID");
				course.add(QueryID(IDDD));
			}
			return course;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}
	
	public List<Course> getTeacherCourse(String name) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Course> course= new ArrayList<Course>();
		try {

			prepareStatement = conn.prepareStatement(SQL_Course_QUERY_COURSENAME);
			prepareStatement.setString(1, name);
			result = prepareStatement.executeQuery();
			
			while(result.next()){
				String IDDDD=result.getString("courseID");
				course.add(QueryID(IDDDD));
			}
			return course;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}
	
	@Override
	public boolean InsertCourse(Course course) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		int result = -1;
		try {
          
			prepareStatement = conn.prepareStatement(SQL_Course_INSERT);
			// 执行sql语句 Query8 /，得到结果用result记录
			prepareStatement.setString(1, course.getCourseID());
			prepareStatement.setString(2, course.getCourseName());
			prepareStatement.setString(3, course.getCourseTeacher());
			prepareStatement.setString(4, course.getCourseTime());
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
	
	public boolean ChooseCourse(CourseOwner courseowner) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		int result = -1;
		try {
			prepareStatement = conn.prepareStatement(SQL_CourseOwner_INSERT);
			// 执行sql语句 Query8 /，得到结果用result记录
			prepareStatement.setString(1, courseowner.getOwnerID());
			prepareStatement.setString(2, courseowner.getCourseID());
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
	
	public boolean QuitCourse(CourseOwner courseowner) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_CourseOwner_DELETE);
			prepareStatement.setString(1, courseowner.getOwnerID());
			prepareStatement.setString(2, courseowner.getCourseID());
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
	public boolean DeleteCourse(Course course) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_Course_DELETE);
			// 执行sql语句 Query8 /，得到结果用result记录
			prepareStatement.setString(1, course.getCourseID());
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
