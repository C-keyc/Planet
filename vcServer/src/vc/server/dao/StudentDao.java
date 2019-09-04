package vc.server.dao;

import java.util.List;
import vc.list.common.Student;

public interface StudentDao {
	List<Student> QueryName(String str);//ͨ��ѧ�����Ʋ�ѯ
	Student QueryID(String str);//ͨ��һ��ͨ��ѯ
	Student QueryNum(String str);//ͨ��ѧ�Ų�ѯ
	List<Student> QueryDepartment(String str);//ͨ��ѧԺ��ѯ
	List<Student> QueryMajor(String str);//ͨ��רҵ��ѯ
	List<Student> QueryGrade(String str);//ͨ����ѧ��ݲ�ѯ
	
	List<Student> getAllStudents();//��������ѧ��
	
	boolean InsertStudent(Student student);//���ѧ��ѧ����Ϣ
	boolean Deletestudent(Student student);//ɾ��ѧ��ѧ����Ϣ
	
	boolean UpdateStudentName(Student student);//�޸�ѧ������
	boolean UpdateStudentNum(Student student);//�޸�ѧ��ѧ��
	boolean UpdateStudentYear(Student student);//�޸�ѧ����ѧ���
	boolean UpdateStudentDepartment(Student student);//�޸�ѧ��Ժϵ
	boolean UpdateStudentMajor(Student student);//�޸�ѧ��רҵ
	boolean UpdateStudentClass(Student student);//�޸�ѧ���༶
	boolean UpdateStudentLength(Student student);//�޸�ѧ��ѧ��
	boolean UpdateStudentRe(Student student);//�޸�ѧ���ڼ�״̬
	boolean UpdateStudentinSchool(Student student);//�޸�ѧ����У״̬
	
}
