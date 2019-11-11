package CMPS280;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Business {
	public static void main(String[] args) {
		//Print Buisness name
		System.out.println("St.Ann Wine Bar" + "\n");
		// Import Scanner
		Scanner input = new Scanner(System.in);
		// utilize scanner to enter employee information
		List<Employee> employees = new ArrayList<Employee>();
		// create a do while loop so the user can enter multiple employees
		String condition = "Continue";
		do {
			System.out.println("Enter Employee First and Last Name:");
			String name = input.next() + " " + input.next();
			System.out.println("Enter one word Employee Job Description:");
			String jobDescription = input.next();
			System.out.println("Enter Employee Sales:");
			double sales = input.nextDouble();
			System.out.println("Enter Employee hours worked:");
			double hoursWorked = input.nextDouble();
			System.out.println("Enter Employee tips:");
			double tips = input.nextDouble();
			//add employee to array list
			employees.add(new Employee(name, jobDescription, sales, hoursWorked, tips));
			//call condition for entering more employees or not
			System.out.println("Enter add to add another Employee if not enter Done");
			condition = input.next();

		} while (condition.equals("add"));

		for (int i = 0; i < employees.size(); i++) {

			System.out.println("Employee name is:" + " " + employees.get(i).getname());
			System.out.println("Job Description:" + " " + employees.get(i).getjobDescription());
			System.out.println("Tips amount:" + " " + employees.get(i).gettips());
			System.out.println("Payout is:" + " $" + employees.get(i).getpayOut());
			System.out.println("Sales are:" + " $" + employees.get(i).getsales());
			System.out.println("Hours worked are:" + " " + employees.get(i).gethoursWorked());
			System.out.println("");
		}
		// create array list of employers
		List<Employer> employers = new ArrayList<Employer>();
		// adds new employee to list with state of each employee
		employers.add(new Employer("Jeff", "Manager", 0, 0, 0, 0));

		// create another employee object to array list
		employers.add(new Employer("Vicky", "Owner", 0, 0, 0, 0));
		for (int i = 0; i < employers.size(); i++) {

			System.out.println(
					"Employers are:" + " " + employers.get(i).getname() + " " + employers.get(i).getjobDescription());

		}
		// printing total from all employees
		System.out.println(" ");
		System.out.println("Total Payout:" + " " + employers.get(1).gettotalPayout(employees));
		System.out.println("Total Tips:" + " " + employers.get(1).gettotalTips(employees));
		System.out.println("Total Sales are:" + " $" + employers.get(1).gettotalSales(employees));
		System.out.println("Total Hours worked are:" + " " + employers.get(1).gettotalHoursWorked(employees));
		System.out.println("Total Profit:" + " " + employers.get(1).getProfit());
		System.out.println("");
	}
}
