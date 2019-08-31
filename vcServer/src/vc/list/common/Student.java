package vc.list.common;

public class Student implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5558932995063507810L;
	
	private String StudentID;//key һ��ͨ��
	private String StudentNum;//ѧ�� ���磺09017001
	private int StudentGrade;//��ѧ��� ���磺2017
	private String StudentDepartment;//ѧ��Ժϵ
	private String StudentMajor;//ѧ��רҵ
	private String StudentClass;//ѧ���༶ ���磺09173
	private int StudentLength;//ѧ��ѧ�� ���磺4
	private String StudentRe;//ѧ���Ƿ��ڼ� ���磺��
	private String StudentinSchool;//ѧ���Ƿ���У ���磺��
	
	
	
	public Student(String studentID) {
		super();
		StudentID = studentID;
	}

	public Student(String studentID, String studentNum, int studentGrade, String studentDepartment, String studentMajor,
			String studentClass, int studentLength, String studentRe, String studentinSchool) {
		super();
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
	
	public int getStudentGrade() {
		return StudentGrade;
	}
	
	public void setStudentGrade(int studentGrade) {
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
	
	public int getStudentLength() {
		return StudentLength;
	}
	
	public void setStudentLength(int studentLength) {
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
		return "Student [StudentID=" + StudentID + ", StudentNum=" + StudentNum + ", StudentGrade=" + StudentGrade
				+ ", StudentDepartment=" + StudentDepartment + ", StudentMajor=" + StudentMajor + ", StudentClass="
				+ StudentClass + ", StudentLength=" + StudentLength + ", StudentRe=" + StudentRe + ", StudentinSchool="
				+ StudentinSchool + "]";
	}



}
