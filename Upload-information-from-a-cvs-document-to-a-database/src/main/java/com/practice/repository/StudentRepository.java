package com.practice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.practice.entities.Student_information;

@Repository("studentrepository")

public interface StudentRepository extends CrudRepository<Student_information, Integer>{
	
	public Student_information findByEmail(String email);
	
}
