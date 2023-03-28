package com.javalab.awt.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 오직 데이터를 보관하는 데이터베이스 역할
 */
public class DatabaseClass {
	public List<Student> studentList; // 학생 ArrayList
	public List<Professor> professorList;	// 교수 ArrayList
	public List<Department> departmentList;	// 학과 ArrayList
	public List<Takes> takesList;	// 성적 ArrayList
	
	public DatabaseClass() {
		studentList = new ArrayList<Student>(); // 학생 ArrayList
		professorList = new ArrayList<Professor>(); // 교수 ArrayList
		departmentList = new ArrayList<Department>();	// 학과 ArrayList
		takesList = new ArrayList<Takes>();	// 성적 ArrayList
	}
	
	public  List<Student> getStudentList() {
		return studentList;
	}
	public   void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public List<Professor> getProfessorList() {
		return professorList;
	}
	public void setProfessorList(List<Professor> professorList) {
		this.professorList = professorList;
	}
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	public List<Takes> getTakesList() {
		return takesList;
	}
	public void setTakesList(List<Takes> takesList) {
		this.takesList = takesList;
	}

	// 학생 한명 추가 메소드
	public void addStudent(Student student) {
		this.studentList.add(student);
	}
	
	public void addProfessor(Professor professor) {
		this.professorList.add(professor);
	}
	
	public void addDepartment(Department department) {
		this.departmentList.add(department);
	}
	
	public void addTakes(Takes takes) {
		this.takesList.add(takes);
	}
	// 현재 등록된 학생수[학생 list를 보여줄 2차원 배열의 크기에 사용]
	public int getStudentCount() {
		return studentList.size();
	}
	
	// 현재 등록된 교수 숫자
	public int getProfessorCount() {
		return professorList.size();
	}
	
	// 현재 등록된 학과수
	public int getDepartmentCount() {
		return departmentList.size();
	}
	// 현재 등록된 성적수
	public int getTakesCount() {
		return takesList.size();
	}
}