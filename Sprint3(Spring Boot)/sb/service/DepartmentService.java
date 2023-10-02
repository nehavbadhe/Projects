package com.employee.sb.service;

import java.util.List;

import com.employee.sb.entity.Department;


public interface DepartmentService {
	
	Department addDepartment(Department department);
	
	Department getDepartmentDetail(int dpt_id);
	
	List<Department> getAllDepartment();
		
	Department updateDepartmentDetail(Department department, int dpt_id);

}
