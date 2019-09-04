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
	
	private static final String SQL_STUDENT_UPDATE_NAME = "UPDATE FROM Student SET StuendtName=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_NUM = "UPDATE FROM Student SET StuendtNum=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_GRADE = "UPDATE FROM Student SET StuendtGrade=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_DEPARTMENT = "UPDATE FROM Student SET StuendtDepartment=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_MAJOR = "UPDATE FROM Student SET StuendtMajor=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_CLASS = "UPDATE FROM Student SET StuendtClass=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_LENGTH = "UPDATE FROM Student SET StuendtLength=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_RE = "UPDATE FROM Student SET StuendtRe=? WHERE StudentID=?" ;
	private static final String SQL_STUDENT_UPDATE_INSCHOOL = "UPDATE FROM Student SET StuendtinSchool=? WHERE StudentID=?" ;
	
	@Override
	public List<Student> QueryName(String str) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		List<Student> students =new ArrayList<Student>();
		
		try {
			prepareStatement = conn.prepareStatement(SQL_STUDENT_QUERYNAME);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, str);
			// ִ�����
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
	public Student QueryID(String str) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;

		try {
			prepareStatement = conn.prepareStatement(SQL_STUDENT_QUERYID);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, str);
			// ִ�����
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
				return st;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AccessUtil.Close(conn, prepareStatement, result);
		}
		return null;
	}
	
	@Override
	public Student QueryNum(String str) {
		Connection conn = AccessUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;

		try {
			prepareStatement = conn.prepareStatement(SQL_STUDENT_QUERYNUM);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, str);
			// ִ�����
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
				return st;
			}
			
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
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, str);
			// ִ�����
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
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, str);
			// ִ�����
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
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, str);
			// ִ�����
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
			// ִ��SQL��䣬�õ������result��¼
			
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
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, student.getStudentName());
			prepareStatement.setString(2, student.getStudentID());
			prepareStatement.setString(3, student.getStudentNum());
			prepareStatement.setString(4, student.getStudentGrade());
			prepareStatement.setString(5, student.getStudentDepartment());
			prepareStatement.setString(6, student.getStudentMajor());
			prepareStatement.setString(7, student.getStudentClass());
			prepareStatement.setString(8, student.getStudentLength());
			prepareStatement.setString(9, student.getStudentRe());
			prepareStatement.setString(10, student.getStudentinSchool());
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
	public boolean Deletestudent(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_DELETE);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, student.getStudentID());
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
	public boolean UpdateStudentName(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_NAME);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, student.getStudentName());
			prepareStatement.setString(2, student.getStudentID());
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
	public boolean UpdateStudentNum(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_NUM);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, student.getStudentNum());
			prepareStatement.setString(2, student.getStudentID());
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
	public boolean UpdateStudentYear(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_GRADE);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, student.getStudentGrade());
			prepareStatement.setString(2, student.getStudentID());
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
	public boolean UpdateStudentDepartment(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_DEPARTMENT);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, student.getStudentDepartment());
			prepareStatement.setString(2, student.getStudentID());
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
	public boolean UpdateStudentMajor(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_MAJOR);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, student.getStudentMajor());
			prepareStatement.setString(2, student.getStudentID());
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
	public boolean UpdateStudentClass(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_CLASS);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, student.getStudentClass());
			prepareStatement.setString(2, student.getStudentID());
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
	public boolean UpdateStudentLength(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_LENGTH);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, student.getStudentLength());
			prepareStatement.setString(2, student.getStudentID());
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
	public boolean UpdateStudentRe(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_RE);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, student.getStudentRe());
			prepareStatement.setString(2, student.getStudentID());
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
	public boolean UpdateStudentinSchool(Student student) {
		Connection conn = AccessUtil.getConnection();

		PreparedStatement prepareStatement = null;
		int result = -1;
		try {

			prepareStatement = conn.prepareStatement(SQL_STUDENT_UPDATE_INSCHOOL);
			// ִ��SQL��䣬�õ������result��¼
			prepareStatement.setString(1, student.getStudentinSchool());
			prepareStatement.setString(2, student.getStudentID());
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