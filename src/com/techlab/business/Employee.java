package com.techlab.business;

public class Employee {
	private int empId;
	private String empName;
	private String designation;
	private String managerId;
	private String doj;
	private int salary;
	private String comission;
	private int deptNo;

	public Employee(String empId, String empName, String designation, String managerId, String doj, String salary,
			String comission, String deptNo) {
		this.empId = Integer.parseInt(empId);
		this.empName = empName;
		this.designation = designation;
		this.managerId = managerId;
		this.doj = doj;
		this.salary = Integer.parseInt(salary);
		this.comission = comission;
		this.deptNo = Integer.parseInt(deptNo);
	}

	@Override
	public String toString() {
		return "Emp Id:" + empId + ", Name:" + empName + ", Designation:" + designation + ", Manager Id:" + managerId
				+ ", DOJ:" + doj + ", Salary:" + salary + ", Comission:" + comission + ", Dept No:" + deptNo;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getDesignation() {
		return designation;
	}

	public String getManagerId() {
		return managerId;
	}

	public String getDoj() {
		return doj;
	}

	public int getSalary() {
		return salary;
	}

	public String getComission() {
		return comission;
	}

	public int getDeptNo() {
		return deptNo;
	}

	@Override
	public int hashCode() {
		return this.empId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		return true;
	}
}
