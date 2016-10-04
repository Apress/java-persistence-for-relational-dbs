
package com.apress.javapersist.chapter11.castorjdo;

import java.util.Iterator;

import org.exolab.castor.jdo.Database;
import org.exolab.castor.jdo.QueryResults;


public class RemoveAction extends BaseAction {
    public void execute(String[] args) throws Exception {
        Database database = null;
        try {
        	database = getDatabase();
	        QueryResults results = findAll(database, args[1]);
        
	        database.begin();
	        // Run through the list of objects deleting each one
	        while(results.hasMore())
				database.remove(results.next());
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

    public String exampleString() {
        return "    Manage remove Employee \"select e from "
            + "com.apress.javapersist.chapter11.castorjdo.bo.Employee e "
            + "where e.id=11\"\n";
    }
}
