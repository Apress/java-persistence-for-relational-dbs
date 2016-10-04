package com.apress.javapersist.chapter08.ejbs.address;

import com.apress.javapersist.chapter08.ejbs.employee.EmployeeLocal;

/**
 * Local interface for Enterprise Bean: Address
 */
public interface AddressLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: streetLine1
	 */
	public java.lang.String getStreetLine1();
	/**
	 * Set accessor for persistent attribute: streetLine1
	 */
	public void setStreetLine1(java.lang.String newStreetLine1);
	/**
	 * Get accessor for persistent attribute: city
	 */
	public java.lang.String getCity();
	/**
	 * Set accessor for persistent attribute: city
	 */
	public void setCity(java.lang.String newCity);
	/**
	 * Get accessor for persistent attribute: state
	 */
	public java.lang.String getState();
	/**
	 * Set accessor for persistent attribute: state
	 */
	public void setState(java.lang.String newState);
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getEmployee();
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setEmployee(java.util.Collection anEmployee);
	/**
	 * Get accessor for persistent attribute: streetLine2
	 */
	public java.lang.String getStreetLine2();
	/**
	 * Set accessor for persistent attribute: streetLine2
	 */
	public void setStreetLine2(java.lang.String newStreetLine2);
	
	public void addEmployee(EmployeeLocal employee);

	public int getNumberEmployees();
}
