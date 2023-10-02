package com.employee.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee.sb.entity.Employee;
import com.employee.sb.service.EmployeeService;

import jakarta.validation.Valid;

//handle all incoming request of Employee Entity
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
		return new ResponseEntity<Employee>(es.addEmployee(employee),
				HttpStatus.CREATED);
	}
	
	@GetMapping("/getEmployee/{emp_id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("emp_id") int emp_id){
		return new ResponseEntity<Employee>(es.getEmployeeDetail(emp_id),HttpStatus.OK);
	}
	
	@PutMapping("/editEmployee/{emp_id}")
	public ResponseEntity<Employee> editEmployee(@Valid @PathVariable("emp_id") int emp_id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(es.updateEmployeeDetail(employee, emp_id), HttpStatus.OK);
	}
	
	@DeleteMapping("/removeEmployee/{emp_id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("emp_id") int emp_id){
		es.deleteEmployeeDetail(emp_id);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}

}
