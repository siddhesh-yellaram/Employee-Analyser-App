package com.techlab.presentation;

import com.techlab.data.*;
import com.techlab.service.*;
import java.util.*;

public class EmployeeAnalyserTest {

	public static void main(String[] args)throws Exception {
		String filePath = "src/file/EmpData.txt";
		String urlPath = "https://swabhav-tech.firebaseapp.com/emp.txt";
		
		int choice;
		ISource file = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("1.Read From CSV File");
		System.out.println("2.Read From URL");
		System.out.println("Enter your choice: ");
		choice = sc.nextInt();
	
		if(choice == 1) {
			file = new CSVFilePath(filePath);
			file.getEmployees();
		}
		else if(choice == 2) {
			file = new URLFilePath(urlPath);
			file.getEmployees();
		}
		
		executeOperations(new MaxSalaryFinder(file));
		executeOperations(new GroupByDeptNo(file));
		executeOperations(new GroupByDesignation(file));
		sc.close();
	}
	
	private static void executeOperations(IDoOperations i) {
		System.out.println(i.doOperation());
		System.out.println();
	}
}
