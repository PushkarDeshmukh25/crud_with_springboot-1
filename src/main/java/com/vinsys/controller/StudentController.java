package com.vinsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinsys.model.Student;
import com.vinsys.services.Service;

@RestController
@RequestMapping("api/v1")
public class StudentController {
	//autowire the Service class 
	@Autowired
	private Service service;
	
	//creating post mapping that post the students detail in the database  

	@PostMapping("/addstudent")
	private String addStudent(@RequestBody Student stud) {
		
		service.addStudent(stud);
		
		return "Student added";

	}
	
	//creating a get mapping that retrieves all the students detail from the database

	@GetMapping("/getallstudents")
	private List<Student> getAllDetails() {
		return service.getAllStudents();
	}
	
	//creating a delete mapping that deletes a specified student  

	@DeleteMapping("/student/{roll_no}")
	private String deleteStudent(@PathVariable("roll_no") int studRno) {
		 service.delete(studRno);
         return "Student Deleted";
	}
    
	//creating put mapping that updates the students detail   

	@PutMapping("/updatestudent/{roll_no}")
	private Student updateStudent(@RequestBody Student stud) {
		 service.update(stud);
		return stud;

	}
	
	//creating a get mapping that retrieves the detail of a specific student  

	@GetMapping("/getonestudent/{roll_no}")
     private Student getStudent(@PathVariable("roll_no") int studRno) {
		return service.getStudentByRno(studRno);

	}

}
