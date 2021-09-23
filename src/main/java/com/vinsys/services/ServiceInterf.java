package com.vinsys.services;

import java.util.List;

import com.vinsys.model.Student;

public interface ServiceInterf {
	
	public String addStudent(Student student);

	List<Student> getAllStudents();

	String delete(int studRno);

	String update(Student stud);
	
	Student getStudentByRno(int studRno);


}
