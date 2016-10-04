/**
 * Created on Jan 31, 2003
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package com.apress.javapersist.chapter11.ojb;

import org.apache.ojb.broker.PersistenceBroker;

import com.apress.javapersist.chapter11.ojb.bo.Address;
import com.apress.javapersist.chapter11.ojb.bo.Employee;

/**
 * @author rsperko
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class AddAction extends BaseAction {

    /** 
     * Add the object
     * @see com.apress.javapersist.chapter10.JDOAction#execute(String, String[])
     */
    public void execute(String[] args) throws Exception {
        Object obj = buildObject(args);
        PersistenceBroker broker = getPersistenceBroker();
        
        broker.beginTransaction();
        // Mark the object as persistent
        broker.store(obj);
        broker.commitTransaction();
        System.out.println("Object stored: " + obj);
    }

    /**
     * Method buildObject.
     * @param className
     * @param optional
     * @return Object
     */
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

    /**
     * @see com.apress.javapersist.chapter10.JDOAction#exampleString()
     */
    public String exampleString() {
        return "    Manage add Employee id FName LName eMail\n"
            + "    Manage add Address id line1 line2 city state";
    }
}
