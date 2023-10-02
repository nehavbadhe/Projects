package com.employee.sb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.sb.entity.Dpt_Manager;
import com.employee.sb.exception.Dpt_ManagerIdNotFoundException;
import com.employee.sb.exception.EmployeeIdNotFoundException;
import com.employee.sb.repository.Dpt_ManagerRepository;
import com.employee.sb.service.Dpt_ManagerService;

@Service
public class Dpt_ManagerServiceImpl implements Dpt_ManagerService{
	
	@Autowired
	Dpt_ManagerRepository dmrepo;

	@Override
	public Dpt_Manager addDpt_Manager(Dpt_Manager dpt_manager) {
		
		return dmrepo.save(dpt_manager);
	}

	@Override
	public Dpt_Manager getDpt_ManagerDetail(int man_id) {
		return dmrepo.findById(man_id).
		         orElseThrow(()-> new Dpt_ManagerIdNotFoundException("Department Id is not correct"));
	}

	@Override
	public Dpt_Manager updateDpt_ManagerDetail(Dpt_Manager dpt_manager, int man_id) {
		Dpt_Manager updatedDpt_Manager = dmrepo.findById(man_id).orElseThrow(()-> new  Dpt_ManagerIdNotFoundException("Incorrect Department id"));
		
		
		updatedDpt_Manager.setMan_name(dpt_manager.getMan_name());
		updatedDpt_Manager.setMan_sal(dpt_manager.getMan_sal());
		
		dmrepo.save(updatedDpt_Manager);
		return updatedDpt_Manager;
	}

	@Override
	public void deleteDpt_ManagerDetail(int man_id) {
		dmrepo.findById(man_id).
		orElseThrow(()-> new EmployeeIdNotFoundException(" Dpt_Manager Id is not correct"));
	    dmrepo.deleteById(man_id);
		
	}

}
