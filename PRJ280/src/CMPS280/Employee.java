package CMPS280;

import java.util.List;

public class Employee extends Person implements EmployeePerformance {
	// initialize variables
	private double sales;
	public double hoursWorked;
	private double tips;
	private double payOut;
	private double empProfit;
	static int totalNumEmployees=0;

	// default constructor
	public Employee() {
		// super extends from person
		super();
		// default variables
		sales = 0;
		hoursWorked = 0;
		tips = 0;
		totalNumEmployees += 1;

	}

	// overloading constructor
	public Employee(String name, String jobDescription, double sales, double hoursWorked, double tips) {
		super(name, jobDescription);
		this.sales = sales;
		this.hoursWorked = hoursWorked;
		this.tips = tips;
		totalNumEmployees += 1;
	}

	// method for profit
	double getprofit() {
		empProfit = sales - payOut;
		empProfit = Math.round(empProfit * 100.00) / 100.00;
		return empProfit;
	}

	// method to return and set tips
	double gettips() {
		return tips;
	}

	public void settips(double tips) {
		this.tips = tips;
	}

	// method to return and set tips
	double gethoursWorked() {
		return hoursWorked;
	}

	public void sethoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	// method to return and set sales
	double getsales() {
		return sales;
	}

	public void setsales(double sales) {
		this.sales = sales;
	}

	// method for pay out for each employee
	double getpayOut() {
		if (tips / hoursWorked >= 7.25) {
			payOut = 0;
		} 
		else {
			payOut = (7.25 * hoursWorked) - tips;
		}
		payOut = Math.round(payOut * 100.00) / 100.00;
		return payOut;
	}
	//get total number of employees
	static public int gettotalNumEmployees() {
		return totalNumEmployees;
	}	

	@Override
	protected void getpayRate() {
		if (jobDescription.equals("Server")) {
			System.out.println("Pay rate is: " + 2.25 + "\n");
		} else if (jobDescription.equals("Bartender")) {
			System.out.println("Pay rate is: " + 5.00 + "\n");
		}
	}
	public void dailySalesGoal() {
		if (sales >= empDailySalesGoal) {
			System.out.println("Sales Goal Met \n");
		}else
			System.out.println("Sales Goal Not Met \n");
	}
	public void isCostumerHappy() {
		if (tips / sales >= .18) {
			System.out.println("Customer is Happy");
		} else
			System.out.println("Customer is not Happy");
	}
}