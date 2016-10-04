package com.apress.javapersist.chapter08.ejbs.employee;

import java.rmi.NoSuchObjectException;
import javax.ejb.FinderException;
import javax.ejb.NoSuchObjectLocalException;
import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.rmi.PortableRemoteObject;

import org.apache.cactus.ServletTestCase;

import com.apress.javapersist.chapter08.ejbs.address.*;


import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author rsperko
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class EmployeeBeanTest extends ServletTestCase {
	public static final Long KEY = new Long(5);
	public static final String FIRST_NAME = "Damon";
	public static final String LAST_NAME = "Payne";
	public static final String EMAIL = "dpayne@mybusiness.com";
	public static final Long ADDRESS_KEY = KEY;
	
	private EmployeeLocalHome employeeHome;

	/**
	 * Constructor for EmployeeLocalBeanTest.
	 * @param arg0
	 */
	public EmployeeBeanTest(String arg0) {
		super(arg0);
	}

	/**
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
        if (employeeHome == null) {
            Context initial = new InitialContext();
            Object objref = initial.lookup("java:comp/env/ejb/Employee");
            employeeHome
                = (EmployeeLocalHome) PortableRemoteObject.narrow(objref,
                    EmployeeLocalHome.class);
        }
	}

	public static void setTestDataOn(EmployeeLocal employee) {
		employee.setFirstName(FIRST_NAME);
		employee.setLastName(LAST_NAME);
		employee.setEmail(EMAIL);
	}
	
	public void testCreateEmployee() throws Exception {
		EmployeeLocal employee = employeeHome.create(KEY);
		setTestDataOn(employee);
		
		employee = employeeHome.findByPrimaryKey(KEY);
		assertNotNull(employee);
		assertEquals(FIRST_NAME, employee.getFirstName());
		assertEquals(LAST_NAME, employee.getLastName());
		assertEquals(EMAIL, employee.getEmail());
		
		employeeHome.remove(employee.getPrimaryKey());

		try {
			employee = employeeHome.findByPrimaryKey(KEY);
			fail();
		}
		catch(FinderException e) {
			// Good, want this
		}
	}

	public void testModifyEmployee() throws Exception {
		String newEmail= "damon.payne@mybusiness.com";
		
		EmployeeLocal employee = employeeHome.create(KEY);
		setTestDataOn(employee);
		
		employee.setEmail(newEmail);
		
		EmployeeLocal storedEmployeeLocal = employeeHome.findByPrimaryKey(KEY);
		assertEquals(newEmail, storedEmployeeLocal.getEmail());
		
		storedEmployeeLocal.remove();
	}
	
	public void testRemoveEmployee() throws Exception {
		EmployeeLocal employee = employeeHome.create(KEY);
		setTestDataOn(employee);
		
		EmployeeLocal storedEmployeeLocal = employeeHome.findByPrimaryKey(KEY);

		employeeHome.remove(storedEmployeeLocal.getPrimaryKey());
		
		try {
			employee.getLastName();
			fail();
		}
		catch(NoSuchObjectLocalException e) {
			// should have thrown exception.
		}
	}

	public void testRelationship() throws Exception {
		AddressLocalHome addressHome = AddressBeanTest.createAddressHome();
		AddressLocal address = addressHome.create(AddressBeanTest.KEY);
		AddressBeanTest.setTestDataOn(address);
		
		EmployeeLocal employee = employeeHome.create(KEY);
		setTestDataOn(employee);
		
		employee.setAddress(address);
		address.addEmployee(employee);
		
		AddressLocal storedAddress = addressHome.findByPrimaryKey(AddressBeanTest.KEY);
		assertEquals(1, storedAddress.getNumberEmployees());
		
		EmployeeLocal storedEmployee = employeeHome.findByPrimaryKey(KEY);
		assertEquals(storedEmployee.getAddress(), storedAddress);
		
		address.remove();
		employee.remove();
	}
	
	public void testFindByFirstName() throws Exception {
		EmployeeLocal employee = employeeHome.create(KEY);
		setTestDataOn(employee);
		
		try {
			employee = employeeHome.findByLastName("INVALID");
			fail();
		}
		catch(ObjectNotFoundException e) {
			// should have thrown exception.
		}
		
		employee = employeeHome.findByLastName(LAST_NAME);
		assertNotNull(employee);
		assertEquals(FIRST_NAME, employee.getFirstName());
		
		employee.remove();
	}

	public static TestSuite suite() {
		return new TestSuite(EmployeeBeanTest.class);
	}
}
