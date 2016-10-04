package com.apress.javapersist.chapter12.toplink;

import java.util.Iterator;

import oracle.toplink.sessions.DatabaseSession;

public class ListAction extends BaseAction {
    private Object className;

    public void execute(String[] args) throws Exception {
    	DatabaseSession session = getSession();
		Finder finder = new Finder();

        Iterator iter = finder.find(session, args);
    
        // Run through the objects listing each one
        while( iter.hasNext() ) {
            System.out.println(iter.next());
        }
    }

    public String exampleString() {
        return "    Manage list Employee firstName equals LName\n"
            + "    Manage list Employee all";
    }
}
