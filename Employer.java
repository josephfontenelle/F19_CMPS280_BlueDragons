package CMPS280;

import java.util.Date;
import java.util.List;

public class Employer extends Person {

	
	private double totalHoursWorked;
	private double totalPayOut;
	private double totalSales;
	private double profit;
	private double totalTips;
		//default constructor
	public Employer() {
		//super extends from person
		super("", "");
	}
	
		//overloading constructor
	public Employer(String name, String jobDescription, double totalSales, double totalHoursWorked, double profit,
			double totalTips) {
		super(name, jobDescription);
		this.totalSales = totalSales;
		this.totalHoursWorked = totalHoursWorked;
		this.profit = profit;
		this.totalTips = totalTips;
	}

	// method for profit
	double getProfit() {
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
}
