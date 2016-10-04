package com.apress.javapersist.chapter11.castorjdo;

import java.util.Iterator;

import org.exolab.castor.jdo.Database;
import org.exolab.castor.jdo.Query;
import org.exolab.castor.jdo.QueryResults;

public class ListAction extends BaseAction {
    private Object className;

    public void execute(String[] args) throws Exception {
        Database database = null;
        try {
            database = getDatabase();
            database.begin();
            QueryResults results = findAll(database, args[1]);
        
            // Run through the objects listing each one
			Object o = null;
            while( results.hasMore() ) {
            	o = results.next();
            	database.lock(o);
                System.out.println(o);
            }
            database.commit();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            if(database != null) {
                database.close();
            }
        }
    }

    public String exampleString() {

        return "    Manage list Employee \"select e from "
            + "com.apress.javapersist.chapter11.castorjdo.bo.Employee e "
            + "where e.id=11\"\n";
    }
}
