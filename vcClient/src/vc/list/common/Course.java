package vc.list.common;

import java.io.Serializable;

public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2150723073912268145L;
	private String name;
	private String rkTeacher;
	
	public Course() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRkTeacher() {
		return rkTeacher;
	}
	public void setRkTeacher(String rkTeacher) {
		this.rkTeacher = rkTeacher;
	}
	

}
