package com.practice.service.implementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entities.Student_information;
import com.practice.repository.StudentRepository;
import com.practice.service.StudentService;

@Service("studentservice")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public void saveStudents() throws IOException {
		//Variables
		String line = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader ("c:/upload_java/StudentInformation.csv"));
			while((line = reader.readLine()) != null) {
				String[] raw = line.split(";");
				Student_information student = new Student_information();
				
				student.setFirts_name(raw[0]);
				student.setLast_name(raw[1]);
				student.setEmail(raw[2]);
				student.setTelephone(raw[3]);
				studentRepository.save(student);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Here is an exception: "+e);
			e.printStackTrace();
		}
	}

}
