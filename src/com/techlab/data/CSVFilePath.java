package com.techlab.data;

import java.util.*;
import java.io.*;
import com.techlab.business.*;

public class CSVFilePath implements ISource {
	private Set<Employee> emps;
	private FileReader fr;
	private BufferedReader br;

	public CSVFilePath(String path) throws FileNotFoundException {
		this.fr = new FileReader(path);
		br = new BufferedReader(this.fr);
		emps = new HashSet<Employee>();
	}

	@Override
	public Set<Employee> getEmployees() throws Exception {
		String line = "";
		String splitBy = ",";

		while ((line = br.readLine()) != null) {
			String[] emp = line.split(splitBy);
			emps.add(new Employee(emp[0], emp[1], emp[2], emp[3], emp[4], emp[5], emp[6], emp[7]));
		}
		return emps;
	}
}
