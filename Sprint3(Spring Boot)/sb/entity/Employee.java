package com.employee.sb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="EmployeeInfo")

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	private int emp_id;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Employee first Name cannot be blank")
	private String emp_fname;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Employee last Name cannot be blank")
	private String emp_lname;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Employee address cannot be blank")
	private String emp_addr;
	
	@Column(length=11, nullable = false, unique=true)
	@NotNull(message = "Phone number cannot be null")
	private long emp_phone;
	
	@Column(length=20, nullable = false, unique = true)
	@NotBlank(message = "Employee Email ID cannot be blank")
	@Email(message="Email id is not proper")
	private String emp_email;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Employee role cannot be blank")
	private String emp_role;
	
	@Column(length=25, nullable = false)
	@NotNull(message = "Employee salary cannot be blank")
	private int emp_sal;
	
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="deptID", referencedColumnName = "dpt_id")
	@JsonBackReference
	private Department department;
}
