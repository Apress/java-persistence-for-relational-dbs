package com.apress.javapersist.chapter08.ejbs.employee;
/**
 * Local interface for Enterprise Bean: Employee
 */
public interface EmployeeLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: firstName
	 */
	public java.lang.String getFirstName();
	/**
	 * Set accessor for persistent attribute: firstName
	 */
	public void setFirstName(java.lang.String newFirstName);
	/**
	 * Get accessor for persistent attribute: lastName
	 */
	public java.lang.String getLastName();
	/**
	 * Set accessor for persistent attribute: lastName
	 */
	public void setLastName(java.lang.String newLastName);
	/**
	 * This method was generated for supporting the relationship role named address.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com
		.apress
		.javapersist
		.chapter08
		.ejbs
		.address
		.AddressLocal getAddress();
	/**
	 * This method was generated for supporting the relationship role named address.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setAddress(
		com.apress.javapersist.chapter08.ejbs.address.AddressLocal anAddress);
	/**
	 * Get accessor for persistent attribute: email
	 */
	public java.lang.String getEmail();
	/**
	 * Set accessor for persistent attribute: email
	 */
	public void setEmail(java.lang.String newEmail);
}
