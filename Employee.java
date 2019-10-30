package CMPS280;

import java.util.List;
import java.util.ArrayList;

public class Employee extends Person {
	//initialize variables
	public double hoursWorked;
	private double tips;
	private double payOut;
	private double sales;
	//default constructor
	public Employee() {
		//super extends from person
		super("", "");
		//default variables
		sales = 0;
		hoursWorked = 0;
		tips = 0;

	}
	//overloading constructor
	public Employee(String name, String jobDescription, double sales, double hoursWorked, double tips) {
		super(name, jobDescription);
		this.sales = sales;
		this.hoursWorked = hoursWorked;
		this.tips = tips;

	}

	// method to return tips
	double gettips() {
		return tips;
	}

	// method to return tips
	double gethoursWorked() {
		return hoursWorked;
	}

	// method to return sales
	double getsales() {
		return sales;
	}

	// method for pay out for each employee
	double getpayOut() {
		if (tips / hoursWorked >= 7.25) {
			return 0;
		} else {
			return (7.25 * hoursWorked) - tips;
		}
	}
}
