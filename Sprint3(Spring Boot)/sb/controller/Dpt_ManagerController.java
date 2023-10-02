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

import com.employee.sb.entity.Dpt_Manager;
import com.employee.sb.service.Dpt_ManagerService;

import jakarta.validation.Valid;

@RestController
public class Dpt_ManagerController {
	
	@Autowired
	Dpt_ManagerService dms;
	
	@PostMapping("/addDpt_Manager")
	public ResponseEntity<Dpt_Manager> saveDpt_Manager(@Valid @RequestBody Dpt_Manager dpt_manager){
		return new ResponseEntity<Dpt_Manager>(dms.addDpt_Manager(dpt_manager),
				HttpStatus.CREATED);
	}
	
	@GetMapping("/getDpt_Manager/{man_id}")
	public ResponseEntity<Dpt_Manager> getDpt_Manager(@PathVariable("man_id") int man_id){
		return new ResponseEntity<Dpt_Manager>(dms.getDpt_ManagerDetail(man_id),HttpStatus.OK);
	}
	
	@PutMapping("/editDpt_Manager/{man_id}")
	public ResponseEntity<Dpt_Manager> editDpt_Manager(@Valid @PathVariable("man_id") int man_id, @RequestBody Dpt_Manager dpt_manager){
		return new ResponseEntity<Dpt_Manager>(dms.updateDpt_ManagerDetail(dpt_manager, man_id), HttpStatus.OK);
	}
	
	@DeleteMapping("/removeDpt_Manager/{man_id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("man_id") int man_id){
		dms.deleteDpt_ManagerDetail(man_id);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}

}
