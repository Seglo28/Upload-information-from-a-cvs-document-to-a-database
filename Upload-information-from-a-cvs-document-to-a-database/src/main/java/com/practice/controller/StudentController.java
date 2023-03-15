package com.practice.controller;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entities.Student_information;
import com.practice.service.implementation.StudentServiceImpl;

@RestController
@RequestMapping("/StudentController")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	//Copy cvs file information to a database table
	@PostMapping("/datatransference")
	public void setDataInDB() throws IOException {
		studentService.saveStudents();
	}
	
	//Show a student by id
	@PostMapping("/showdatabyid")
	public Student_information showDataById (@RequestParam int id) {
		return studentService.findById(id);
	}
	
	//Show all students
	@PostMapping("/showdata")
	public Iterable<Student_information> showData() {
		return studentService.findAllStudent();
	}
	
	//Delete by id
	@PostMapping("/deletebyid")
	public void deleteById(@RequestParam int id) {
		studentService.delete(id);
	}
	
	//Delete all
	@PostMapping("/deleteall")
	public void deleteAll() {
		studentService.deleteAll();
	}
	
	//Editing a student information
	@PostMapping("/savestudent")
	public String saveStudent(@RequestBody Student_information student) {
		return studentService.saveStudent(student);
	}
}
