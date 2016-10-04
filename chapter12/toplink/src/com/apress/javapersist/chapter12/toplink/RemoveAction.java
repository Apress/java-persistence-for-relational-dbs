package com.apress.javapersist.chapter12.toplink;

import java.util.Iterator;

import oracle.toplink.publicinterface.UnitOfWork;
import oracle.toplink.sessions.DatabaseSession;

public class RemoveAction extends BaseAction {

    public void execute(String[] args) throws Exception {
        String typeName = args[0];
    	DatabaseSession session = getSession();
		Finder finder = new Finder();

        Iterator results = finder.find(session, args);
        
        UnitOfWork unitOfWork = session.acquireUnitOfWork();
        // Run through the list of objects deleting each one
        while(results.hasNext()) {
          unitOfWork.deleteObject(results.next());
        }
        // apply all deletes to database
        unitOfWork.commit();
    }

    public String exampleString() {
        return "    Manage remove Employee lastName equals LName";
    }

}
