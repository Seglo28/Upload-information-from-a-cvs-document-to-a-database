package com.practice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.practice.entities.Student_information;
import com.practice.repository.StudentRepository;
import com.practice.service.StudentService;

@Service("studentservice")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	@Qualifier("studentrepository")
	private StudentRepository studentRepository;
	
	@Override
	public List<Student_information> listAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	/*@Override
	public Student_information addStudent(Student_information student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}*/

	@Override
	public Student_information addStudent(List<Student_information> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
