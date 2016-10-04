package com.apress.javapersist.chapter11.hibernate;


import java.util.Iterator;

import net.sf.hibernate.cfg.Configuration;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;

public abstract class BaseAction {
    private static SessionFactory factory = null;
    
    protected Session getSession() throws Exception {
        if (factory == null) {
        	// Loads hibernate.properties from the classpath
        	Configuration conf = new Configuration();
        	
        	// read mapping.xml from the classpath
        	conf.addResource("mapping.xml", getClass().getClassLoader());

            factory = conf.buildSessionFactory();
            
        }
        return factory.openSession();
    }


    protected Iterator findAll(Session session, String queryStr) throws Exception {
    	Query query = session.createQuery(queryStr);
    	return query.iterate();
    }


    public abstract void execute(String[] args) throws Exception;
    
    
    public abstract String exampleString();
}
