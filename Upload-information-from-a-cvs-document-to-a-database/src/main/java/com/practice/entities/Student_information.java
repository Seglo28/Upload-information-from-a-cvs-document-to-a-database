package com.practice.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "student_information")
public class Student_information {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firts_name = "";
	private String last_name = "";
	private String email = "";
	private String telephone = "";
	
	public Student_information() {
		super();
	}

	public Student_information(int id, String firts_name, String last_name, String email, String telephone) {
		super();
		this.id = id;
		this.firts_name = firts_name;
		this.last_name = last_name;
		this.email = email;
		this.telephone = telephone;
	}
 

	private int getId() {
		return id;
	}


	private void setId(int id) {
		this.id = id;
	}


	public String getFirts_name() {
		return firts_name;
	}


	public void setFirts_name(String firts_name) {
		this.firts_name = firts_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Student_information [id=" + id + ", firts_name=" + firts_name + ", last_name=" + last_name + ", email="
				+ email + ", telephone=" + telephone + "]";
	}
	
	
}
