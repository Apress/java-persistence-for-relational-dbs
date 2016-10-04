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
 * This class is used to associate one object with another.
 */
public class AssociateAction extends JDOAction {
    /**
     * Associate one object with another
     * @see com.apress.javapersist.chapter10.JDOAction#execute(String, String[])
     */
    public void execute(String typeName, String[] optional) {
        if("Employee".equals(typeName)) {
            PersistenceManager pm = getPersistenceManager();
            Employee employee = (Employee) findAll(pm, typeName, 
                optional[0]).next();
            Address address = (Address) findAll(pm, optional[1], 
                optional[2]).next();
            System.out.println("About to associate: " + employee + " with " 
                + address);
                
            pm.currentTransaction().begin();
            // Actually associate the two classes
            employee.setAddress(address);
            address.addResident(employee);
            pm.currentTransaction().commit();
        }
    }

    /**
     * Show how to use this action
     * @see com.apress.javapersist.chapter10.JDOAction#exampleString()
     */
    public String exampleString() {
        return "    Manage assoc Employee \"id==0\" Address \"id==1\"";
    }
}
