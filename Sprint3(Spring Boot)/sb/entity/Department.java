package com.employee.sb.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="DepartmentInfo")
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	@Id
	private int dpt_id;
		
	@Column(length=20, nullable = true)
	@NotBlank(message = "Department Name cannot be blank")
	private String dpt_name;
	
	@Column(length=10, nullable = true)
	@NotNull(message = "kindly mention no of employees")
	private int noOfemp;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Location cannot be blank")
	private String Location;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	List<Employee> employeeList;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="manager_id", referencedColumnName = "man_id")
	@JsonBackReference
	private Dpt_Manager dpt_manager;
}
