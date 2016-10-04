package com.apress.javapersist.chapter09;

import com.apress.javapersist.chapter09.bo.*;
import org.odmg.*;

public class ModifyEmployee {
    
    public static void main(String[] args) {
        Implementation impl = ODMGStrategy.getImpl();
        Database db = impl.newDatabase();
        try {
            db.open(ODMGStrategy.getDbIdentifier(), Database.OPEN_READ_WRITE);

            Employee employee1 = null;

            Transaction txn = impl.newTransaction();
            txn.begin();
            employee1 = (Employee) db.lookup("CEO");
            System.out.println( "CEO: " + employee1 );
            txn.lock(employee1, Transaction.WRITE);
            employee1.setEmail("dglyzewski@centare.com");
            txn.commit();

            txn.begin();
            employee1 = (Employee) db.lookup("CEO");
            System.out.println( "CEO: " + employee1 );
            txn.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                db.close();
            } catch (ODMGException e) {}
        }
    }
}
