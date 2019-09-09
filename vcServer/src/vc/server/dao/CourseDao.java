package vc.server.dao;

import java.util.List;

import vc.list.common.Course;


public interface CourseDao {
	Course QueryID(String str);//通过课程ID查询
	
	
	List<Course> getAllCourse();//返回所有课程
	List<Course> getStudentCourse(String id);
	List<Course> getTeacherCourse(String id);
	boolean InsertCourse(Course course);//添加课程
	boolean DeleteCourse(Course course);//删除课程
}
