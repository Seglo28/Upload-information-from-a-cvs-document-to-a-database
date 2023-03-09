package com.practice.service;

import java.util.List;

import com.practice.entities.Student_information;

public interface StudentService {

	public abstract List<Student_information> listAllStudents();
	
	public abstract Student_information addStudent(List<Student_information> list);

	//Student_information addStudent(Student_information student);
}
