package com.sample.service;

import java.util.List;

import com.sample.model.Employee;
import com.sample.model.Student;

public interface StudentService {
	
	public String addNewEmployee(Employee employee);

	String update_student(String student_name, String father_name,
			String section, String type_of_student, int studentId);

	List<Student> view_student(String student_name, String father_name,
			String section, String type_of_student);

	String delete_student(int studentId);
}