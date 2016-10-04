package com.apress.javapersist.chapter12.cocobase;

import java.util.HashMap;
import java.util.Iterator;


public class Manage {
    HashMap actions = new HashMap();
    
    public Manage() {
        actions.put("list", new ListAction());
        actions.put("add", new AddAction());
        actions.put("remove", new RemoveAction());
        actions.put("assoc", new AssociateAction());
    }
    
    private void executeAction(String[] args) throws Exception {
        if(args.length < 2) {
            usage();
            return;
        }
        String actionStr = args[0];
        String[] cmdArgs = new String[args.length-1];
        System.arraycopy(args, 1, cmdArgs, 0, cmdArgs.length);
    
        BaseAction action = (BaseAction) actions.get(actionStr);
        if(action == null) {
            usage();
            return;
        }
        
        action.execute(cmdArgs);
    }
    
    public static void main(String[] args) {
        Manage manage = new Manage();
        try {
        	manage.executeAction(args);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }


    private void usage() {
        System.out.println("usage:");
        System.out.println("java com.apress.javapersist.chapter12.cocobase.Manage <act"
            + "ion> [arg1] [arg2] [argn]");
        System.out.println("    actions: " + actions.keySet());
        System.out.println();
        System.out.println("Examples:");
        for(Iterator iter = actions.values().iterator(); iter.hasNext(); ) {
            System.out.println(((BaseAction) iter.next()).exampleString());
        }
    }
}
