package com.techlab.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.techlab.business.Employee;
import com.techlab.data.ISource;


public class GroupByDeptNo implements IDoOperations {
	private ISource file;
	private Set<Employee> emps;

	public GroupByDeptNo(ISource file) throws Exception {
		this.file = file;
		emps = file.getEmployees();
	}

	@Override
	public String doOperation() {
		Map<Integer,Integer> deptNo = new HashMap<Integer,Integer>();
		int  tempDeptNo;
        StringBuilder str = new StringBuilder();
		
		for(Employee emp : emps) {
			tempDeptNo = emp.getDeptNo();
			
			if(deptNo.containsKey(tempDeptNo)) {
				deptNo.put(tempDeptNo, (deptNo.get(tempDeptNo)+1));
			}
			else {
				deptNo.put(tempDeptNo, 1);
			}		
		}
		
        for (Entry<Integer, Integer> entry : deptNo.entrySet()) {
        	str.append("No of employee in department "+entry.getKey()+" = "+entry.getValue());
        	str.append("\n");
        }
		
		return str.toString();
	}
}
