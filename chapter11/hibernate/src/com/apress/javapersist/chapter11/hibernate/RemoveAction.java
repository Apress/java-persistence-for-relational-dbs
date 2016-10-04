package com.apress.javapersist.chapter11.hibernate;

import java.util.Iterator;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

public class RemoveAction extends BaseAction {

    public void execute(String[] args) throws Exception {
        String typeName = args[0];
        Session session = null;
        try {
            session = getSession();
            Iterator results = findAll(session, args[1]);
            
            Transaction trans = session.beginTransaction();
            // Run through the list of objects deleting each one
            while(results.hasNext()) {
              session.delete(results.next());
            }
            trans.commit();
        }
        finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public String exampleString() {
        return "    Manage remove Employee \"select statement\"";
    }

}
