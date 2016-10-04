package com.apress.javapersist.chapter08.ejbs.address;


/**
 * Remote interface for Enterprise Bean: Address
 */
public interface Address extends javax.ejb.EJBObject {
	/**
	 * Get accessor for persistent attribute: streetLine1
	 */
	public java.lang.String getStreetLine1() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: streetLine1
	 */
	public void setStreetLine1(java.lang.String newStreetLine1)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: city
	 */
	public java.lang.String getCity() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: city
	 */
	public void setCity(java.lang.String newCity)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: state
	 */
	public java.lang.String getState() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: state
	 */
	public void setState(java.lang.String newState)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: streetLine2
	 */
	public java.lang.String getStreetLine2() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: streetLine2
	 */
	public void setStreetLine2(java.lang.String newStreetLine2)
		throws java.rmi.RemoteException;
}
