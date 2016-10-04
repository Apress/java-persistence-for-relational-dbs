package com.apress.javapersist.chapter08.ejbs.address;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;

import com.apress.javapersist.chapter08.ejbs.employee.EmployeeLocal;

/**
 * Bean implementation class for Enterprise Bean: Address
 */
public abstract class AddressBean implements EntityBean {
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
	 * Get accessor for persistent attribute: streetLine1
	 */
	public abstract String getStreetLine1();
	/**
	 * Set accessor for persistent attribute: streetLine1
	 */
	public abstract void setStreetLine1(String newStreetLine1);
	/**
	 * Get accessor for persistent attribute: city
	 */
	public abstract String getCity();
	/**
	 * Set accessor for persistent attribute: city
	 */
	public abstract void setCity(String newCity);
	/**
	 * Get accessor for persistent attribute: state
	 */
	public abstract String getState();
	/**
	 * Set accessor for persistent attribute: state
	 */
	public abstract void setState(String newState);
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract Collection getEmployee();
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setEmployee(Collection anEmployee);
	/**
	 * Get accessor for persistent attribute: streetLine2
	 */
	public abstract String getStreetLine2();
	/**
	 * Set accessor for persistent attribute: streetLine2
	 */
	public abstract void setStreetLine2(String newStreetLine2);
	
	public void addEmployee(EmployeeLocal employee) {
		getEmployee().add(employee);
	}
	
	public int getNumberEmployees() {
		return getEmployee().size();
	}
}
