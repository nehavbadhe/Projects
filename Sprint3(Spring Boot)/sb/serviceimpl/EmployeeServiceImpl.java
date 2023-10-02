package com.employee.sb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.sb.entity.Employee;
import com.employee.sb.exception.EmployeeIdNotFoundException;
import com.employee.sb.repository.EmployeeRepository;
import com.employee.sb.service.EmployeeService;

//business logic(CRUD Implementation) of entity Employee
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository erepo;

	@Override
	public Employee addEmployee(Employee employee) {
		
		return erepo.save(employee);
	}

	@Override
	public Employee getEmployeeDetail(int emp_id) {
		return erepo.findById(emp_id).
		         orElseThrow(()-> new EmployeeIdNotFoundException("Employee Id is not correct"));
	}

	@Override
	public Employee updateEmployeeDetail(Employee employee, int emp_id) {
		Employee updatedEmployee = erepo.findById(emp_id).
		         orElseThrow(()-> new EmployeeIdNotFoundException("Employee Id is not correct"));

		updatedEmployee.setEmp_phone(employee.getEmp_phone());
		updatedEmployee.setEmp_role(employee.getEmp_role());
		
		erepo.save(updatedEmployee); //saving updated details 
			return updatedEmployee; 
		
	}

	@Override
	public void deleteEmployeeDetail(int emp_id) {
		erepo.findById(emp_id).
		orElseThrow(()-> new EmployeeIdNotFoundException("Employee Id is not correct"));
	    erepo.deleteById(emp_id);
		
	}

}
