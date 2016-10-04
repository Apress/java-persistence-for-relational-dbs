package com.apress.javapersist.chapter12.cocobase;

import thought.CocoBase.CBFacade;

import com.apress.javapersist.chapter12.cocobase.bo.Address;
import com.apress.javapersist.chapter12.cocobase.bo.Employee;

public class AddAction extends BaseAction {
    public void execute(String[] args) throws Exception {
        Object obj = buildObject(args);
        System.out.println(obj);
        CBFacade cbFacade = getCBFacade();
        
        cbFacade.beginTransaction();
        // Mark the object as persistent
        cbFacade.insert(obj);
        System.out.println("Object stored: " + obj);
        cbFacade.commit();
    }

    private static Object buildObject(String[] args) {
    	String className = args[0];
        Object obj = null;
        if("Employee".equals(className)) {
            Employee emp = new Employee();
            emp.setId(new Long(args[1]));
            emp.setFirstName(args[2]);
            emp.setLastName(args[3]);
            emp.setEmail(args[4]);
            obj = emp;
        }
        else if("Address".equals(className)){
            Address add = new Address();
            add.setId(new Long(args[1]));
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
