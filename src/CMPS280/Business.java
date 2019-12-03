package CMPS280;

import java.util.*;
import java.io.*;

public class Business {
	public static void main(String[] args) throws IOException {
		// Print Business Name
		System.out.println("St.Ann Wine Bar \n");
		Employee employee = new Employee();
		// calling methods
		employee.getData();
		Employer.getData();
		employee.getOutput();
		Employer.getOutput(employee.employees);

	}

}