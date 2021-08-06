package com.techlab.data;

import java.util.Set;

import com.techlab.business.*;

public interface ISource {
	public Set<Employee> getEmployees() throws Exception;
}
