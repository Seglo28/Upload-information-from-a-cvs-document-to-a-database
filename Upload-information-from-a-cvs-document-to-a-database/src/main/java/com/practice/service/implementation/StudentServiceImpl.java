package com.practice.service.implementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Arrays;
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
		
		Iterable<Student_information> findAllStudent = studentRepository.findAll(); 
		if(findAllStudent.iterator().hasNext()) {
			System.out.println("Te values are: "+findAllStudent);
		}else {
			System.out.println("The table is empty.-");
		}
		return findAllStudent;
	}
	
	//Delete a student
	public void delete(int id){
		Optional<Student_information> optionalStudent = studentRepository.findById(id);

		if(optionalStudent.isPresent()) {
		studentRepository.deleteById(id);
		System.out.println("Done.");
		}else{
			System.out.println(":(");	
		}
	}
	
	public void deleteAll () {
			studentRepository.deleteAll();
			System.out.println("Done.");
		}
	
	//Add a new Student
	public String saveStudent(Student_information student) {
		String message = "";
		Student_information addOne = new Student_information();
		
		if (studentRepository.findByEmail(student.getEmail()) == null) {
			addOne.setFirts_name(student.getFirts_name());
			addOne.setLast_name(student.getLast_name());
			addOne.setEmail(student.getEmail());
			addOne.setTelephone(student.getTelephone());
			studentRepository.save(addOne);
			message = "Registrado.";
		}else{
			message = "Dato repetido.";
		}
		return message;
	}
	
	//Update student
	public Student_information updateStudent(Student_information student){

		//I call to the isUsser method because the optional didn't accept a class
		//variable, only primitives; and for that, UpdateStudent pass a parameter
		//called: "student.getId".
		if(this.isUsser(student.getId())) {
			
			//Saving data
			Student_information data = studentRepository.findById(student.getId()).get();
			data.setFirts_name(student.getFirts_name());
			data.setLast_name(student.getLast_name());
			data.setEmail(student.getEmail());
			data.setTelephone(student.getTelephone());
			studentRepository.save(data);		
		}
		return this.findById(student.getId());
	}
	
	//Validating if an user is present in "student_information" table.
	//Optional is needed only, primitives arguments. I passed and argument
	// here, and now it type is primitive.
	private boolean isUsser(int id){
		boolean result = true;

		//Validating if this student id exist.
		Optional <Student_information> studentId = studentRepository.findById(id);
		result = (studentId.isPresent())? true:false;
		return result;
	}
	
	
}