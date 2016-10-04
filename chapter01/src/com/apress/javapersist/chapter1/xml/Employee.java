package com.apress.javapersist.chapter1.xml;

public class Employee {
	private String firstName;
	private String lastName;
	private long employeeId;

	public Employee(){
  }
  
  public void setFirstName( String firstName ) {
		this.firstName = firstName;
  }
  public void setLastName( String lastName ) {
		this.lastName = lastName;
  }
  public void setEmployeeId( long employeeId ) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public long getEmployeeId() {
		return employeeId;
	}

    private int numDependants;
    public void setNumDependants( int numDependants ) {
        this.numDependants = numDependants;
    }
    
    public int getNumDependants() {
        return numDependants;
    }
}
