package vc.list.common;

import java.io.Serializable;

public class Course implements Serializable {

	/**
	 * 
	 */
	private String courseID;
	private String courseName;
	private String courseTeacher;
	private String courseTime;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Course(String CourseID, String CourseName, String CourseTeacher,String CourseTime) {
		super();
		courseID = CourseID;
		courseName = CourseName;
		courseTeacher = CourseTeacher;
		courseTime= CourseTime;
	}
	
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	@Override
	public String toString() {
		return "Course [CourseID=" + courseID + ", CourseName=" + courseName + ", CourseTeacher=" + courseTeacher + ", CourseTime=" + courseTime + "]";
	}
	
}
