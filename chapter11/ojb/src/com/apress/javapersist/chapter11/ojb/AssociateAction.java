package com.apress.javapersist.chapter11.ojb;

import java.util.Iterator;

import com.apress.javapersist.chapter11.ojb.bo.Address;
import com.apress.javapersist.chapter11.ojb.bo.Employee;

public class AssociateAction extends BaseAction {
    public void execute(String[] args) throws Exception {
    	Finder finder = new Finder();
        if("Employee".equals(args[0])) {
        	String[] empArgs = new String[4];
        	System.arraycopy(args, 0, empArgs, 0, empArgs.length);
        	String[] addArgs = new String[4];
        	System.arraycopy(args, 4, addArgs, 0, addArgs.length);

        	Iterator iter = finder.find(getPersistenceBroker(), empArgs);
        	Employee employee = (Employee) iter.next();
        	
        	iter = finder.find(getPersistenceBroker(), addArgs);
        	Address address = (Address) iter.next();

        	
            System.out.println("About to associate: " + employee + " with " 
                + address);

            // Actually associate the two classes
            employee.setAddress(address);
            address.addResident(employee);
            
            // Update the database
            getPersistenceBroker().beginTransaction();
            getPersistenceBroker().store(employee);
            getPersistenceBroker().store(address);
            getPersistenceBroker().commitTransaction();
        }
    }

    public String exampleString() {
        return "    Manage assoc Employee id equals 0 Address id equals 1";
    }
}
