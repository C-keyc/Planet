package vc.list.common;


import java.io.Serializable;

public class CourseOwner implements Serializable  {
	
	private String courseID;
	private String ownerID;
	
	public CourseOwner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CourseOwner(String CourseID, String OwnerID) {
		super();
		courseID = CourseID;
		ownerID = OwnerID;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	
	public String toString() {
		return "CourseOwner [CourseID=" + courseID + ", OwnerID=" + ownerID + "]";
	}
}
