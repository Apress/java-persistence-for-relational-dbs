package com.apress.javapersist.chapter08.ejbs.employee;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

/**
 * Local Home interface for Enterprise Bean: Employee
 */
public interface EmployeeLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Employee
	 */
	public EmployeeLocal create(Long id)
		throws CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Employee
	 */
	public EmployeeLocal findByPrimaryKey(Long primaryKey)
		throws FinderException;
		
	public com
		.apress
		.javapersist
		.chapter08
		.ejbs
		.employee
		.EmployeeLocal findByLastName(java.lang.String lastName)
		throws FinderException;
}
