package com.techlab.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.techlab.business.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class URLFilePath implements ISource {
	private Set<Employee> emps;
	private URL url;
	private BufferedReader br;
	private URLConnection urlConnection;

	public URLFilePath(String path) throws Exception {
		this.url = new URL(path);
		urlConnection = url.openConnection();

		br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
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
