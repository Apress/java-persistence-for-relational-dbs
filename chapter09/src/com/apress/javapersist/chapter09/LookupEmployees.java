package com.apress.javapersist.chapter09;

import com.apress.javapersist.chapter09.bo.*;
import org.odmg.*;

public class LookupEmployees {
    
    public static void main(String[] args) {
        try {
            lookupEmployees();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }

    private static void lookupEmployees() throws Exception {
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
            txn.commit();
        }
        catch (Exception e) {
            txn.abort();
            throw e;
        }
        finally {
            db.close();
        }
    }
}
