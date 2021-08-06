package com.techlab.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.techlab.business.Employee;
import com.techlab.data.ISource;

public class GroupByDesignation implements IDoOperations {
	private ISource file;
	private Set<Employee> emps;

	public GroupByDesignation(ISource file) throws Exception {
		this.file = file;
		emps = file.getEmployees();
	}

	@Override
	public String doOperation() {
		Map<String,Integer> designationCount = new HashMap<String,Integer>();
		String  designation;
        StringBuilder str = new StringBuilder();
		
		for(Employee emp : emps) {
			designation = emp.getDesignation();
			
			if(designationCount.containsKey(designation)) {
				designationCount.put(designation, (designationCount.get(designation)+1));
			}
			else {
				designationCount.put(designation, 1);
			}		
		}
		
        for (Entry<String, Integer> entry : designationCount.entrySet()) {
        	str.append("No of "+entry.getKey()+" = "+entry.getValue());
        	str.append("\n");
        }
		
		return str.toString();
	}
}
