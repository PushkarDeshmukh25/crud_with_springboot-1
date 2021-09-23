package com.vinsys.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vinsys.model.Student;
import com.vinsys.repo.StudentRepo;
@org.springframework.stereotype.Service
public class Service implements ServiceInterf{

	@Autowired
	private StudentRepo repo;
	
	@Override
	public String addStudent(Student student) {
		
		repo.save(student);
		
		return "student added";
	}
	
	//getting all students record by using the method findaAll() of CrudRepository  

	@Override
	public List<Student> getAllStudents() {
		 List<Student> students=new ArrayList<Student>();
		 repo.findAll().forEach(student1 -> students.add(student1));
		return students;
	}
	


	//deleting a specific record by using the method deleteById() of CrudRepository  

	@Override
	public String delete(int studRno) {
		 
		repo.deleteById(studRno);
		return "student deleted";
		
	}
	
	
	
	//updating a record  
	@Override
	public String update(Student stud) {
		 
		repo.save(stud);
		return "Record updated";
	}


	
	//getting a specific record by using the method findById() of CrudRepository  

	public Student getStudentByRno(int studRno) {
		
		return repo.findById(studRno).get();
		}
		
	}
	


