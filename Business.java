package CMPS280;

import java.util.ArrayList;

import java.util.List;

public class Business {
	// Business Name
	static String name = "St. Ann Wine Bar";

	public static void main(String[] args) {
		System.out.println(Business.name);
		System.out.println("");
		// create array list of employees
		List<Employee> employees = new ArrayList<Employee>();
		// adds new employee to list with state of each employee
		employees.add(new Employee("Joe", "server", 40, 40, 20));

		// create another employee object to array list
		employees.add(new Employee("Brandon", "server", 40, 30, 18));
		// for loop to print all objects states
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