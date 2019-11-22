package CMPS280;

import java.util.List;

public class Employer extends Person implements EmployeePerformance {

	private double totalHoursWorked;
	private double totalPayOut;
	private double totalSales;
	private double profit;
	private double totalTips;
	static int totalNumEmployers = 0;

	// default constructor
	public Employer() {
		// super extends from person
		super();
		totalNumEmployers += 1;
	}

	// overloading constructor
	public Employer(String name, String jobDescription) {
		super(name, jobDescription);
		totalNumEmployers += 1;
	}

	// method for profit
	double gettotalProfit() {
		profit = totalSales - totalPayOut;
		return profit;
	}

	// method for pay out for all employees
	double gettotalPayout(List<Employee> employees) {
		for (int i = 0; i < employees.size(); i++) {
			totalPayOut += employees.get(i).getpayOut();
		}
		return totalPayOut;
	}

	// method to add tips for all employees
	double gettotalTips(List<Employee> employees) {
		for (int i = 0; i < employees.size(); i++) {
			totalTips += employees.get(i).gettips();
		}
		return totalTips;
	}

	// method for total hours worked for all employees
	double gettotalHoursWorked(List<Employee> employees) {
		for (int i = 0; i < employees.size(); i++) {
			totalHoursWorked += employees.get(i).gethoursWorked();
		}
		return totalHoursWorked;
	}

	// method for total sales for all employees
	double gettotalSales(List<Employee> employees) {
		for (int i = 0; i < employees.size(); i++) {
			totalSales += employees.get(i).getsales();
		}
		return totalSales;
	}

	public void dailySalesGoal() {
		if (totalSales >= totalDailySalesGoal) {
			System.out.println("Sales Goal Met" + "\n");
		} else
			System.out.println("Sales Goal Not Met" + "\n");
	}

	public void isCostumerHappy() {
		if (totalTips / totalSales >= .18) {
			System.out.println("Customers are Happy");
		} else
			System.out.println("Customers are not Happy");
	}

	public static int gettotalNumEmployers() {
		return totalNumEmployers;
	}

	@Override
	protected void getpayRate() {
		if (jobDescription.contains("Manager")) {
			System.out.println("Pay Rate is : Salary ");
		} else if (jobDescription.contains("Owner")) {
			System.out.println("Pay Rate is : Self-Employed \n");
		}
	}

	// printing totals from all employees' information
	public void printTotalData(List<Employee> employees) {
		System.out.println("Total Number of Employees: " + Employee.gettotalNumEmployees() + "\n");
		System.out.println("Total Payout: " + gettotalPayout(employees));
		System.out.println("Total Tips: " + gettotalTips(employees));
		System.out.println("Total Sales are: $" + gettotalSales(employees));
		System.out.println("Total Hours worked are: " + gettotalHoursWorked(employees));
		System.out.println("Total Profit: " + gettotalProfit());
		isCostumerHappy();
		dailySalesGoal();
	}
}