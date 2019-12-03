package CMPS280;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class Employer extends Person implements IEmployeePerformance, Comparable<Employer> {
	// create array list of employers
	static List<Employer> employers = new ArrayList<Employer>();

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
//interface methods implementation
	public String dailySalesGoal() {
		if (totalSales >= totalDailySalesGoal) {
			return ("Sales Goal Met" + "\n");
		} else
			return ("Sales Goal Not Met" + "\n");
	}

	public String isCostumerHappy() {
		if (totalTips / totalSales >= .18) {
			return ("Customers are Happy");
		} else
			return ("Customers are not Happy");
	}

	public void addEmployerToList() {
		employers.add(this);
	}
//sort employer alphabetically
	public void sortEmployers() {
		Collections.sort(employers);
	}

	static public int gettotalNumEmployers() {
		return totalNumEmployers;
	}
//abstract method
	@Override
	protected String getpayRate() {
		if (jobDescription.contains("Manager")) {
			return ("Pay Rate is : Salary ");
		} else {
			return ("Pay Rate is : Self-Employed \n");
		}
	}

	// printing totals from all employees' information
	public String printTotalData(List<Employee> employees) {
		return
		( "Total Payout: " + gettotalPayout(employees) + "\n" + 
		 "Total Tips: " + gettotalTips(employees) + "\n" + 
		 "Total Sales are: $" + gettotalSales(employees) + "\n" +
		 "Total Hours worked are: " + gettotalHoursWorked(employees) + "\n" + 
		 "Total Profit: " + gettotalProfit() + "\n" + 
		 isCostumerHappy() + "\n"+ dailySalesGoal());
	}

	@Override
	public int compareTo(Employer e) {
		return this.name.compareTo(e.name);
	
	}
	static protected void getData() throws IOException {
		// scope variables
		String condition = "";
		String name = " ";
		String jobDescription = " ";
		// Declare Employer Input File
		FileWriter EmployerFile = new FileWriter("C:/Users/fonte/eclipse-workspace/PRJ280/INPUT/EmployerInput.txt");
		Scanner employerInput = new Scanner(System.in);// scanner for employer file

		// create a do while loop so the user can enter as many employers as needed
		do {
			try {
				System.out.println("Must enter Employer First and Last Name:");
				name = employerInput.next() + " " + employerInput.next();
				// this iterates through integer array and string name to see if name contains
				// any elements from the array
				char[] interArray = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
				boolean containsNumbers = false;
				for (int count = 0; count < name.length(); count++) {
					for (int count2 = 0; count2 < interArray.length; count2++) {
						if (name.charAt(count) == interArray[count2])
							containsNumbers = true;
					}
				}
				if (containsNumbers) {
					throw new InvalidInputException("Name can not have digits");// if it does this message is thrown to
																				// console
				} else {// writing name into Employee input file if it does not contain digit
					EmployerFile.write(name + "\n");
				}

				System.out.println("Enter one word Employer Job Description:");
				jobDescription = employerInput.next();

				EmployerFile.write(jobDescription);
				// call condition
				System.out.println("Enter add to add another Employers if not enter Done");
				condition = employerInput.next();

			}	catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			}
			// adding employer object to list
			Employer e = new Employer(name, jobDescription);
			e.addEmployerToList();
		} while (condition.contains("add"));// condition to continue do while
		EmployerFile.close();// close Employer File
	
		//sort employer list alphabetically
		Collections.sort(employers);
		
		}
	
	static protected void getOutput(List<Employee> employees) throws IOException{
		FileWriter EmployerOutput = null;
		try {
			EmployerOutput = new FileWriter("C:/Users/fonte/eclipse-workspace/PRJ280/OUTPUT/EmployerOuput.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// for loop to write all employer info to file
		for (int i = 0; i < employers.size(); i++) {
			EmployerOutput.write("Employers are: " + employers.get(i).getname() + "-"
			+ employers.get(i).getjobDescription() + "\n" + employers.get(i).getpayRate());
			EmployerOutput.write(" \n");
		}
		EmployerOutput.append(employers.get(0).printTotalData(employees));
		EmployerOutput.append("Total Number of Employers:" + " " + gettotalNumEmployers());
		EmployerOutput.close();
	}
}