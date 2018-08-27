package com.sample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Student")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String student_name;
	@Column
	String father_name;
	@Column
	String section;
	@Column
	String type_of_student;
	
	
	
	public String getStudentName() {
		return student_name;
	}
	public void setStudentName(String student_name) {
		this.student_name = student_name;
	}
	public String getFatherName() {
		return father_name;
	}
	public void setFatherName(String father_name) {
		this.father_name = father_name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getTypeOfStudent() {
		return type_of_student;
	}
	public void setTypeOfStudent(String type_of_student) {
		this.type_of_student = type_of_student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
