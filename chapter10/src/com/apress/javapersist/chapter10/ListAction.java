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
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ListAction extends JDOAction {
    private Object className;

    /** 
     * List the objects that match the query
     * @see com.apress.javapersist.chapter10.JDOAction#execute(String, String[])
     */
    public void execute(String typeName, String[] optional) {
        PersistenceManager pm = getPersistenceManager();
        Iterator iter = findAll(pm, typeName, optional[0]);
        
        // Run through the objects listing each one
        while( iter.hasNext() ) {
            System.out.println(iter.next());
        }
    }

    /**
     * Show how to use this action
     * @see com.apress.javapersist.chapter10.JDOAction#exampleString()
     */
    public String exampleString() {
        return "    Manage list Employee \"firstName == \\\"LName\\\"\n"
            + "    Manage list Employee extent";
    }

}
