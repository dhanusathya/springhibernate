package com.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = new Student();
		student.setStudentName(rs.getString("student_name"));
		student.setFatherName(rs.getString("father_name"));
		student.setSection(rs.getString("section"));
		student.setTypeOfStudent(rs.getString("type_of_student"));
		student.setId(rs.getInt("id"));
		return student;
}
}
