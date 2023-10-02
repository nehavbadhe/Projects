package com.employee.sb.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="ManInfo")
@NoArgsConstructor
@AllArgsConstructor
public class Dpt_Manager {
	
	@Id
	private int man_id;
	
	@Column(length=20)
	@NotBlank(message = "Department Manager Name cannot be blank")
	private String man_name;
	
	@Column(length=20)
	@NotNull(message = "Department Manager Salary cannot be blank")
	private int man_sal;
	
	@OneToOne(mappedBy = "dpt_manager",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Department department;

}
