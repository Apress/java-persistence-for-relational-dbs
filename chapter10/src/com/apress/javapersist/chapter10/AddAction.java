/**
 * Created on Jan 31, 2003
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package com.apress.javapersist.chapter10;

import javax.jdo.PersistenceManager;

import com.apress.javapersist.chapter10.bo.Address;
import com.apress.javapersist.chapter10.bo.Employee;

/**
 * @author rsperko
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class AddAction extends JDOAction {

    /** 
     * Add the object
     * @see com.apress.javapersist.chapter10.JDOAction#execute(String, String[])
     */
    public void execute(String typeName, String[] optional) {
        Object obj = buildObject(typeName, optional);
        PersistenceManager pm = getPersistenceManager();
        
        pm.currentTransaction().begin();
        // Mark the object as persistent
        pm.makePersistent(obj);
        pm.currentTransaction().commit();
        System.out.println("Object stored: " + obj);
        pm.close();
    }

    /**
     * Method buildObject.
     * @param className
     * @param optional
     * @return Object
     */
    private static Object buildObject(String className, String[] optional) {
        Object obj = null;
        if("Employee".equals(className)) {
            Employee emp = new Employee(Long.parseLong(optional[0]));
            emp.setFirstName(optional[1]);
            emp.setLastName(optional[2]);
            emp.setEmail(optional[3]);
            obj = emp;
        }
        else if("Address".equals(className)){
            Address add = new Address(Long.parseLong(optional[0]));
            add.setStreetLine1(optional[1]);
            add.setStreetLine2(optional[2]);
            add.setCity(optional[3]);
            add.setState(optional[4]);
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
