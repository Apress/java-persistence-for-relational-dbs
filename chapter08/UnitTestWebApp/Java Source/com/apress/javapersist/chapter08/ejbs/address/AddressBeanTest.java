package com.apress.javapersist.chapter08.ejbs.address;

import java.rmi.NoSuchObjectException;
import javax.ejb.FinderException;
import javax.ejb.NoSuchObjectLocalException;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.rmi.PortableRemoteObject;

import org.apache.cactus.ServletTestCase;


import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * @author rsperko
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class AddressBeanTest extends ServletTestCase {
	public static final Long KEY = new Long(10);
	public static final String STREET_LINE1 = "123 N. West St.";
	public static final String STREET_LINE2 = "Apt. 204";
	public static final String CITY = "Milwaukee";
	public static final String STATE = "WI";
	
	private AddressLocalHome addressHome;

	/**
	 * Constructor for EmployeeBeanTest.
	 * @param arg0
	 */
	public AddressBeanTest(String arg0) {
		super(arg0);
	}

	/**
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
        if (addressHome == null) {
        	addressHome = createAddressHome();
        }
	}

	public static AddressLocalHome createAddressHome() throws Exception {
        Context initial = new InitialContext();
        Object objref = initial.lookup("java:comp/env/ejb/Address");
        return (AddressLocalHome) PortableRemoteObject.narrow(objref,
            AddressLocalHome.class);
	}
	
	public static void setTestDataOn(AddressLocal address) {
		address.setStreetLine1(STREET_LINE1);
		address.setStreetLine2(STREET_LINE2);
		address.setCity(CITY);
		address.setState(STATE);
	}
	
	public void testCreateAddress() throws Exception {
		AddressLocal address = addressHome.create(KEY);
		setTestDataOn(address);
		
		address = addressHome.findByPrimaryKey(KEY);
		assertNotNull(address);
		assertEquals(STREET_LINE1, address.getStreetLine1());
		assertEquals(STREET_LINE2, address.getStreetLine2());
		assertEquals(CITY, address.getCity());
		assertEquals(STATE, address.getState());
		
		addressHome.remove(address.getPrimaryKey());

		try {
			address = addressHome.findByPrimaryKey(KEY);
			fail();
		}
		catch(FinderException e){
		}
	}

	public void testModifyAddress() throws Exception {
		String newStreetLine1 = "345 W. North St.";
		
		AddressLocal address = addressHome.create(KEY);
		setTestDataOn(address);		
		address.setStreetLine1(newStreetLine1);
		
		AddressLocal storedAddress = addressHome.findByPrimaryKey(KEY);
		assertEquals(newStreetLine1, storedAddress.getStreetLine1());
		
		storedAddress.remove();
	}
	
	public void testRemoveAddress() throws Exception {
		AddressLocal address = addressHome.create(KEY);
		setTestDataOn(address);		
		
		AddressLocal storedAddress = addressHome.findByPrimaryKey(KEY);

		addressHome.remove(storedAddress.getPrimaryKey());

		try{		
			address.getStreetLine1();
			fail();
		}
		catch(NoSuchObjectLocalException e) {
			// should have thrown exception.
		}
	}


	public static TestSuite suite() {
		return new TestSuite(AddressBeanTest.class);
	}
	
	public static void main(String[] args) {
		TestRunner.run(AddressBeanTest.class);
	}
}
