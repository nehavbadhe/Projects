package com.employee.sb.service;

import com.employee.sb.entity.Dpt_Manager;

public interface Dpt_ManagerService {
	
	Dpt_Manager addDpt_Manager(Dpt_Manager dpt_manager);
	
	Dpt_Manager getDpt_ManagerDetail(int man_id);
	
	Dpt_Manager updateDpt_ManagerDetail(Dpt_Manager dpt_manager, int man_id);
	
	void deleteDpt_ManagerDetail(int man_id);

}
