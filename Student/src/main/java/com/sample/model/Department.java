package com.sample.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Department")
public class Department {

	private int dept_id;
	private String dept_name;
	private String dept_location;
	private Set<Employee> employeeId = new HashSet<Employee>();
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	
	@Column
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	@Column
	public String getDept_location() {
		return dept_location;
	}
	public void setDept_location(String dept_location) {
		this.dept_location = dept_location;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Emp_Dept", joinColumns = { @JoinColumn(name = "emp_id")}, inverseJoinColumns = { @JoinColumn(name = "dept_id")})
	public Set<Employee> getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Set<Employee> employeeId) {
		this.employeeId = employeeId;
	}
}
