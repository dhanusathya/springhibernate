package com.sample.dao;

import java.util.List;

import com.sample.model.Employee;
import com.sample.model.Student;


public class StudentDAOImpl extends BaseDaoImpl implements StudentDAO {
	
	
	public String addNewEmployee(Employee employee) {
		
		String returnVal="failed";
		if(null == employee.getEmp_name() || employee.getEmp_name().isEmpty()){
			return returnVal;
		}
		
		String SQL ="INSERT INTO employee(emp_name,emp_salary,dept_id,address) VALUES(?,?,?,?)";
		int update = getJdbcTemplate().update(SQL, new Object[]{employee});
		if(update >= 1){
        	returnVal="success";
        }
		logger.info("Logs :",StudentDAOImpl.class); 
        System.out.println("MSG : "+returnVal);
        
        return returnVal;
	}

	
	public String update_student(String student_name, String father_name,
			String section, String type_of_student, int studentId) {
		
			 String returnVal="failed";
			 if(null == student_name || student_name.isEmpty() || null == father_name || father_name.isEmpty()){
					return returnVal;
				}
			String SQL = "UPDATE Student SET student_name=?, father_name=?, section=?, type_of_student=? WHERE id=?" ;
			int update = getJdbcTemplate().update(SQL, new Object[]{student_name, father_name, section, type_of_student, studentId});
			if(update >= 1){
	        	returnVal="success";
	        }
	        System.out.println("MSG : "+returnVal);
	        
			return returnVal;

		}

	
	public List<Student> view_student(String student_name, String father_name,
			String section, String type_of_student) {
		
		String SQL="SELECT * FROM student";
		return getJdbcTemplate().query(SQL, new StudentRowMapper());
           
       }

	
	public String delete_student(int studentId) {
		
		String returnVal="failed";
		String SQL = "Delete from student where id=?";
		int update = getJdbcTemplate().update(SQL, new Object[] {studentId});
		if(update>=1){
			returnVal = "Success";
		}
		System.out.println("MSG :" +returnVal);
		return returnVal;

	}


}