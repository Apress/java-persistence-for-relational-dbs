package com.apress.javapersist.chapter09;

import com.apress.javapersist.chapter09.bo.*;
import org.odmg.*;

public class DeleteEmployees {
    
    public static void main(String[] args) {
        try {
            deleteEmployees();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }


    private static void deleteEmployees() throws Exception {
        Implementation impl = ODMGStrategy.getImpl();
        Database db = impl.newDatabase();
        db.open(ODMGStrategy.getDbIdentifier(), Database.OPEN_READ_WRITE);

        Employee employee1 = null;
        Employee employee2 = null;

        Transaction txn = impl.newTransaction();
        try {
            txn.begin();
            employee1 = (Employee) db.lookup("CEO");
            employee2 = (Employee) db.lookup("CTO");
            System.out.println( "CEO: " + employee1 );
            System.out.println( "CTO: " + employee2 );
            db.unbind( "CEO" );
            db.unbind( "CTO" );
            db.deletePersistent(employee1);
            db.deletePersistent(employee2);
            txn.commit();
        }
        catch (Exception e) {
            txn.abort();
            throw e;
        }
        try {
            txn.begin();
            employee1 = (Employee) db.lookup("CEO");
            employee2 = (Employee) db.lookup("CTO");
            System.out.println( "Wrong, shouldn't have reached this" );
        }
        catch( ObjectNameNotFoundException e ) {
            // Good, shouldn't be found
            txn.commit();
        }
        finally {
            db.close();
        }
    }
}
