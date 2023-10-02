package com.employee.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.sb.entity.Employee;

//Jpa repository for CRUD method
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
