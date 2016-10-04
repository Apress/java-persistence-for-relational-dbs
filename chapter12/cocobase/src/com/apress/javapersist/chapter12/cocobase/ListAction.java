package com.apress.javapersist.chapter12.cocobase;

import java.util.Iterator;
import java.util.Vector;

import thought.CocoBase.CBFacade;

public class ListAction extends BaseAction {
    private Object className;

    public void execute(String[] args) throws Exception {
    	CBFacade cbFacade = getCBFacade();

        Iterator iter = findAll(cbFacade, args[1], new Vector());
    
        // Run through the objects listing each one
        while( iter.hasNext() ) {
            System.out.println(iter.next());
        }
    }

    public String exampleString() {
        return "    Manage list Employee \"select object(e) from Employee e where e.firstName='FName'\"";
    }
}
