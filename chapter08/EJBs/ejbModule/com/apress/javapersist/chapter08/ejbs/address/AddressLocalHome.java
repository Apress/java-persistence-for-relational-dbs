package com.apress.javapersist.chapter08.ejbs.address;
/**
 * Local Home interface for Enterprise Bean: Address
 */
public interface AddressLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Address
	 */
	public com.apress.javapersist.chapter08.ejbs.address.AddressLocal create(
		java.lang.Long id)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Address
	 */
	public com
		.apress
		.javapersist
		.chapter08
		.ejbs
		.address
		.AddressLocal findByPrimaryKey(java.lang.Long primaryKey)
		throws javax.ejb.FinderException;
}
