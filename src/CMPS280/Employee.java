package CMPS280;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class Employee extends Person implements IEmployeePerformance {
	// global variable
	static List<Employee> employees = new ArrayList<Employee>();

	// initialize variables
	private double sales;
	public double hoursWorked;
	private double tips;
	private double payOut;
	private double empProfit;
	static int totalNumEmployees = 0;

	// default constructor
	public Employee() {
		// super extends from person
		super();
		// default variables
		sales = 0;
		hoursWorked = 0;
		tips = 0;
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
		} else {
			payOut = (7.25 * hoursWorked) - tips;
		}
		payOut = Math.round(payOut * 100.00) / 100.00;
		return payOut;
	}

	// get total number of employees
	 static public int gettotalNumEmployees() {
		return totalNumEmployees;
	}

	@Override
	// this method searches for job description of each employee to determine pay
	// rate
	protected String getpayRate() {
		if (jobDescription.equals("Server")) {
			return ("Pay rate is: " + "2.25" + "\n");
		} else 
		{
			return ("Pay rate is: " + "5.00" + "\n");
		}
	}
//Implement interface
	public String dailySalesGoal() {
		if (sales >= empDailySalesGoal) {
			return ("Sales Goal Met \n");
		} else
			return ("Sales Goal Not Met \n");
	}

	public String isCostumerHappy() {
		if (tips / sales >= .18) {
			return ("Customer is Happy");
		} else
			return ("Customer is not Happy");
	}

	public void addEmployeeToList() {
		employees.add(this);
	}
	// public void employeejobDsort( ) {
	// if (.contains()
	// }*/

	protected void getData() throws IOException {// method used to get employee info from user
		// scope variables
		double sales = 0;
		double hoursWorked = 0;
		double tips = 0.0;
		String condition = "";
		// Declare Employee Input File
		FileWriter EmployeeFile = new FileWriter("C:/Users/fonte/eclipse-workspace/PRJ280/INPUT/EmployeeInput.txt");
		Scanner employeeInput = new Scanner(System.in);// Declare Scanner
		// create a do while loop so the user can enter as many employees wanted
		do {// enter name and job description for employee and write into EmployeeInput File
			System.out.println("Must enter Employee First and Last Name:");
			String name = employeeInput.next() + " " + employeeInput.next();

			EmployeeFile.write(name + ' ');

			System.out.print("Enter one word Employee Job Description:\n");
			String jobDescription = employeeInput.next();

			EmployeeFile.write(jobDescription + "\n");

			// try catch for employee double input variables for employee objects while
			// utilizing file writer
			try {
				System.out.print("Enter Employee Sales: ");
				sales = employeeInput.nextDouble();

				EmployeeFile.write(sales + ", ");

				System.out.print("Enter Employee Hours Worked: ");
				hoursWorked = employeeInput.nextDouble();

				EmployeeFile.write(hoursWorked + ", ");

				System.out.print("Enter Employee tips: ");
				tips = employeeInput.nextDouble();

				EmployeeFile.write(tips +"");

				EmployeeFile.write(" \n");// formatting

				// call condition for entering more employees or not

				System.out.print("Enter add to add another Employee if not enter Done \n");
				// catch exception and print error message
				condition = employeeInput.next();
			} catch (Exception e) {
				System.out.println(new InvalidInputException().getMessage());// displays input must be double to console
				employeeInput.nextLine();
			}

			Employee e = new Employee(name, jobDescription, sales, hoursWorked, tips);
			e.addEmployeeToList();// adding employee object to list
			
		} while (condition.contains("add".toString()));// condition to continue do while loop
		EmployeeFile.close();// close employee file
			}
		
	
		//get employee object outputs and write to file
	protected void getOutput() throws IOException{
			FileWriter EmployeeOutput = null;
			try {
				EmployeeOutput = new FileWriter("C:/Users/fonte/eclipse-workspace/PRJ280/OUTPUT/EmployeeOuput.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < employees.size(); i++) {
				EmployeeOutput.append("Employee name is: " + employees.get(i).getname()+"\n");
				EmployeeOutput.append("Job Description: " + employees.get(i).getjobDescription()+"\n");
				EmployeeOutput.append("Tips amount: " + employees.get(i).gettips()+"\n");
				EmployeeOutput.append("Payout is: $" + employees.get(i).getpayOut()+"\n");
				EmployeeOutput.append("Sales are: $" + employees.get(i).getsales()+"\n");
				EmployeeOutput.append("Hours worked are: " + employees.get(i).gethoursWorked()+"\n");
				EmployeeOutput.append("Profit is: $" + employees.get(i).getprofit()+"\n");
				// calling abstract methods from interface
				EmployeeOutput.append(employees.get(i).getpayRate()+"\n");
				EmployeeOutput.append(employees.get(i).isCostumerHappy()+"\n");
				EmployeeOutput.append(employees.get(i).dailySalesGoal()+"\n");
				// employees array is found in Employee class
			}
			EmployeeOutput.append("Total Number of Employees: " + gettotalNumEmployees() + "\n");
			EmployeeOutput.close();
		}
}