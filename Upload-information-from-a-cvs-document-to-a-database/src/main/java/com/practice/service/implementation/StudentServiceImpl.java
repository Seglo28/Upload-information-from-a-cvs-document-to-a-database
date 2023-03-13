package com.practice.service.implementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
		int c=0;
		BufferedReader reader = new BufferedReader(new FileReader ("c:/upload_java/StudentInformation.csv"));
		try {
			
			
			
			while((line = reader.readLine()) != null) {
				
				/*if(c==0) {
					continue;
				} else {*/
					String[] raw = line.split(";");
					Student_information student = new Student_information();
					
					student.setFirts_name(raw[0]);
					student.setLast_name(raw[1]);
					student.setEmail(raw[2]);
					student.setTelephone(raw[3]);
					studentRepository.save(student);	
					
					System.out.println("Done "+ studentRepository);
				//}
				//c++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Here is an exception: "+e);
			e.printStackTrace();
		}finally {
			reader.close();
			System.out.println("Se cerro el reader");
		}
	}

	//Show a student by id
	public Student_information findById(int id){
		
		//Crating an Student_information class object.
		Student_information studentModel = new Student_information();
		//Crating an Student_information empty project.
		Student_information studentEntity = null;
		
		//Finding data by id
		Optional<Student_information> optionalStudent = studentRepository.findById(id);
		
		//Checking if "id" is present in this optional or not
		if(optionalStudent.isPresent()) {
			//Getting data from optionalStudent to studentEntity
			studentEntity = optionalStudent.get();
			//Coping data from studentEntiry to srudenrModel
			BeanUtils.copyProperties(studentEntity, studentModel);
		}
		return studentModel;
	}
	
	//Find all students
	public Iterable<Student_information> findAllStudent() {
		Iterable<Student_information> findAll = studentRepository.findAll(); 
		return findAll;
		
	}
	
	
}

