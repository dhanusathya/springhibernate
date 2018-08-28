/*package com.sample.testDAO;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sample.dao.StudentDAO;
import com.sample.model.Student;

public class DaoMockTest extends BaseDaoMockTest {
	
	@Mock
	StudentDAO studentDAO;
	
	@Mock
	Student student;
	
	@Mock
	Student stud;
	
    @Test
	public void testByAddStudent(){
		
		setUp();
		String msg = "Success";
		when(studentDAO.addNewStudent(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(msg);
		assertEquals("Success",studentDAO.addNewStudent("Vetri", "Vel", "D", "Correspondance"));
	}
	
	@Test
	public void testByAddStudentWithNull(){
		
		String msg = "failed";		
		when(studentDAO.addNewStudent(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(msg);
		assertEquals("failed",studentDAO.addNewStudent("", "Vel", "D", "Correspondance"));
	}
		  
	@Test
	public void testByUpdateStudent(){
		
		String msg = "Success";
		when(studentDAO.update_student(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt())).thenReturn(msg);				
		assertEquals("Success",studentDAO.update_student("Aksay", "Kumar", "D", "Regular",23));
		
	}
	
	
	@Test
	public void testByUpdateStudentWithNull(){
		
		String msg = "failed";
		when(studentDAO.update_student(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt())).thenReturn(msg);				
		assertEquals("failed",studentDAO.update_student("", "", "D", "Regular",23));
		
	}
	
	@Test
	public void testByViewStudent(){
		
		student.setStudentName("Sathis");
		student.setFatherName("Kumar");
		student.setSection("A");
		student.setTypeOfStudent("Regular");
		List<Student> student1 = new ArrayList<Student>();
		student1.add(student);
		stud.setStudentName("Santhosh");
		stud.setFatherName("Subramaniam");
		stud.setSection("A");
		stud.setTypeOfStudent("Regular"); 
		student1.add(stud);
		
		when(studentDAO.view_student(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(student1);		
		assertEquals(2, student1.size());
		
		
	}
	
	@Test
	public void testByDeleteStudent(){
		
		String msg = "Success";
		when(studentDAO.delete_student(Mockito.anyInt())).thenReturn(msg);
		assertEquals("Success",studentDAO.delete_student(19));
		
	}
	
}
*/