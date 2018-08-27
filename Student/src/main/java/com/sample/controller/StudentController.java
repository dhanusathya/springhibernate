package com.sample.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sample.model.Student;
import com.sample.service.StudentService;



@Controller
@RequestMapping(value="/ctrl")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@RequestMapping(value = "/addStudent")
	public ModelAndView addUser(){
		
		return new ModelAndView("addStudent");
	}
	
	@RequestMapping(value = "/new_student")
	public @ResponseBody String newStudent(@RequestParam String student_name, @RequestParam String father_name, @RequestParam String section, @RequestParam String type_of_student){
		System.out.println("Student Name : "+student_name);
		System.out.println("Father's Name : "+father_name);
		System.out.println("Section : "+section);
		System.out.println("Type of student : "+type_of_student);
		String msg=studentService.addNewStudent(student_name,father_name, section, type_of_student);
		String str=(msg != null && !msg.equals("") && msg.equalsIgnoreCase("success") ? "Student details created successfully":"Failed to create new student details");
		return str;
		}
	
	
	@RequestMapping(value = "/updateStudent")
	public ModelAndView updateStudent(){
		
		return new ModelAndView("updateStudent");
	}
	
	@RequestMapping(value ="/update_student")
    public @ResponseBody String updateStudent(@RequestParam String student_name, @RequestParam String father_name, @RequestParam String section, @RequestParam String type_of_student,  @RequestParam int studentId) throws SQLException{
		String msg=studentService.update_student(student_name,father_name, section, type_of_student, studentId);
		String str=(msg != null && !msg.equals("") && msg.equalsIgnoreCase("success") ? "Student details successfully updated":"Failed to update student details");
		return str;
		}
	
	
	@RequestMapping(value = "/viewStudent")
	public ModelAndView viewStudent(@RequestParam String name){
		System.out.println("name: "+name);
		return new ModelAndView("/viewStudent");
	}
	@RequestMapping(value = "/view_student")
	public @ResponseBody String viewStudent( @RequestParam String student_name, @RequestParam String father_name, @RequestParam String section, @RequestParam String type_of_student) throws SQLException{
		List<Student> list=studentService.view_student(student_name,father_name, section, type_of_student);
		return new Gson().toJson(list); 
	}
	
	@RequestMapping(value = "/delete_student")
	public @ResponseBody String delete_student( @RequestParam int studentId) throws SQLException{
		System.out.println("studentId : "+studentId);
		String msg=studentService.delete_student(studentId);
		String str=(msg != null && !msg.equals("") && msg.equalsIgnoreCase("success") ? "Student details successfully deleted":"Failed to delete student details");
		return str;
	}
	
}
/*
@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService service;
	
	@RequestMapping(value="/sayHello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(@PathVariable String name) {
     return service.sayHello();
    }	
}
*/