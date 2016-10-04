package com.apress.javapersist.chapter12.cocobase;

import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

import thought.CocoBase.CBFacade;


public abstract class BaseAction {
	public final static String EMPLOYEE_MAP
		= "com.apress.javapersist.chapter12.cocobase.bo.Employee";
	public final static String ADDRESS_MAP
		= "com.apress.javapersist.chapter12.cocobase.bo.Address";
    
    protected CBFacade getCBFacade() throws Exception {
        String url 
            = "jdbc:mysql://localhost/chapter12"
                + ":cocoprop="
                + "dynamic.querying=true,"
                + "cocojdbc.autocommit=false";
    
        Properties props = new Properties();
        props.setProperty("cocosource.name", "thought.CocoBase.CocoPowder");
        props.setProperty("cocosource.jdbcdriver", "com.mysql.jdbc.Driver");
        props.setProperty("cocosource.url", url);
        props.setProperty("cocosource.user", "root");
        props.setProperty("cocosource.password", "password"); 
        props.setProperty("cocosource.factory", 
            "com.apress.javapersist.chapter12.cocobase.BusinessObjectFactory"); 
        props.setProperty("cocosource.navmodel", "HRAppLinks"); 
        props.setProperty("cocosource.autotrans", "false"); 
        
        CBFacade facade = CBFacade.create("thought.CocoBase.CBFacadeLocal");
        facade.connect(props);
        return facade;
    }

    protected Iterator findAll(CBFacade cbFacade, String queryStr, Vector args) 
        throws Exception {
        Vector results = cbFacade.executeQLQuery(queryStr, args);
        return results.iterator();
    }

    public abstract void execute(String[] args) throws Exception;
    
    
    public abstract String exampleString();
}
