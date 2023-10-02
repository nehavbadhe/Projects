package com.employee.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.sb.entity.Department;
import com.employee.sb.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService ds;
	
	@PostMapping("/addDepartment")
	public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department){
		return new ResponseEntity<Department>(ds.addDepartment(department),
				HttpStatus.CREATED);
	}
	
	@GetMapping("/getDepartment/{dpt_id}")
	public ResponseEntity<Department> getDepartment(@PathVariable("dpt_id") int dpt_id){
		return new ResponseEntity<Department>(ds.getDepartmentDetail(dpt_id),HttpStatus.OK);
	}
	
	@PutMapping("/editDepartment/{dpt_id}")
	public ResponseEntity<Department> editDepartment(@Valid @PathVariable("dpt_id") int dpt_id, @RequestBody Department department){
		return new ResponseEntity<Department>(ds.updateDepartmentDetail(department, dpt_id), HttpStatus.OK);
	}
	
	@GetMapping("/getDepartment")
	public List<Department> getDept(){
		return ds.getAllDepartment();
	}

}
