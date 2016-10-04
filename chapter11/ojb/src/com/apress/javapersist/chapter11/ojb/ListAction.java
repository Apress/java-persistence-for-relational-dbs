package com.apress.javapersist.chapter11.ojb;

import java.util.Iterator;

/**
 * @author rsperko
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ListAction extends BaseAction {
    private Object className;

    /** 
     * List the objects that match the query
     * @see com.apress.javapersist.chapter10.JDOAction#execute(String, String[])
     */
    public void execute(String[] args) throws Exception {
    	Finder finder = new Finder();
    	
        Iterator iter = finder.find(getPersistenceBroker(), args);
        
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
        return "    Manage list Employee \"firstName equals LName\n"
            + "    Manage list Employee all";
    }

}
