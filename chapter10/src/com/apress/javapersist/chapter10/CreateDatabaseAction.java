/**
 * Created on Jan 31, 2003
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package com.apress.javapersist.chapter10;

import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

/**
 * @author rsperko
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class CreateDatabaseAction extends JDOAction {
    /**
     * Method createDatabase will instantiate a new database if needed.
     * @param typeName
     */
    public void execute(String typeName, String[] optional) {
        if("jdori".equals(typeName))
            createJDORIDatabase();
        else
            System.out.println("ERROR: I don't know how to create a " 
                + typeName + " database");
    }


    /**
     * Method createDatabase.
     */
    private void createJDORIDatabase() {
        try {
            Properties props = loadProperties();
            props.put("com.sun.jdori.option.ConnectionCreate", "true");
            PersistenceManagerFactory pmf =
                JDOHelper.getPersistenceManagerFactory(props);
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            tx.begin();
            tx.commit();
            pm.close();
        } catch(Exception e) {
            System.err.println("Exception creating the database");
            System.err.println(e);
            System.exit(-1);
        }
    }



    /**
     * Show how to use this action
     * @see com.apress.javapersist.chapter10.JDOAction#exampleString()
     */
    public String exampleString() {
        return "    Manage create jdori";
    }
}
