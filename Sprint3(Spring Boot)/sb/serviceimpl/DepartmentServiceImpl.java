package com.employee.sb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.sb.entity.Department;
import com.employee.sb.exception.DepartmentIdNotFoundException;
import com.employee.sb.repository.DepartmentRepository;
import com.employee.sb.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository drepo;

	@Override
	public Department addDepartment(Department department) {
		
		return drepo.save(department);
	}

	@Override
	public Department getDepartmentDetail(int dpt_id) {
		
		return drepo.findById(dpt_id).
		         orElseThrow(()-> new DepartmentIdNotFoundException("Department Id is not correct"));
	}

	@Override
	public List<Department> getAllDepartment() {
		
		return drepo.findAll();
	}

	@Override
	public Department updateDepartmentDetail(Department department, int dpt_id) {
		
		Department newDept = drepo.findById(dpt_id).orElseThrow(()-> new  DepartmentIdNotFoundException("Incorrect Department id"));
		
		newDept.setNoOfemp(department.getNoOfemp());
		
		drepo.save(newDept);
		return newDept;
	}

	

}
