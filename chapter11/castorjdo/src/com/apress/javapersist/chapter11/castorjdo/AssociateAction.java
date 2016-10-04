package com.apress.javapersist.chapter11.castorjdo;

import org.exolab.castor.jdo.Database;

import com.apress.javapersist.chapter11.castorjdo.bo.Address;
import com.apress.javapersist.chapter11.castorjdo.bo.Employee;

public class AssociateAction extends BaseAction {
    public void execute(String[] args) throws Exception {
        String typeName = args[0];
        if("Employee".equals(typeName)) {
            Database database = null;
            try {
                database = getDatabase();
                
                database.begin();
                Employee employee = (Employee) findAll(database, args[1]).next();
                Address address = (Address) findAll(database, args[3]).next();
                System.out.println("About to associate: " + employee + " with " 
                    + address);

                // Actually associate the two classes
                employee.setAddress(address);
                address.addResident(employee);
                database.commit();
            }
            catch(Exception e) {
            	database.rollback();
            	throw e;
            }
            finally {
                if(database != null) {
                    database.close();
                }
            }
        }
    }

    public String exampleString() {
        return "    Manage assoc Employee \"select e from "
            + "com.apress.javapersist.chapter11.castorjdo.bo.Employee e "
            + "where e.id=11\" Address \"select e from "
            + "com.apress.javapersist.chapter11.castorjdo.bo.Address a "
            + "where a.id=121\"";
    }
}
