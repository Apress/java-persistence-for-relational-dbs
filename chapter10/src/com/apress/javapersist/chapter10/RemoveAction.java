/**
 * Created on Jan 31, 2003
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package com.apress.javapersist.chapter10;

import java.util.Iterator;
import javax.jdo.PersistenceManager;

/**
 * @author rsperko
 *
 * Remove any objects that match the criteria
 */
public class RemoveAction extends JDOAction {

    /**
     * Remove all instances that match the query
     * @see com.apress.javapersist.chapter10.JDOAction#execute(String, String[])
     */
    public void execute(String typeName, String[] optional) {
        PersistenceManager pm = getPersistenceManager();
        Iterator results = findAll(pm, typeName, optional[0]);
        
        pm.currentTransaction().begin();
        // Run through the list of objects deleting each one
        while(results.hasNext())
          pm.deletePersistent(results.next());
        pm.currentTransaction().commit();
    }

    /**
     * Show how to use this action
     * @see com.apress.javapersist.chapter10.JDOAction#exampleString()
     */
    public String exampleString() {
        return "    Manage remove Employee \"lastName == \\\"LName\\\"";
    }

}
