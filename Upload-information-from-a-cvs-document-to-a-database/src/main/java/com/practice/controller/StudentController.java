package com.practice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.practice.cvsmethods.CvsPrincipalValidations;
import com.practice.entities.Student_information;
import com.practice.service.StudentService;

@RestController
@RequestMapping("/StudentController")
public class StudentController {
	
	@Autowired
	@Qualifier("studentservice")
	private StudentService studentService;
	
	//This object is called from CvsPrincipalValidations class.
	CvsPrincipalValidations cvsPrincipal = new CvsPrincipalValidations();
	
	//Copy cvs file information to a database table
	@PostMapping("/dataTransference")
	public String dataTransference(@RequestParam MultipartFile document ) throws IOException {
		String result = "Hecho";
		studentService.addStudent(cvsPrincipal.fromCvsFileToSqlTable(document));
		System.out.println("There are your 4 lists: "+cvsPrincipal.fromCvsFileToSqlTable(document));
		return result;
	}
}
