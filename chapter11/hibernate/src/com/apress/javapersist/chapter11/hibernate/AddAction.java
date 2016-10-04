package com.apress.javapersist.chapter11.hibernate;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.apress.javapersist.chapter11.hibernate.bo.Address;
import com.apress.javapersist.chapter11.hibernate.bo.Employee;

public class AddAction extends BaseAction {
    public void execute(String[] args) throws Exception {
        Session session = null;
    	try {
	        Object obj = buildObject(args);
	        session = getSession();
	        
	       	Transaction trans = session.beginTransaction();
	        // Mark the object as persistent
	        session.save(obj);
	        System.out.println("Object stored: " + obj);
	        trans.commit();
    	}
    	finally {
    		if(session != null) {
		        session.close();
    		}
    	}
    }

    private static Object buildObject(String[] args) {
    	String className = args[0];
        Object obj = null;
        if("Employee".equals(className)) {
            Employee emp = new Employee(new Long(args[1]));
            emp.setFirstName(args[2]);
            emp.setLastName(args[3]);
            emp.setEmail(args[4]);
            obj = emp;
        }
        else if("Address".equals(className)){
            Address add = new Address(new Long(args[1]));
            add.setStreetLine1(args[2]);
            add.setStreetLine2(args[3]);
            add.setCity(args[4]);
            add.setState(args[5]);
            obj = add;
        }
        return obj;
    }

    public String exampleString() {
        return "    Manage add Employee id FName LName eMail\n"
            + "    Manage add Address id line1 line2 city state";
    }
}
