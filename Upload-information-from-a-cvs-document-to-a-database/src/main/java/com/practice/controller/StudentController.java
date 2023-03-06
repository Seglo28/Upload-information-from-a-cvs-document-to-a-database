package com.practice.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.practice.cvsmethods.CvsPrincipalValidations;

@RestController
@RequestMapping("/StudentController")
public class StudentController {
	
	
	//This object is called from CvsPrincipalValidations class.
	CvsPrincipalValidations cvsPrincipal = new CvsPrincipalValidations();
	
	//Validating cvs if this is a cvs file, and if contain utf8-BOM - if is true, delete.
	@PostMapping("/validation")
	public void validatingCsvDocument(@RequestParam MultipartFile document) throws IOException {
		cvsPrincipal.validatingCsvFile(document);
	}
}
