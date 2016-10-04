package com.apress.javapersist.chapter10;

import java.util.HashMap;
import java.util.Iterator;


/**
 * @author rsperko
 *
 * This class is used to interact with any Java Data Objects implementation.
 * I order to change the JDO implementation that is used is modify the 
 * "jdo.properties" file.
 * 
 * Call this class with no arguments to find out how to use it.
 */
public class Manage {
    HashMap actions = new HashMap();
    
    public Manage() {
        actions.put("create", new CreateDatabaseAction());
        actions.put("list", new ListAction());
        actions.put("add", new AddAction());
        actions.put("remove", new RemoveAction());
        actions.put("assoc", new AssociateAction());
    }
    
    private void executeAction(String[] args) {
        if(args.length < 2) {
            usage();
            return;
        }
        String actionStr = args[0];
        String typeName = args[1];
        String[] optional = new String[args.length-2];
        System.arraycopy(args, 2, optional, 0, optional.length);
    
        JDOAction action = (JDOAction) actions.get(actionStr);
        if(action == null) {
            usage();
            return;
        }
        
        action.execute(typeName, optional);
    }
    
    public static void main(String[] args) {
        Manage manage = new Manage();
        manage.executeAction(args);
    }


    /**
     * Method usage.
     */
    private void usage() {
        System.out.println("usage:");
        System.out.println("java com.apress.javapersist.chapter10.Manage <act"
            + "ion> <object type> [arg1] [arg2] [argn]");
        System.out.println("    actions: " + actions.keySet());
        System.out.println();
        System.out.println("Examples:");
        for(Iterator iter = actions.values().iterator(); iter.hasNext(); ) {
            System.out.println(((JDOAction) iter.next()).exampleString());
        }
    }
}
