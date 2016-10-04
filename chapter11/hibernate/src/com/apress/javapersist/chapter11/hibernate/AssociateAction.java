package com.apress.javapersist.chapter11.hibernate;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.apress.javapersist.chapter11.hibernate.bo.Address;
import com.apress.javapersist.chapter11.hibernate.bo.Employee;

public class AssociateAction extends BaseAction {
    public void execute(String[] args) throws Exception {
        String typeName = args[0];
        if("Employee".equals(typeName)) {
            Session session = null;
            try {
                session = getSession();
                
                Employee employee = (Employee) findAll(session, args[1]).next();
                Address address = (Address) findAll(session, args[3]).next();
                System.out.println("About to associate: " + employee + " with " 
                    + address);

                Transaction trans = session.beginTransaction();
                // Actually associate the two classes
                employee.setAddress(address);
                address.addResident(employee);
                trans.commit();
            }
            finally {
                if(session != null) {
                    session.close();
                }
            }
        }
    }

    public String exampleString() {
        return "    Manage assoc Employee \"select statement\" "
            + "Address \"select statement\"";
    }
}
