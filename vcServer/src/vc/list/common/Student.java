package vc.list.common;

public class Student implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5558932995063507810L;
	
	private String StudentName;//����
	private String StudentID;// һ��ͨ��
	private String StudentNum;//ѧ�� ���磺09017001
	private String StudentGrade;//��ѧ��� ���磺2017
	private String StudentDepartment;//ѧ��Ժϵ
	private String StudentMajor;//ѧ��רҵ
	private String StudentClass;//ѧ���༶ ���磺09173
	private String StudentLength;//ѧ��ѧ�� ���磺4
	private String StudentRe;//ѧ���Ƿ��ڼ� ���磺��
	private String StudentinSchool;//ѧ���Ƿ���У ���磺��
	
	
	public Student() {
		super();
	}
	
	public Student(String studentID) {
		super();
		StudentID = studentID;
	}

	public Student(String studentName,String studentID, String studentNum, String studentGrade, String studentDepartment, String studentMajor,
			String studentClass, String studentLength, String studentRe, String studentinSchool) {
		super();
		StudentName =studentName;
		StudentID = studentID;
		StudentNum = studentNum;
		StudentGrade = studentGrade;
		StudentDepartment = studentDepartment;
		StudentMajor = studentMajor;
		StudentClass = studentClass;
		StudentLength = studentLength;
		StudentRe = studentRe;
		StudentinSchool = studentinSchool;
	}

	public String getStudentName() {
		return StudentName;
	}
	
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
	public String getStudentID() {
		return StudentID;
	}
	
	public void setStudentID(String studentID) {
		StudentID = studentID;
	}
	
	public String getStudentNum() {
		return StudentNum;
	}
	
	public void setStudentNum(String studentNum) {
		StudentNum = studentNum;
	}
	
	public String getStudentGrade() {
		return StudentGrade;
	}
	
	public void setStudentGrade(String studentGrade) {
		StudentGrade = studentGrade;
	}
	
	public String getStudentDepartment() {
		return StudentDepartment;
	}
	
	public void setStudentDepartment(String studentDepartment) {
		StudentDepartment = studentDepartment;
	}
	
	public String getStudentMajor() {
		return StudentMajor;
	}
	
	public void setStudentMajor(String studentMajor) {
		StudentMajor = studentMajor;
	}
	
	public String getStudentClass() {
		return StudentClass;
	}
	
	public void setStudentClass(String studentClass) {
		StudentClass = studentClass;
	}
	
	public String getStudentLength() {
		return StudentLength;
	}
	
	public void setStudentLength(String studentLength) {
		StudentLength = studentLength;
	}
	
	public String getStudentRe() {
		return StudentRe;
	}
	
	public void setStudentRe(String studentRe) {
		StudentRe = studentRe;
	}
	
	public String getStudentinSchool() {
		return StudentinSchool;
	}
	
	public void setStudentinSchool(String studentinSchool) {
		StudentinSchool = studentinSchool;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [StudetName=" +StudentName + ",StudentID=" + StudentID + ", StudentNum=" + StudentNum + ", StudentGrade=" + StudentGrade
				+ ", StudentDepartment=" + StudentDepartment + ", StudentMajor=" + StudentMajor + ", StudentClass="
				+ StudentClass + ", StudentLength=" + StudentLength + ", StudentRe=" + StudentRe + ", StudentinSchool="
				+ StudentinSchool + "]";
	}



}
