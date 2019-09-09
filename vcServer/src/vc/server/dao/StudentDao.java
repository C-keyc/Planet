package vc.server.dao;

import java.util.List;
import vc.list.common.Student;

public interface StudentDao {
	List<Student> QueryName(String str);//通过学生名称查询
	List<Student> QueryID(String str);//通过一卡通查询
	List<Student> QueryNum(String str);//通过学号查询
	List<Student> QueryDepartment(String str);//通过学院查询
	List<Student> QueryMajor(String str);//通过专业查询
	List<Student> QueryGrade(String str);//通过入学年份查询
	
	List<Student> getAllStudents();//返回所有学生
	
	int InsertStudent(Student student);//添加学生学籍信息
	boolean DeleteStudent(Student student);//删除学生学籍信息
	
	boolean UpdateStudentName(Student student);//修改学生姓名
	boolean UpdateStudentNum(Student student);//修改学生学号
	boolean UpdateStudentGrade(Student student);//修改学生入学年份
	boolean UpdateStudentDepartment(Student student);//修改学生院系
	boolean UpdateStudentMajor(Student student);//修改学生专业
	boolean UpdateStudentClass(Student student);//修改学生班级
	boolean UpdateStudentLength(Student student);//修改学生学制
	boolean UpdateStudentRe(Student student);//修改学生在籍状态
	boolean UpdateStudentinSchool(Student student);//修改学生在校状态
	
}
