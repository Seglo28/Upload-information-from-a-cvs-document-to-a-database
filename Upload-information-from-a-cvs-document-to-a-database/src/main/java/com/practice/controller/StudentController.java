package com.practice.controller;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entities.Student_information;
import com.practice.service.implementation.StudentServiceImpl;

@RestController
@RequestMapping("/StudentController")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	//Copy cvs file information to a database table
	@PostMapping("/dataTransference")
	public void setDataInDB() throws IOException {
		studentService.saveStudents();
	}
	
	//Show a student by id
	@PostMapping("/showdatabyid")
	public Student_information showDataById (int id) {
		return studentService.findById(id);
	}
	
	@PostMapping("/showdata")
	public Iterable<Student_information> showData() {
		return studentService.findAllStudent();
	}
	
}
