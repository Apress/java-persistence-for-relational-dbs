package com.apress.javapersist.chapter09;

import com.apress.javapersist.chapter09.bo.*;
import org.odmg.*;

public class PersistEmployee {

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
            Employee employee3 = ODMGStrategy.createEmployee3();
            db.makePersistent(employee3);
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
