/**
 * Created on Jan 31, 2003
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package com.apress.javapersist.chapter11.ojb;

import java.util.Iterator;

/**
 * @author rsperko
 *
 * Remove any objects that match the criteria
 */
public class RemoveAction extends BaseAction {

    /**
     * Remove all instances that match the query
     * @see com.apress.javapersist.chapter10.JDOAction#execute(String, String[])
     */
    public void execute(String[] args) throws Exception {
    	Finder finder = new Finder();
    	
        Iterator iter = finder.find(getPersistenceBroker(), args);
        
        getPersistenceBroker().beginTransaction();
        // Run through the list of objects deleting each one
        while(iter.hasNext())
          getPersistenceBroker().delete(iter.next());
        getPersistenceBroker().commitTransaction();
    }

    /**
     * Show how to use this action
     * @see com.apress.javapersist.chapter10.JDOAction#exampleString()
     */
    public String exampleString() {
        return "    Manage remove Employee lastName equals LName";
    }

}
