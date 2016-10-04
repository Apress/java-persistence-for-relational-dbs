package com.apress.javapersist.chapter1.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
	private String firstName;
	private String lastName;
	private long employeeId;

	public Employee( String firstName, String lastName, long employeeId ) {
		this.firstName = firstName;
		this.lastName = lastName;
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
