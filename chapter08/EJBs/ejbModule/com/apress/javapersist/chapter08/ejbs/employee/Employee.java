package com.apress.javapersist.chapter08.ejbs.employee;
/**
 * Remote interface for Enterprise Bean: Employee
 */
public interface Employee extends javax.ejb.EJBObject {
	/**
	 * Get accessor for persistent attribute: firstName
	 */
	public java.lang.String getFirstName() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: firstName
	 */
	public void setFirstName(java.lang.String newFirstName)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: lastName
	 */
	public java.lang.String getLastName() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: lastName
	 */
	public void setLastName(java.lang.String newLastName)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: email
	 */
	public java.lang.String getEmail() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: email
	 */
	public void setEmail(java.lang.String newEmail)
		throws java.rmi.RemoteException;
}
