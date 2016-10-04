package com.apress.javapersist.chapter08.ejbs.employee;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

/**
 * Home interface for Enterprise Bean: Employee
 */
public interface EmployeeHome extends javax.ejb.EJBHome {
	/**
	 * Creates an instance from a key for Entity Bean: Employee
	 */
	public Employee create(Long id)
		throws CreateException, RemoteException;
	/**
	 * Finds an instance using a key for Entity Bean: Employee
	 */
	public Employee findByPrimaryKey(Long primaryKey)
		throws FinderException, RemoteException;
}
