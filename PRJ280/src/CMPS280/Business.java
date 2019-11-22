package CMPS280;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;

public class Business {
	public static void main(String[] args) throws IOException {
		// Print Business Name
		System.out.println("St.Ann Wine Bar" + "\n");
		// Import Scanner
		Scanner input = new Scanner(System.in);
		// utilize scanner to enter employee information
		FileWriter EmployeeFile = new FileWriter("C:/Users/fonte/eclipse-workspace/PRJ280/INPUT/EmployeeInput.txt");
		String EmployeeFolderTesting = "Employees : \n";
		EmployeeFile.write(EmployeeFolderTesting);

		List<Employee> employees = new ArrayList<Employee>();
		// create a do while loop so the user can enter multiple employees
		String condition = "Continue";
		do {
			System.out.println("Must enter Employee First and Last Name:");
			String name = input.next() + " " + input.next();
			EmployeeFile.write("Employee Name is: " + name + "\n");
			System.out.println("Enter one word Employee Job Description:");
			String jobDescription = input.next();
			EmployeeFile.write("Job Description is: " + jobDescription + "\n");
			System.out.println("Enter Employee Sales:");
			double sales = input.nextDouble();
			EmployeeFile.write("Sales are: " + sales + "\n");
			System.out.println("Enter Employee hours worked:");
			double hoursWorked = input.nextDouble();
			EmployeeFile.write("Hour(s) Worked: " + hoursWorked + "\n");
			System.out.println("Enter Employee tips:");
			double tips = input.nextDouble();
			
			EmployeeFile.write("Tips: " + tips + "\n");
			EmployeeFile.write(" \n");
			
			// add employee to array list
			employees.add(new Employee(name, jobDescription, sales, hoursWorked, tips));
			// call condition for entering more employees or not
			System.out.println("Enter add to add another Employee if not enter Done");
			condition = input.next();

		} while (condition.equals("add"));

		EmployeeFile.close();
		FileWriter EmployerFile = new FileWriter("C:/Users/fonte/eclipse-workspace/PRJ280/INPUT/EmployerInput.txt");
		String EmployerFileTesting = "Employers :";
		EmployerFile.write(EmployerFileTesting);
		// create array list of employers
		List<Employer> employers = new ArrayList<Employer>();
		// create a do while loop so the user can enter multiple employers

		do {
			System.out.println("Must enter Employer First and Last Name:");
			String name = input.next() + " " + input.next();
			EmployerFile.write("Employer name is: " + name + "\n");
			System.out.println("Enter one word Employer Job Description:");
			String jobDescription = input.next()+"\n";
			EmployerFile.write("Job Description" + jobDescription + "\n");
			EmployerFile.write(" \n");
			// add employers to array list
			employers.add(new Employer(name, jobDescription));
			// call condition
			System.out.println("Enter add to add another Employers if not enter Done");
			condition = input.next();

		} while (condition.contains("add"));
		EmployerFile.close();
		// for loop to print all employees with employees information
		for (int i = 0; i < employees.size(); i++) {
			System.out.println("Employee name is: " + employees.get(i).getname());
			System.out.println("Job Description: " + employees.get(i).getjobDescription());
			System.out.println("Tips amount: " + employees.get(i).gettips());
			System.out.println("Payout is: $" + employees.get(i).getpayOut());
			System.out.println("Sales are: $" + employees.get(i).getsales());
			System.out.println("Hours worked are: " + employees.get(i).gethoursWorked());
			System.out.println("Profit is: $" + employees.get(i).getprofit());
			employees.get(i).getpayRate();
			employees.get(i).isCostumerHappy();
			employees.get(i).dailySalesGoal();

		}
		// for loop to print all employer name and job descriptions
		for (int i = 0; i < employers.size(); i++) {
			System.out.println("Employers are: " + employers.get(i).getname() + "-" + employers.get(i).getjobDescription());
			employers.get(i).getpayRate();
		}
		// printing number of employers-method in employer class

		System.out.println("Total Number of Employers:" + " " + Employer.gettotalNumEmployers());
		//printing total from all employees- method found in employer class
		employers.get(0).printTotalData(employees);

	}
}