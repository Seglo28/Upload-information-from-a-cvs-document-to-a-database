package com.practice.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entities.Student_information;

import jakarta.transaction.Transactional;

@Repository("studentrepository")

public interface StudentRepository extends JpaRepository<Student_information, Long> {

	@Transactional
    <S extends Student_information> List<S> saveAll(Iterable<S> entities);
}
