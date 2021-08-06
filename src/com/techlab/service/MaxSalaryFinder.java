package com.techlab.service;

import java.util.Set;

import com.techlab.business.Employee;
import com.techlab.data.ISource;

public class MaxSalaryFinder implements IDoOperations {
	private ISource file;
	private Set<Employee> emps;
	
	public MaxSalaryFinder(ISource file) throws Exception {
		this.file = file;
		emps = file.getEmployees();
	}

	@Override
	public String doOperation() {
		int empMaxSalary = 0;
		String empName = "";
		String empDesignation = "";
        StringBuilder str = new StringBuilder();

		for(Employee emp : emps) {
			if(emp.getSalary()> empMaxSalary) {
				empName = emp.getEmpName();
				empMaxSalary = emp.getSalary();
				empDesignation = emp.getDesignation();
			}
		}
		
		str.append("\nName: "+empName);
		str.append("\nDesignation: "+empDesignation);
		str.append("\nSalary: "+empMaxSalary);
		
		return str.toString();
	}
}
