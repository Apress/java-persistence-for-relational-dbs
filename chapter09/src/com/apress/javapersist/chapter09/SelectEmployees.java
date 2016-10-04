package com.apress.javapersist.chapter09;

import com.apress.javapersist.chapter09.bo.*;
import org.odmg.*;

public class SelectEmployees {
    
    public SelectEmployees() {
    }
    
    public static void main(String[] args) {
        Implementation impl = ODMGStrategy.getImpl();
        Database db = impl.newDatabase();
        try {
            db.open(ODMGStrategy.getDbIdentifier(), Database.OPEN_READ_WRITE);

            Transaction txn = impl.newTransaction();
            txn.begin();
            OQLQuery query = impl.newOQLQuery();
            String oql = "select emp from "
                    + Employee.class.getName()
                    + " where firstName = $1";
            query.create( oql );
            query.bind(args[0]);
            System.out.println( query.execute() );
            txn.commit();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        finally {
            try {
                db.close();
            }
            catch(ODMGException e){}
        }
    }
}
