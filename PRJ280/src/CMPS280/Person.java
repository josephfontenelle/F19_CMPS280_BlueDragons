package CMPS280;

abstract public class Person {
	String name;
	protected String jobDescription;
	protected double payRate;

	Person(){
	}
	
	//overloading constructor
	Person(String name, String jobDescription) {
		this.name = name;
		this.jobDescription = jobDescription;
	}

	// getters and setters for name and job description for all
	public String getname() {
		return name;
	}

	public String getjobDescription() {
		return jobDescription;
	}
	
	abstract protected void getpayRate(); 
	
	public void setName(String name) {
		this.name = name;
	}

	public void setjobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	public void setpayRate(double payRate) {
		this.payRate = payRate;
	}
	
	

}