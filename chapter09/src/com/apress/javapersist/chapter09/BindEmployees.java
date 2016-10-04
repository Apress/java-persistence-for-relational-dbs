package com.apress.javapersist.chapter09;

import com.apress.javapersist.chapter09.bo.*;
import org.odmg.*;

public class BindEmployees {
    
    public static void main(String[] args) {
        try {
            persistEmployees();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }

    private static void persistEmployees() throws Exception {
        Implementation impl = ODMGStrategy.getImpl();
        Database db = impl.newDatabase();
        db.open(ODMGStrategy.getDbIdentifier(), Database.OPEN_READ_WRITE);

        Transaction txn = impl.newTransaction();
        txn.begin();
        try {
            Employee employee1 = ODMGStrategy.createEmployee1();
            Employee employee2 = ODMGStrategy.createEmployee2();
            db.bind(employee1, "CEO");
            db.bind(employee2, "CTO");
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
