package vc.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vc.list.common.Student;
import vc.server.db.AccessUtil;

public class StudentDao_Imp implements StudentDao {

	private static final String SQL_STUDENT_QUERYNAME = "SELECT * FROM Student WHERE StudentName=?";
	private static final String SQL_STUDENT_QUERYID ="SELECT * FROM Student WHERE StudentID=?";
	private static final String SQL_STUDENT_QUERYNUM ="SELECT * FROM Student WHERE StudentNum=?";
	private static final String SQL_STUDENT_QUERYDEPARTMENT ="SELECT * FROM Student WHERE StudentDepartment=?";
	private static final String SQL_STUDENT_QUERYMAJOR ="SELECT * FROM Student WHERE StudentMajor=?";
	private static final String SQL_STUDENT_QUERYGRADE ="SELECT * FROM Student WHERE StudentGrade=?";
	
	private static final String SQL_STUDENT_GETALLSTUDENT = "select * from Student";

	
	private static final String SQL_STUDENT_INSERT = "INSERT INTO Student VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_STUDENT_DELETE = "DELETE FROM Student WHERE StudentID=?";
	
	private static final String SQL_STUDENT_UPDATE_NAME = "UPDATE Student SET StudentName=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_NUM = "UPDATE Student SET StudentNum=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_GRADE = "UPDATE Student SET StudentGrade=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_DEPARTMENT = "UPDATE Student SET StudentDepartment=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_MAJOR = "UPDATE Student SET StudentMajor=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_CLASS = "UPDATE Student SET StudentClass=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_LENGTH = "UPDATE Student SET StudentLength=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_RE = "UPDATE Student SET StudentRe=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_INSCHOOL = "UPDATE Student SET StudentinSchool=? WHERE StudentID=?" ;
	
	@Override
	public List<Student> QueryName(String str) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Student> students =new ArrayList<Student>();
		
		try {
			prepareStatement = conn.prepareStatement(SQL_STUDENT_QUERYNAME);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, str);
			// 执行语句
			result = prepareStatement.executeQuery();
			while (result.next()) {
				Student st =new Student();
				st.setStudentName( result.getString("StudentName"));
				st.setStudentID( result.getString("StudentID"));
				st.setStudentNum( result.getString("StudentNum"));
				st.setStudentGrade( result.getString("StudentGrade"));
				st.setStudentDepartment( result.getString("StudentDepartment"));
				st.setStudentMajor( result.getString("StudentMajor"));
				st.setStudentClass( result.getString("StudentClass"));
				st.setStudentLength( result.getString("StudentLength"));
				st.setStudentRe( result.getString("StudentRe"));
				st.setStudentinSchool( result.getString("StudentinSchool"));
				students.add(st);
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	@Override
	public List<Student> QueryID(String str) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Student> students =new ArrayList<Student>();
		
		try {
			prepareStatement = conn.prepareStatement(SQL_STUDENT_QUERYID);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, str);
			// 执行语句
			result = prepareStatement.executeQuery();
			while (result.next()){
				Student st =new Student();
				st.setStudentName( result.getString("StudentName"));
				st.setStudentID( result.getString("StudentID"));
				st.setStudentNum( result.getString("StudentNum"));
				st.setStudentGrade( result.getString("StudentGrade"));
				st.setStudentDepartment( result.getString("StudentDepartment"));
				st.setStudentMajor( result.getString("StudentMajor"));
				st.setStudentClass( result.getString("StudentClass"));
				st.setStudentLength( result.getString("StudentLength"));
				st.setStudentRe( result.getString("StudentRe"));
				st.setStudentinSchool( result.getString("StudentinSchool"));
				students.add(st);
			}
			
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}
	
	@Override
	public List<Student> QueryNum(String str) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Student> students =new ArrayList<Student>();
		
		try {
			prepareStatement = conn.prepareStatement(SQL_STUDENT_QUERYNUM);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, str);
			// 执行语句
			result = prepareStatement.executeQuery();
			while (result.next()) {
				Student st =new Student();
				st.setStudentName( result.getString("StudentName"));
				st.setStudentID( result.getString("StudentID"));
				st.setStudentNum( result.getString("StudentNum"));
				st.setStudentGrade( result.getString("StudentGrade"));
				st.setStudentDepartment( result.getString("StudentDepartment"));
				st.setStudentMajor( result.getString("StudentMajor"));
				st.setStudentClass( result.getString("StudentClass"));
				st.setStudentLength( result.getString("StudentLength"));
				st.setStudentRe( result.getString("StudentRe"));
				st.setStudentinSchool( result.getString("StudentinSchool"));
				students.add(st);
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	@Override
	public List<Student> QueryDepartment(String str) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Student> students =new ArrayList<Student>();
		
		try {
			prepareStatement = conn.prepareStatement(SQL_STUDENT_QUERYDEPARTMENT);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, str);
			// 执行语句
			result = prepareStatement.executeQuery();
			while (result.next()) {
				Student st =new Student();
				st.setStudentName( result.getString("StudentName"));
				st.setStudentID( result.getString("StudentID"));
				st.setStudentNum( result.getString("StudentNum"));
				st.setStudentGrade( result.getString("StudentGrade"));
				st.setStudentDepartment( result.getString("StudentDepartment"));
				st.setStudentMajor( result.getString("StudentMajor"));
				st.setStudentClass( result.getString("StudentClass"));
				st.setStudentLength( result.getString("StudentLength"));
				st.setStudentRe( result.getString("StudentRe"));
				st.setStudentinSchool( result.getString("StudentinSchool"));
				students.add(st);
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}
	
	@Override
	public List<Student> QueryMajor(String str) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Student> students =new ArrayList<Student>();
		
		try {
			prepareStatement = conn.prepareStatement(SQL_STUDENT_QUERYMAJOR);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, str);
			// 执行语句
			result = prepareStatement.executeQuery();
			while (result.next()) {
				Student st =new Student();
				st.setStudentName( result.getString("StudentName"));
				st.setStudentID( result.getString("StudentID"));
				st.setStudentNum( result.getString("StudentNum"));
				st.setStudentGrade( result.getString("StudentGrade"));
				st.setStudentDepartment( result.getString("StudentDepartment"));
				st.setStudentMajor( result.getString("StudentMajor"));
				st.setStudentClass( result.getString("StudentClass"));
				st.setStudentLength( result.getString("StudentLength"));
				st.setStudentRe( result.getString("StudentRe"));
				st.setStudentinSchool( result.getString("StudentinSchool"));
				students.add(st);
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}
	
	@Override
	public List<Student> QueryGrade(String str) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Student> students =new ArrayList<Student>();
		
		try {
			prepareStatement = conn.prepareStatement(SQL_STUDENT_QUERYGRADE);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, str);
			// 执行语句
			result = prepareStatement.executeQuery();
			while (result.next()) {
				Student st =new Student();
				st.setStudentName( result.getString("StudentName"));
				st.setStudentID( result.getString("StudentID"));
				st.setStudentNum( result.getString("StudentNum"));
				st.setStudentGrade( result.getString("StudentGrade"));
				st.setStudentDepartment( result.getString("StudentDepartment"));
				st.setStudentMajor( result.getString("StudentMajor"));
				st.setStudentClass( result.getString("StudentClass"));
				st.setStudentLength( result.getString("StudentLength"));
				st.setStudentRe( result.getString("StudentRe"));
				st.setStudentinSchool( result.getString("StudentinSchool"));
				students.add(st);
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}
	
	@Override
	public List<Student> getAllStudents() {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Student> students =new ArrayList<Student>();
		
		try {
			prepareStatement = conn.prepareStatement(SQL_STUDENT_GETALLSTUDENT);
			// 执行SQL语句，得到结果用result记录
			
			result = prepareStatement.executeQuery();
			while (result.next()) {
				Student st =new Student();
				st.setStudentName( result.getString("StudentName"));
				st.setStudentID( result.getString("StudentID"));
				st.setStudentNum( result.getString("StudentNum"));
				st.setStudentGrade( result.getString("StudentGrade"));
				st.setStudentDepartment( result.getString("StudentDepartment"));
				st.setStudentMajor( result.getString("StudentMajor"));
				st.setStudentClass( result.getString("StudentClass"));
				st.setStudentLength( result.getString("StudentLength"));
				st.setStudentRe( result.getString("StudentRe"));
				st.setStudentinSchool( result.getString("StudentinSchool"));
				students.add(st);
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}

	@Override
	public boolean InsertStudent(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_INSERT);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(10, student.getStudentName());
			prepareStatement.setString(1, student.getStudentID());
			prepareStatement.setString(2, student.getStudentNum());
			prepareStatement.setString(3, student.getStudentGrade());
			prepareStatement.setString(4, student.getStudentDepartment());
			prepareStatement.setString(5, student.getStudentMajor());
			prepareStatement.setString(6, student.getStudentClass());
			prepareStatement.setString(7, student.getStudentLength());
			prepareStatement.setString(8, student.getStudentRe());
			prepareStatement.setString(9, student.getStudentinSchool());
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

	@Override
	public boolean DeleteStudent(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_DELETE);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, student.getStudentID());
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

	@Override
	public boolean UpdateStudentName(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_NAME);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, student.getStudentName());
			prepareStatement.setString(2, student.getStudentID());
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

	@Override
	public boolean UpdateStudentNum(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_NUM);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, student.getStudentNum());
			prepareStatement.setString(2, student.getStudentID());
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

	@Override
	public boolean UpdateStudentGrade(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_GRADE);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, student.getStudentGrade());
			prepareStatement.setString(2, student.getStudentID());
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

	@Override
	public boolean UpdateStudentDepartment(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_DEPARTMENT);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, student.getStudentDepartment());
			prepareStatement.setString(2, student.getStudentID());
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

	@Override
	public boolean UpdateStudentMajor(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_MAJOR);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, student.getStudentMajor());
			prepareStatement.setString(2, student.getStudentID());
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

	@Override
	public boolean UpdateStudentClass(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_CLASS);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, student.getStudentClass());
			prepareStatement.setString(2, student.getStudentID());
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

	@Override
	public boolean UpdateStudentLength(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_LENGTH);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, student.getStudentLength());
			prepareStatement.setString(2, student.getStudentID());
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

	@Override
	public boolean UpdateStudentRe(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_RE);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, student.getStudentRe());
			prepareStatement.setString(2, student.getStudentID());
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

	@Override
	public boolean UpdateStudentinSchool(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_INSCHOOL);
			// 执行SQL语句，得到结果用result记录
			prepareStatement.setString(1, student.getStudentinSchool());
			prepareStatement.setString(2, student.getStudentID());
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