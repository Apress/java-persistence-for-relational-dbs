package com.apress.javapersist.chapter11.hibernate;

import java.util.Iterator;

import net.sf.hibernate.Session;

public class ListAction extends BaseAction {
    private Object className;

    public void execute(String[] args) throws Exception {
        Session session = null;
        try {
        	session = getSession();
	        Iterator iter = findAll(session, args[1]);
        
	        // Run through the objects listing each one
	        while( iter.hasNext() ) {
	            System.out.println(iter.next());
	        }
        }
        finally {
    		if(session != null) {
		        session.close();
    		}
        }
    }

    public String exampleString() {
        return "    Manage list Employee \"select statement\"\n";
    }
}
