package com.apress.javapersist.chapter12.toplink;


import java.util.Iterator;

import oracle.toplink.publicinterface.UnitOfWork;
import oracle.toplink.sessions.DatabaseSession;

import com.apress.javapersist.chapter12.toplink.bo.Address;
import com.apress.javapersist.chapter12.toplink.bo.Employee;

public class AssociateAction extends BaseAction {
    public void execute(String[] args) throws Exception {
    	DatabaseSession session = getSession();
        if("Employee".equals(args[0])) {
        	Employee employee = findEmployee(session, args);
        	Address address = findAddress(session, args);

        	
            System.out.println("About to associate: " + employee + " with " 
                + address);
                
            UnitOfWork unitOfWork = session.acquireUnitOfWork();

			// Make copies to work with            
            Employee employeeCopy = (Employee) unitOfWork.registerObject(employee);
            Address addressCopy = (Address) unitOfWork.registerObject(address);

            // Actually associate the two classes
            employeeCopy.setAddress(addressCopy);
            addressCopy.addResident(employeeCopy);
            
            // Update the database
            unitOfWork.commit();
        }
    }
    
    private Employee findEmployee(DatabaseSession session, String[] args) throws Exception {
    	Finder finder = new Finder();

    	String[] empArgs = new String[4];
    	System.arraycopy(args, 0, empArgs, 0, empArgs.length);

    	Iterator iter = finder.find(session, empArgs);
    	Employee employee = (Employee) iter.next();
    	
    	return employee;
    }
    
    private Address findAddress(DatabaseSession session, String[] args) throws Exception {
    	Finder finder = new Finder();

    	String[] addArgs = new String[4];
    	System.arraycopy(args, 4, addArgs, 0, addArgs.length);

    	Iterator iter = finder.find(session, addArgs);
    	Address address = (Address) iter.next();
    	
    	return address;
    }

    public String exampleString() {
        return "    Manage assoc Employee id equals 0 Address id equals 1";
    }
}
