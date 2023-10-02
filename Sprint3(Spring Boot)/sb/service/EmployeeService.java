package com.employee.sb.service;


import com.employee.sb.entity.Employee;

//abstract method for performing CRUD on Employee entity
public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	
	Employee getEmployeeDetail(int emp_id);
	
	Employee updateEmployeeDetail(Employee book, int emp_id);
	
	void deleteEmployeeDetail(int emp_id);

}
