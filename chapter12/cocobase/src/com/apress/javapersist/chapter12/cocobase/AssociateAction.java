package com.apress.javapersist.chapter12.cocobase;


import java.util.Iterator;
import java.util.Vector;

import thought.CocoBase.CBFacade;

import com.apress.javapersist.chapter12.cocobase.bo.Address;
import com.apress.javapersist.chapter12.cocobase.bo.Employee;

public class AssociateAction extends BaseAction {
    public void execute(String[] args) throws Exception {
    	CBFacade cbFacade = getCBFacade();
        if("Employee".equals(args[0])) {
			String employeeQuery = args[1];
			String addressQuery = args[3];

        	Employee employee = findEmployee(cbFacade, employeeQuery);
        	Address address = findAddress(cbFacade, addressQuery);
        	
            System.out.println("About to associate: " + employee + " with " 
                + address);
            
            cbFacade.beginTransaction();
                
            // Actually associate the two classes
            employee.setAddress(address);
            address.addResident(employee);
            
            cbFacade.save(employee, BaseAction.EMPLOYEE_MAP);
            cbFacade.save(address, BaseAction.ADDRESS_MAP);
            
            // Update the database
            cbFacade.commit();
        }
    }
    
    private Employee findEmployee(CBFacade cbFacade, String employeeQuery) throws Exception {
    	Iterator iter = findAll(cbFacade, employeeQuery, new Vector());
    	Employee employee = (Employee) iter.next();
    	
    	return employee;
    }
    
    private Address findAddress(CBFacade cbFacade, String addressQuery) throws Exception {
    	Iterator iter = findAll(cbFacade, addressQuery, new Vector());
    	Address address = (Address) iter.next();
    	
    	return address;
    }

    public String exampleString() {
        return "    Manage assoc Employee \"select object(e) from Employee e where e.id='101'\" Address \"select object(a) from Address a where a.id ='1'\"";
    }
}
