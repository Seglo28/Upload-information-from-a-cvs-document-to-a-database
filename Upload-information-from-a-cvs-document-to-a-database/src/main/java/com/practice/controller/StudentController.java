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
	
	CvsPrincipalValidations cvsPrincipal = new CvsPrincipalValidations();
	@PostMapping("/pueba")
	public String imprimiendoalgo(){
		String result =  "holi";
		System.out.println("Estoy en el metodo del controlador");
		return result;
	}
	
	@PostMapping("/prueba")
	public String pruebaMetodos(@RequestParam MultipartFile document) throws IOException {
		String result = cvsPrincipal.validatingCsvFile(document);
		return result;
	}
}
