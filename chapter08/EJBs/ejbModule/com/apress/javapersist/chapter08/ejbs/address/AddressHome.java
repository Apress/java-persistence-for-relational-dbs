package com.apress.javapersist.chapter08.ejbs.address;
/**
 * Home interface for Enterprise Bean: Address
 */
public interface AddressHome extends javax.ejb.EJBHome {
	/**
	 * Creates an instance from a key for Entity Bean: Address
	 */
	public Address create(Long id)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * Finds an instance using a key for Entity Bean: Address
	 */
	public Address findByPrimaryKey(Long primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;

}
