package com.apress.javapersist.chapter08.ejbs.employee;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;

import com.apress.javapersist.chapter08.ejbs.address.AddressLocal;

/**
 * Bean implementation class for Enterprise Bean: Employee
 */
public abstract class EmployeeBean implements EntityBean {
	private EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public Long ejbCreate(Long id)
		throws CreateException {
		setId(id);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(Long id)
		throws CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	
	/**
	 * Get accessor for persistent attribute: id
	 */
	public abstract Long getId();
	/**
	 * Set accessor for persistent attribute: id
	 */
	public abstract void setId(Long newId);
	/**
	 * Get accessor for persistent attribute: firstName
	 */
	public abstract String getFirstName();
	/**
	 * Set accessor for persistent attribute: firstName
	 */
	public abstract void setFirstName(String newFirstName);
	/**
	 * Get accessor for persistent attribute: lastName
	 */
	public abstract String getLastName();
	/**
	 * Set accessor for persistent attribute: lastName
	 */
	public abstract void setLastName(String newLastName);
	/**
	 * This method was generated for supporting the relationship role named address.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract AddressLocal getAddress();
	/**
	 * This method was generated for supporting the relationship role named address.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setAddress(AddressLocal anAddress);
	/**
	 * Get accessor for persistent attribute: email
	 */
	public abstract String getEmail();
	/**
	 * Set accessor for persistent attribute: email
	 */
	public abstract void setEmail(String newEmail);
}
