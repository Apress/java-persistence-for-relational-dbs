package com.apress.javapersist.chapter12.cocobase;

import java.util.Iterator;
import java.util.Vector;

import thought.CocoBase.CBFacade;

public class RemoveAction extends BaseAction {

    public void execute(String[] args) throws Exception {
    	CBFacade cbFacade = getCBFacade();

        Iterator results = findAll(cbFacade, args[1], new Vector());
        
        cbFacade.beginTransaction();
        
        // Run through the list of objects deleting each one
        while(results.hasNext()) {
          cbFacade.delete(results.next());
        }
        // apply all deletes to database
        cbFacade.commit();
    }

    public String exampleString() {
        return "    Manage remove Employee \"select object(e) from Employee e where e.firstName='FName'\"";
    }
}
