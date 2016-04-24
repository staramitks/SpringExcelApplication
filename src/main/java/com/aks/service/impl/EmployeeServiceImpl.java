/**
 * 
 */
package com.aks.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.aks.dto.EmployeeDashboardDTO;
import com.aks.service.EmployeeService;

/**
 * @author shilpisingh
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	/* (non-Javadoc)
	 * @see com.aks.service.EmployeeService#getEmployeeList()
	 */
	@Override
	public List<EmployeeDashboardDTO> getEmployeeList() {
		
		List<EmployeeDashboardDTO> empList= new ArrayList<EmployeeDashboardDTO>();
		EmployeeDashboardDTO employeeDashboardDTO= new EmployeeDashboardDTO();
		employeeDashboardDTO.setStepName("AP Cycle Calculation");
		employeeDashboardDTO.setStepNo("135");
		employeeDashboardDTO.setReferenceDuration(64);
		List<Integer> variableList= new ArrayList<Integer>();
		variableList.add(10);
		variableList.add(20);
		variableList.add(15);
		variableList.add(-5);
		variableList.add(2);
		variableList.add(7);
		
		variableList.add(15);
		variableList.add(9);
		variableList.add(8);
		variableList.add(4);
		employeeDashboardDTO.setDeviationList(variableList);
	
		
		
		EmployeeDashboardDTO employeeDashboardDTO2= new EmployeeDashboardDTO();
		employeeDashboardDTO2.setStepName("AP Cycle USD Conversion");
		employeeDashboardDTO2.setStepNo("189");
		employeeDashboardDTO.setReferenceDuration(164);
		List<Integer> variableList2= new ArrayList<Integer>();
		variableList2.add(44);
		variableList2.add(22);
		variableList2.add(8);
		variableList2.add(7);
		variableList2.add(2);
		variableList2.add(1);
		
		variableList2.add(15);
		variableList2.add(9);
		variableList2.add(8);
		variableList2.add(4);
		employeeDashboardDTO2.setDeviationList(variableList);
	
		
		
		empList.add(employeeDashboardDTO);
		empList.add(employeeDashboardDTO2);
		
		return empList;
	}

	

	
	
	
	
	
}
