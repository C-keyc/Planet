package vc.server.dao;

import java.util.List;

import vc.list.common.Course;


public interface CourseDao {
	Course QueryID(String str);//ͨ���γ�ID��ѯ
	
	
	List<Course> getAllCourse();//�������пγ�
	List<Course> getStudentCourse(String id);
	List<Course> getTeacherCourse(String id);
	boolean InsertCourse(Course course);//��ӿγ�
	boolean DeleteCourse(Course course);//ɾ���γ�
}
