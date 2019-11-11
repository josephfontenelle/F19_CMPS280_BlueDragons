package CMPS280;

public class Person {
	private String name;
	private String jobDescription;
	//default constructor
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

	public void setName(String name) {
		this.name = name;
	}

	public void setjobDescription(String jobDescription) {
		this.jobDescription = jobDescription;

	}

}
